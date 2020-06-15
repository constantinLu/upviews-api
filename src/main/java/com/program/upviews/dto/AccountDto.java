package com.program.upviews.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountDto {

    private String id;

    private String firstName;

    private String lastName;

    private String email;
}
