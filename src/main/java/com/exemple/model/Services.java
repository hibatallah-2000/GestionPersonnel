package com.exemple.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="services")
public class Services {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Services() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Services(Long id, String type_service) {
		super();
		this.id = id;
		this.type_service = type_service;
	}
	@Column(name = "type_service")
	private String type_service;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="divisions_id",referencedColumnName="id")
	private Division divisions;
	

	public Division getDivisions() {
		return divisions;
	}
	public void setDivisions(Division divisions) {
		this.divisions = divisions;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getType_service() {
		return type_service;
	}
	public void setType_service(String type_service) {
		this.type_service = type_service;
	}
	public void assignDivision(Division division) {
		this.divisions=division;
	}


}
