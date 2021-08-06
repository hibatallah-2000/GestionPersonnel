package com.exemple.db;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exemple.model.Directions;

public interface DirectionsRepository extends JpaRepository<Directions, Long>{

}
