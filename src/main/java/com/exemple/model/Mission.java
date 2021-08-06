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
@Table(name ="mission")
public class Mission {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Mission() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Column(name = "destination")
	private String destination;
	@Column(name = "date_depart")
	private Date date_depart;
	@Column(name = "date_retour")
	private Date date_retour;
	@Column(name = "objet")
	private String objet;
	@Column(name = "mode_transport")
	private String mode_transport;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="personnel_id",referencedColumnName="id")
	private Personnel personnel;
	public Personnel getPersonnel() {
		return personnel;
	}

	public void setPersonnel(Personnel personnel) {
		this.personnel = personnel;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
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

	public String getObjet() {
		return objet;
	}

	public void setObjet(String objet) {
		this.objet = objet;
	}

	public String getMode_transport() {
		return mode_transport;
	}

	public void setMode_transport(String mode_transport) {
		this.mode_transport = mode_transport;
	}

	public Mission(Long id, String destination, Date date_depart, Date date_retour, String objet,
			String mode_transport) {
		super();
		this.id = id;
		this.destination = destination;
		this.date_depart = date_depart;
		this.date_retour = date_retour;
		this.objet = objet;
		this.mode_transport = mode_transport;
	}
	public void assignPersonnel(Personnel personnel) {
		this.personnel=personnel;
	}}
