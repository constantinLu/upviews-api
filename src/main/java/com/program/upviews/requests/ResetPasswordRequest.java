package com.program.upviews.requests;


import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResetPasswordRequest {

    private String newPassword;

    private String reTypeNewPassword;
}
