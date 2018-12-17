package com.machinelearning.demo.api.mapper;

import com.machinelearning.demo.api.dto.RatingDTO;
import com.machinelearning.demo.domain.Rating;

public interface RatingMapper {
    RatingDTO ratingToRatingDTO(Rating rating);
}
