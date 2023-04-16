package com.emre.repository;

import com.emre.repository.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRestaurantRepository extends JpaRepository<Restaurant,Long> {
    Optional<Restaurant> findOptionalByRestaurantId(Long id);
}
