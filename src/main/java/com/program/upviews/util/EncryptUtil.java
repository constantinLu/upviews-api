package com.program.upviews.eresume.util;

import com.program.upviews.exceptions.custom.EncryptException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@ConfigurationProperties(prefix = "encrypt")
@Setter
@Getter
@NoArgsConstructor
public class EncryptUtil {

    private static SecretKeySpec secretKey;
    private String secret;
    private boolean disable;
    private Cipher instance;

    public EncryptUtil(String secret, boolean disable) {
        this.secret = secret;
        this.disable = disable;
    }

    private Cipher getCipher() {
        if (instance == null) {
            synchronized (Cipher.class) {
                if (instance == null) {
                    try {
                        instance = Cipher.getInstance("AES/ECB/PKCS5Padding");
                    } catch (NoSuchPaddingException | EncryptException | NoSuchAlgorithmException e) {
                        log.error("No such padding exists");
                        throw new EncryptException("No such padding exists");
                    }
                }
            }
        }
        return instance;
    }

    private void setKey() {
        byte[] key;
        try {
            key = secret.getBytes(StandardCharsets.UTF_8);
            MessageDigest sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, "AES");
        } catch (NoSuchAlgorithmException e) {
            log.error("No such algorithm exists");
            throw new EncryptException("No such algorithm exists");
        }
    }

    public synchronized String encrypt(Long id) {
        if (id == null) {
            log.error("ID is null");
            throw new EncryptException("ID is null");
        }

        if (disable) {
            return id.toString();
        }

        try {
            setKey();
            getCipher().init(Cipher.ENCRYPT_MODE, secretKey);
            String stringId = id.toString();
            String encryptString = Base64.getEncoder().encodeToString(getCipher().doFinal(stringId.getBytes(StandardCharsets.UTF_8)));
            encryptString = encryptString.replace('+', '-').replace('/', '_')
                    .replace("%", "%25").replace("\n", "%0A");
            return encryptString;
        } catch (InvalidKeyException | BadPaddingException | IllegalBlockSizeException e) {
            log.error("Error while encrypting: " + e.toString());
            throw new EncryptException("Bad request");
        }
    }

    public synchronized Long decrypt(String strToDecrypt) {
        if (strToDecrypt == null) {
            log.error("String to decrypt is null");
            throw new EncryptException("String to decrypt is null");
        }

        if (disable) {
            return Long.parseLong(strToDecrypt);
        }

        String stringToDecrypt = strToDecrypt.replace('-', '+').replace('_', '/')
                .replace("%25", "%").replace("%0A", "\n");
        try {
            setKey();
            getCipher().init(Cipher.DECRYPT_MODE, secretKey);
            String stringId = new String(getCipher().doFinal(Base64.getDecoder().decode(stringToDecrypt)));
            return Long.parseLong(stringId);
        } catch (InvalidKeyException | BadPaddingException | IllegalBlockSizeException | IllegalArgumentException e) {
            log.error("Error while decrypting: " + e.toString());
            throw new EncryptException("Bad request");
        }
    }
}
