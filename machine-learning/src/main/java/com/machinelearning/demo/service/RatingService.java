package com.machinelearning.demo.service;

import com.machinelearning.demo.api.dto.RatingDTO;

import java.util.Set;

public interface RatingService {
    Set<RatingDTO> getAllRatingProduct();

    RatingDTO getSingleRating(Integer ratingId);
}
