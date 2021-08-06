package com.exemple.db;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exemple.model.Mutuelle;

public interface MutuelleRepository extends JpaRepository<Mutuelle, Long> {

}
