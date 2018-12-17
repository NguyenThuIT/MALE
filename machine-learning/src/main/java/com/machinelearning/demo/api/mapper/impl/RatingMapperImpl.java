package com.machinelearning.demo.api.mapper.impl;

import com.machinelearning.demo.api.dto.RatingDTO;
import com.machinelearning.demo.api.mapper.RatingMapper;
import com.machinelearning.demo.domain.Rating;
import org.springframework.stereotype.Component;

@Component
public class RatingMapperImpl implements RatingMapper {

    @Override
    public RatingDTO ratingToRatingDTO(Rating rating) {
        if (rating==null)return null;
        else {
            RatingDTO ratingDTO = new RatingDTO();
            ratingDTO.setRateId(rating.getRateId());
            ratingDTO.setRatingCount(rating.getRatingCount());
            ratingDTO.setAccountUsername(rating.getAccount().getUsername());
            ratingDTO.setItemId(rating.getItem().getId());
            return ratingDTO;
        }
    }
}
