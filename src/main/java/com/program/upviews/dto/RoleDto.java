package com.program.upviews.dto;

import com.program.upviews.common.Role;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoleDto {

    private String id;

    private Role role;
}
