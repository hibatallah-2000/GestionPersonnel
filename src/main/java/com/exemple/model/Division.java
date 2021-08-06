package com.exemple.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name ="division")
public class Division {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Division() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Column(name = "division_affectation")
	private String division_affectation;
	@Column(name = "code_global")
	private Integer code_global;
	@Column(name = "siege")
	private String siege;
	@Column(name = "date_affectation")
	private Date date_affectation;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="directions_id",referencedColumnName="id")
	private Directions directions;
	@JsonIgnore
    @OneToMany(mappedBy="divisions")
	private Set<Services> services= new HashSet<>();
	@JsonIgnore
    @OneToMany(mappedBy="division")
	private Set<Personnel> personnels= new HashSet<>();
	

	public Set<Personnel> getPersonnels() {
		return personnels;
	}
	public void setPersonnels(Set<Personnel> personnels) {
		this.personnels = personnels;
	}
	public Set<Services> getServices() {
		return services;
	}
	public void setServices(Set<Services> services) {
		this.services = services;
	}
	public Directions getDirections() {
		return directions;
	}
	public void setDirections(Directions directions) {
		this.directions = directions;
	}
	public Division(Long id, String division_affectation, Integer code_global, String siege, Date date_affectation) {
		super();
		this.id = id;
		this.division_affectation = division_affectation;
		this.code_global = code_global;
		this.siege = siege;
		this.date_affectation = date_affectation;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDivision_affectation() {
		return division_affectation;
	}
	public void setDivision_affectation(String division_affectation) {
		this.division_affectation = division_affectation;
	}
	public Integer getCode_global() {
		return code_global;
	}
	public void setCode_global(Integer code_global) {
		this.code_global = code_global;
	}
	public String getSiege() {
		return siege;
	}
	public void setSiege(String siege) {
		this.siege = siege;
	}
	public Date getDate_affectation() {
		return date_affectation;
	}
	public void setDate_affectation(Date date_affectation) {
		this.date_affectation = date_affectation;
	}
	public void assignDirections(Directions directions) {
		this.directions=directions;
	}
}
