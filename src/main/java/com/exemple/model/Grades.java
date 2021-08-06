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
@Table(name ="grades")
public class Grades {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Grades() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Column(name = "code_grade")
	private String code_grade;
	@Column(name = "type_grade")
	private String type_grade;
	@JsonIgnore
    @OneToMany(mappedBy="grades")
	private Set<Personnel> personnels= new HashSet<>();
	public Set<Personnel> getPersonnels() {
		return personnels;
	}
	public void setPersonnels(Set<Personnel> personnels) {
		this.personnels = personnels;
	}
	public Grades(Long id, String code_grade, String type_grade, String intitule_groupe, String statut) {
		super();
		this.id = id;
		this.code_grade = code_grade;
		this.type_grade = type_grade;
		this.intitule_groupe = intitule_groupe;
		this.statut = statut;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode_grade() {
		return code_grade;
	}
	public void setCode_grade(String code_grade) {
		this.code_grade = code_grade;
	}
	public String getType_grade() {
		return type_grade;
	}
	public void setType_grade(String type_grade) {
		this.type_grade = type_grade;
	}
	public String getIntitule_groupe() {
		return intitule_groupe;
	}
	public void setIntitule_groupe(String intitule_groupe) {
		this.intitule_groupe = intitule_groupe;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	@Column(name = "intitule_groupe")
	private String intitule_groupe;
	@Column(name = "statut")
	private String statut;
}
