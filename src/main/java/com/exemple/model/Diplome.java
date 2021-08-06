package com.exemple.model;

import java.sql.Date;
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
@Table(name ="diplome")
public class Diplome {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Diplome() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Column(name = "type_diplome")
	private String type_diplome;
	@Column(name = "date_diplomation")
	private Date date_diplomation;
	@Column(name = "etablissement")
	private String etablissement;
	@Column(name = "specialite")
	private String specialite;
	@Column(name = "filiere")
	private String filiere;
	@JsonIgnore
    @OneToMany(mappedBy="diplome")
	private Set<Personnel> personnels= new HashSet<>();

	public Set<Personnel> getPersonnels() {
		return personnels;
	}
	public void setPersonnels(Set<Personnel> personnels) {
		this.personnels = personnels;
	}
	public Diplome(Long id, String type_diplome, Date date_diplomation, String etablissement, String specialite,
			String filiere) {
		super();
		this.id = id;
		this.type_diplome = type_diplome;
		this.date_diplomation = date_diplomation;
		this.etablissement = etablissement;
		this.specialite = specialite;
		this.filiere = filiere;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getType_diplome() {
		return type_diplome;
	}
	public void setType_diplome(String type_diplome) {
		this.type_diplome = type_diplome;
	}
	public Date getDate_diplomation() {
		return date_diplomation;
	}
	public void setDate_diplomation(Date date_diplomation) {
		this.date_diplomation = date_diplomation;
	}
	public String getEtablissement() {
		return etablissement;
	}
	public void setEtablissement(String etablissement) {
		this.etablissement = etablissement;
	}
	public String getSpecialite() {
		return specialite;
	}
	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}
	public String getFiliere() {
		return filiere;
	}
	public void setFiliere(String filiere) {
		this.filiere = filiere;
	}
}
