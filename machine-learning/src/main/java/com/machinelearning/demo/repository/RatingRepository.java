package com.machinelearning.demo.repository;

import com.machinelearning.demo.domain.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating, Integer> {
}
