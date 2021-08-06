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
@Table(name ="directions")
public class Directions {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Directions() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Column(name = "type_direction")
	private String type_direction;
	@JsonIgnore
    @OneToMany(mappedBy="directions")
	private Set<Division> divisions= new HashSet<>();

	public Set<Division> getDivisions() {
		return divisions;
	}
	public void setDivisions(Set<Division> divisions) {
		this.divisions = divisions;
	}
	public Directions(Long id, String type_direction) {
		super();
		this.id = id;
		this.type_direction = type_direction;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getType_direction() {
		return type_direction;
	}
	public void setType_direction(String type_direction) {
		this.type_direction = type_direction;
	}
}
