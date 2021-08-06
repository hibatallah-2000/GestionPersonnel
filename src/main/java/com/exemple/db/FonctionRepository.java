package com.exemple.db;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exemple.model.Fonction;

public interface FonctionRepository extends JpaRepository<Fonction, Long> {

}
