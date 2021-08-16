package com.projet.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Location implements Serializable {
	@Id
	private String idLocation;
	private Date dateDebut;
	private Date dateFin;
	private boolean etat;
	public Location() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Location(String idLocation, Date dateDebut, Date dateFin, boolean etat,Bien bien) {
		super();
		this.idLocation = idLocation;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.etat = etat;
	}
	public String getIdLocation() {
		return idLocation;
	}
	public void setIdLocation(String idLocation) {
		this.idLocation = idLocation;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
}
