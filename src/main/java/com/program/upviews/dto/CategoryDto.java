package com.program.upviews.dto;

import com.program.upviews.common.Category;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryDto {

    private String id;

    private Category category;
}
