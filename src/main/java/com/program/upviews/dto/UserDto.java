package com.program.upviews.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    private String id;

    private String userName;

    private String password;

    private String resetToken;
}
