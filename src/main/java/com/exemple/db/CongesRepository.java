package com.exemple.db;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exemple.model.Conges;

public interface CongesRepository extends JpaRepository<Conges, Long> {

}
