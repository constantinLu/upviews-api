package com.program.upviews.configuration;

import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.OAuthTokenCredential;
import com.paypal.base.rest.PayPalRESTException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaypalConfig {

    @Value("${paypal.client.id}")
    private String clientId;

    @Value("${paypal.mode}")
    private String mode;

    @Value("${paypal.client.secret}")
    private String secret;

    @Bean
    public Map<String, String> paypalModeConfig() {
        Map<String, String> payPalConfig = new HashMap<>();
        payPalConfig.put("mode", mode);
        return payPalConfig;
    }

    @Bean
    public OAuthTokenCredential oathTokenCredential() {
        return new OAuthTokenCredential(clientId, secret, paypalModeConfig());
    }

    @Bean
    public APIContext apiContext() throws PayPalRESTException {
        APIContext context = new APIContext(oathTokenCredential().getAccessToken());
        context.setConfigurationMap(paypalModeConfig());
        return context;
    }
}
