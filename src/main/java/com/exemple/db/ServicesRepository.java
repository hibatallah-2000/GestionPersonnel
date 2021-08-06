package com.exemple.db;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exemple.model.Services;

public interface ServicesRepository extends JpaRepository<Services, Long> {

}
