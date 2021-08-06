package com.exemple.db;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exemple.model.Division;

public interface DivisionRepository extends JpaRepository<Division, Long> {

}
