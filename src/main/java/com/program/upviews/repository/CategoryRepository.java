package com.program.upviews.repository;

import com.program.upviews.common.Category;
import com.program.upviews.entity.CategoryEntity;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<CategoryEntity, Long> {

    CategoryEntity findByCategory(Category category);
}
