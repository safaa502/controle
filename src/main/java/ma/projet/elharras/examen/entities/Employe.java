package ma.projet.elharras.examen.entities;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Employe {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long id ;
	public String nom;
	public String prenom ;
	public Date dateNaissance;
	public String photo;
	
	@ManyToOne
	public Service service;
	@JsonIgnore
	@ManyToOne
	public Employe chef;
	
	@JsonIgnore
	@OneToMany(mappedBy = "chef")
	public List<Employe> emps;
	
	
	public long getId() {
		return id;
	}


	public void setId(long id) {
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


	public Date getDateNaissance() {
		return dateNaissance;
	}


	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}


	public String getPhoto() {
		return photo;
	}


	public void setPhoto(String photo) {
		this.photo = photo;
	}


	public Service getService() {
		return service;
	}


	public void setService(Service s1) {
		service = s1;
	}


	public Employe getChef() {
		return chef;
	}


	public void setChef(Employe e1) {
		this.chef = e1;
	}


	public List<Employe> getEmps() {
		return emps;
	}


	public void setEmps(List<Employe> e) {
		this.emps = e;
	}


	public Employe() {
		// TODO Auto-generated constructor stub
	}

}
