package com.program.upviews.dto;

import com.program.upviews.common.Status;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StatusDto {

    private String id;

    private Status status;
}
