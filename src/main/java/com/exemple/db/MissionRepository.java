package com.exemple.db;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exemple.model.Mission;

public interface MissionRepository extends JpaRepository<Mission, Long> {

}
