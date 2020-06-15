package com.program.upviews.dto;

import com.program.upviews.common.Rank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RankDto {

    private String id;

    private Rank rank;
}
