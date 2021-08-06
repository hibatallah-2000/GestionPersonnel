package com.exemple.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name ="conjoint")
public class Conjoint {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Conjoint() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Column(name = "nom")
	private String nom;
	@Column(name = "prenom")
	private String prenom;
	@Column(name = "date_de_naissance")
	private Date date_de_naissance;
	@Column(name = "sexe")
	private String sexe;
	@Column(name = "cin_conjoint")
	private String cin_conjoint;
	@Column(name = "date_mariage")
	private Date date_mariage;
	@OneToOne(mappedBy="conjoint")
	private Personnel personnel;

	public Personnel getPersonnel() {
		return personnel;
	}

	public void setPersonnel(Personnel personnel) {
		this.personnel = personnel;
	}

	public Conjoint(Long id, String nom, String prenom, Date date_de_naissance, String sexe, String cin_conjoint,
			Date date_mariage) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.date_de_naissance = date_de_naissance;
		this.sexe = sexe;
		this.cin_conjoint = cin_conjoint;
		this.date_mariage = date_mariage;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDate_de_naissance() {
		return date_de_naissance;
	}

	public void setDate_de_naissance(Date date_de_naissance) {
		this.date_de_naissance = date_de_naissance;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getCin_conjoint() {
		return cin_conjoint;
	}

	public void setCin_conjoint(String cin_conjoint) {
		this.cin_conjoint = cin_conjoint;
	}

	public Date getDate_mariage() {
		return date_mariage;
	}

	public void setDate_mariage(Date date_mariage) {
		this.date_mariage = date_mariage;
	}

	
}
