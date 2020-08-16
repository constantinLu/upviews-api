package com.program.upviews.configuration.flutter;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EpisodeItemResponse {

    List<EpisodeItemModel> episodes;

}
