package com.exemple.db;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exemple.model.Grades;

public interface GradesRepository extends JpaRepository<Grades, Long> {

}
