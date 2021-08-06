package com.exemple.db;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exemple.model.Diplome;

public interface DiplomeRepository extends JpaRepository<Diplome, Long> {

}
