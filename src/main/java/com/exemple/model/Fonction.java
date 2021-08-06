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
@Table(name ="fonction")
public class Fonction {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Fonction() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Column(name = "type_fonction")
	private String type_fonction;
	@Column(name = "date_prise")
	private Date date_prise;
	@JsonIgnore
    @OneToMany(mappedBy="fonction")
	private Set<Personnel> personnels= new HashSet<>();

	public Set<Personnel> getPersonnels() {
		return personnels;
	}

	public void setPersonnels(Set<Personnel> personnels) {
		this.personnels = personnels;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType_fonction() {
		return type_fonction;
	}

	public void setType_fonction(String type_fonction) {
		this.type_fonction = type_fonction;
	}

	public Date getDate_prise() {
		return date_prise;
	}

	public void setDate_prise(Date date_prise) {
		this.date_prise = date_prise;
	}

	public Fonction(Long id, String type_fonction, Date date_prise) {
		super();
		this.id = id;
		this.type_fonction = type_fonction;
		this.date_prise = date_prise;
	}
}
