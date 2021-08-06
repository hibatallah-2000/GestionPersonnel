package com.exemple.db;
import com.exemple.model.Personnel;


import org.springframework.data.jpa.repository.JpaRepository;



public interface PersonnelRepository extends JpaRepository<Personnel, Long>  {
	 


}
