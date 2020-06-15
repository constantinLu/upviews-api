package com.program.upviews.requests;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChangePasswordRequest {

    private String password;

    private String newPassword;

    private String reTypeNewPassword;

    
}
