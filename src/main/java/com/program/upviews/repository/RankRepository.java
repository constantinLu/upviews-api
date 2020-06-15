package com.program.upviews.repository;

import com.program.upviews.common.Category;
import com.program.upviews.common.Rank;
import com.program.upviews.entity.CategoryEntity;
import com.program.upviews.entity.RankEntity;
import org.springframework.data.repository.CrudRepository;

public interface RankRepository extends CrudRepository<RankEntity, Long> {

    RankEntity findByRankType(Rank rank);
}
