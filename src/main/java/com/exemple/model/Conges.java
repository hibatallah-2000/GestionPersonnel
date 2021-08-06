package com.exemple.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name ="conges")
public class Conges {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Conges() {
		super();
		// TODO Auto-generated constructor stub
	} 
	@Column(name = "motif")
	private String motif;
	@Column(name = "date_depart")
	private Date date_depart;
	@Column(name = "date_retour")
	private Date date_retour;
	@Column(name = "nbr_jour")
	private Integer nbr_jour;
	@JsonIgnore
	@ManyToMany(mappedBy="enrolledConges")
	private Set<Personnel> personnels=new HashSet<>();
	

	public Set<Personnel> getPersonnels() {
		return personnels;
	}
	public void setPersonnels(Set<Personnel> personnels) {
		this.personnels = personnels;
	}
	public Conges(Long id, String motif, Date date_depart, Date date_retour, Integer nbr_jour) {
		super();
		this.id = id;
		this.motif = motif;
		this.date_depart = date_depart;
		this.date_retour = date_retour;
		this.nbr_jour = nbr_jour;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMotif() {
		return motif;
	}
	public void setMotif(String motif) {
		this.motif = motif;
	}
	public Date getDate_depart() {
		return date_depart;
	}
	public void setDate_depart(Date date_depart) {
		this.date_depart = date_depart;
	}
	public Date getDate_retour() {
		return date_retour;
	}
	public void setDate_retour(Date date_retour) {
		this.date_retour = date_retour;
	}
	public Integer getNbr_jour() {
		return nbr_jour;
	}
	public void setNbr_jour(Integer nbr_jour) {
		this.nbr_jour = nbr_jour;
	}
}
