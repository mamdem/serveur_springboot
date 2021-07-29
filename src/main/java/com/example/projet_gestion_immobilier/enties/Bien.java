package com.example.projet_gestion_immobilier.enties;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Bien implements Serializable{
	@Id
	private String idbiens;
	private String nom;
	private String description;
	private double prix;
	private Date date;
	private Long nbpiece;
	private String categorie;
	@OneToMany(mappedBy = "bien",fetch = FetchType.LAZY)
	private Collection<Location> locations;
	@OneToMany(mappedBy = "bien",fetch = FetchType.LAZY)
	private Collection<Image> images;
	@ManyToOne()
	@JoinColumn(name = "idpers")
	private Personne personne;
	public Bien() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bien(String idbiens, String nom, String description, double prix, Date date, Long nbpiece, String categorie) {
		super();
		this.idbiens = idbiens;
		this.nom = nom;
		this.description = description;
		this.prix = prix;
		this.date = date;
		this.nbpiece = nbpiece;
		this.categorie = categorie;
	}
	public String getIdbiens() {
		return idbiens;
	}
	public void setIdbiens(String idbiens) {
		this.idbiens = idbiens;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getdescription() {
		return description;
	}
	public void setdescription(String description) {
		this.description = description;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Long getnbpiece() {
		return nbpiece;
	}
	public void setnbpiece(Long nbpiece) {
		this.nbpiece = nbpiece;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	public Collection<Location> getLocations() {
		return locations;
	}
	public void setLocations(Collection<Location> locations) {
		this.locations = locations;
	}
	public Collection<Image> getImages() {
		return images;
	}
	public void setImages(Collection<Image> images) {
		this.images = images;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getNbpiece() {
		return nbpiece;
	}
	public void setNbpiece(Long nbpiece) {
		this.nbpiece = nbpiece;
	}
	public Personne getPersonne() {
		return personne;
	}
	public void setPersonne(Personne personne) {
		this.personne = personne;
	}
	
}
