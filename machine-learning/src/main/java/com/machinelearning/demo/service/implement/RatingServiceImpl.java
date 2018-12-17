package com.machinelearning.demo.service.implement;

import com.machinelearning.demo.api.dto.RatingDTO;
import com.machinelearning.demo.api.mapper.RatingMapper;
import com.machinelearning.demo.domain.Rating;
import com.machinelearning.demo.exception.ResourceNotFoundException;
import com.machinelearning.demo.repository.RatingRepository;
import com.machinelearning.demo.service.RatingService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RatingServiceImpl implements RatingService {

    private final RatingRepository ratingRepository;
    private final RatingMapper ratingMapper;

    public RatingServiceImpl(RatingRepository ratingRepository, RatingMapper ratingMapper) {
        this.ratingRepository = ratingRepository;
        this.ratingMapper = ratingMapper;
    }

    @Override
    public Set<RatingDTO> getAllRatingProduct() {
        return ratingRepository.findAll().stream().map(ratingMapper::ratingToRatingDTO).collect(Collectors.toSet());
    }

    @Override
    public RatingDTO getSingleRating(Integer ratingId) {
        Optional<Rating> optionalRating = ratingRepository.findById(ratingId);
        if (optionalRating.isPresent()){
            return ratingMapper.ratingToRatingDTO(optionalRating.get());
        }
        else {
            throw new ResourceNotFoundException("Rating " + ratingId + " not found");
        }
    }
}
