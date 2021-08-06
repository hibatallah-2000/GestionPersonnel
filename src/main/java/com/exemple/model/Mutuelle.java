package com.exemple.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name ="mutuelle")
public class Mutuelle {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Mutuelle() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Column(name = "type_mutuelle")
	private String type_mutuelle;
	@JsonIgnore
    @OneToMany(mappedBy="mutuelle")
	private Set<Personnel> personnels= new HashSet<>();

	public Set<Personnel> getPersonnels() {
		return personnels;
	}
	public void setPersonnels(Set<Personnel> personnels) {
		this.personnels = personnels;
	}
	public Mutuelle(Long id, String type_mutuelle) {
		super();
		this.id = id;
		this.type_mutuelle = type_mutuelle;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getType_mutuelle() {
		return type_mutuelle;
	}
	public void setType_mutuelle(String type_mutuelle) {
		this.type_mutuelle = type_mutuelle;
	}
}
