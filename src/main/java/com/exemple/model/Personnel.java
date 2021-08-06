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
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name ="personnel")
public class Personnel {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	public Personnel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Personnel(Long id, String cin, String budget, String nameA, String nameF, String prenomA, String prenomF,
			String emailId, String pere, String mere, Date dateNaissance, String lieuNaissanceA, String lieuNaissanceF,
			String nbrEnfant, String sexe, String situationFamiliale, String adresse, String numTelephone,
			Boolean detache, String prov_detache) {
		super();
		this.id = id;
		Cin = cin;
		this.budget = budget;
		this.nameA = nameA;
		this.nameF = nameF;
		this.prenomA = prenomA;
		this.prenomF = prenomF;
		this.emailId = emailId;
		this.pere = pere;
		this.mere = mere;
		this.dateNaissance = dateNaissance;
		this.lieuNaissanceA = lieuNaissanceA;
		this.lieuNaissanceF = lieuNaissanceF;
		this.nbrEnfant = nbrEnfant;
		this.sexe = sexe;
		this.situationFamiliale = situationFamiliale;
		this.adresse = adresse;
		this.numTelephone = numTelephone;
		this.detache = detache;
		this.prov_detache = prov_detache;
	}

	@Column(name = "cin")
	private String Cin;
	@Column(name = "budget")
	private String budget;
	public String getCin() {
		return Cin;
	}

	public void setCin(String cin) {
		Cin = cin;
	}

	public String getBudget() {
		return budget;
	}

	public void setBudget(String budget) {
		this.budget = budget;
	}
	@Column(name = "nameA")
	private String nameA;
	@Column(name = "nameF")
	private String nameF;
	@Column(name = "prenomA")
	private String prenomA;
	@Column(name = "prenomF")
	private String prenomF;
	@Column(name = "email")
	private String emailId;
	@Column(name = "pere")
	private String pere;
	@Column(name = "mere")
	private String mere;
	@Column(name = "dateNaissance")
	private Date dateNaissance;
	@Column(name = "lieuNaissanceA")
	private String lieuNaissanceA;
	@Column(name = "lieuNaissanceF")
	private String lieuNaissanceF;
	@Column(name = "nbrEnfant")
	private String nbrEnfant;
	@Column(name = "sexe")
	private String sexe;
	@Column(name = "situationFamiliale")
	private String situationFamiliale;
	@Column(name = "adresse")
	private String adresse;
	@Column(name = "numTelephone")
	private String numTelephone;
	@Column(name = "detache")
	private Boolean detache;
	@Column(name = "prov_detache")
	private String prov_detache;
	
	@ManyToMany
	@JoinTable(name="conges_enrolled" , joinColumns= @JoinColumn(name="personnel_id",referencedColumnName="id"),inverseJoinColumns=@JoinColumn(name="conges_id",referencedColumnName="id"))
	private Set<Conges> enrolledConges=new HashSet<>();
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="grades_id",referencedColumnName="id")
	private Grades grades;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="fonction_id",referencedColumnName="id")
	private Fonction fonction;
	@JsonIgnore
    @OneToMany(mappedBy="personnel")
	private Set<Mission> missions= new HashSet<>();
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="diplome_id",referencedColumnName="id")
	private Diplome diplome;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="mutuelle_id",referencedColumnName="id")
	private Mutuelle mutuelle;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="division_id",referencedColumnName="id")
	private Division division;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="conjoint_id",referencedColumnName="id")
	private Conjoint conjoint;
	
	
	
	
	
	
	
	
	
	
	
	
	public Conjoint getConjoint() {
		return conjoint;
	}

	public void setConjoint(Conjoint conjoint) {
		this.conjoint = conjoint;
	}

	public Division getDivision() {
		return division;
	}

	public void setDivision(Division division) {
		this.division = division;
	}

	public Mutuelle getMutuelle() {
		return mutuelle;
	}

	public void setMutuelle(Mutuelle mutuelle) {
		this.mutuelle = mutuelle;
	}

	public Diplome getDiplome() {
		return diplome;
	}

	public void setDiplome(Diplome diplome) {
		this.diplome = diplome;
	}

	public Set<Mission> getMissions() {
		return missions;
	}

	public void setMissions(Set<Mission> missions) {
		this.missions = missions;
	}

	public Fonction getFonction() {
		return fonction;
	}

	public void setFonction(Fonction fonction) {
		this.fonction = fonction;
	}

	public Grades getGrades() {
		return grades;
	}

	public void setGrades(Grades grades) {
		this.grades = grades;
	}

	public Set<Conges> getEnrolledConges() {
		return enrolledConges;
	}

	public void setEnrolledConges(Set<Conges> enrolledConges) {
		this.enrolledConges = enrolledConges;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNameA() {
		return nameA;
	}
	public void setNameA(String nameA) {
		this.nameA = nameA;
	}
	public String getNameF() {
		return nameF;
	}
	public void setNameF(String nameF) {
		this.nameF = nameF;
	}
	public String getPrenomA() {
		return prenomA;
	}
	public void setPrenomA(String prenomA) {
		this.prenomA = prenomA;
	}
	public String getPrenomF() {
		return prenomF;
	}
	public void setPrenomF(String prenomF) {
		this.prenomF = prenomF;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPere() {
		return pere;
	}
	public void setPere(String pere) {
		this.pere = pere;
	}
	public String getMere() {
		return mere;
	}
	public void setMere(String mere) {
		this.mere = mere;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getLieuNaissanceA() {
		return lieuNaissanceA;
	}
	public void setLieuNaissanceA(String lieuNaissanceA) {
		this.lieuNaissanceA = lieuNaissanceA;
	}
	public String getLieuNaissanceF() {
		return lieuNaissanceF;
	}
	public void setLieuNaissanceF(String lieuNaissanceF) {
		this.lieuNaissanceF = lieuNaissanceF;
	}
	public String getNbrEnfant() {
		return nbrEnfant;
	}
	public void setNbrEnfant(String nbrEnfant) {
		this.nbrEnfant = nbrEnfant;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public String getSituationFamiliale() {
		return situationFamiliale;
	}
	public void setSituationFamiliale(String situationFamiliale) {
		this.situationFamiliale = situationFamiliale;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getNumTelephone() {
		return numTelephone;
	}
	public void setNumTelephone(String numTelephone) {
		this.numTelephone = numTelephone;
	}
	public Boolean getDetache() {
		return detache;
	}
	public void setDetache(Boolean detache) {
		this.detache = detache;
	}
	public String getProv_detache() {
		return prov_detache;
	}
	public void setProv_detache(String prov_detache) {
		this.prov_detache = prov_detache;
	}
	public void enrollConges(Conges conges) {
		enrolledConges.add(conges);
		
	}
	public void assignGrades(Grades grades) {
		this.grades=grades;
	}
	public void assignFonction(Fonction fonction) {
		this.fonction=fonction;
	}
	public void assignDiplome(Diplome diplome) {
		this.diplome=diplome;
	}
	public void assignMutuelle(Mutuelle mutuelle) {
		this.mutuelle=mutuelle;
	}
	public void assignDivision(Division division) {
		this.division=division;
	}
	public void assignConjoint(Conjoint conjoint) {
		this.conjoint=conjoint;
	}
	
}
