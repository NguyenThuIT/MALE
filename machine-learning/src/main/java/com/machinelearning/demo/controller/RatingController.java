package com.machinelearning.demo.controller;

import com.machinelearning.demo.api.dto.RatingDTO;
import com.machinelearning.demo.service.RatingService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RequestMapping("/rating")
@RestController
public class RatingController {

    private final RatingService ratingService;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public Set<RatingDTO> getAllRating(){
        return ratingService.getAllRatingProduct();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RatingDTO getSingleRating(@PathVariable("id") Integer ratingId){
        return ratingService.getSingleRating(ratingId);
    }
}
