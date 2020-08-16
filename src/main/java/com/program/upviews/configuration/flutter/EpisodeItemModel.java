package com.program.upviews.configuration.flutter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EpisodeItemModel {

    private String title;
    private Double duration;
    private String imageUrl;
}
