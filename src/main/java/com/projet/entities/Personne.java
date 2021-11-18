package com.projet.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Personne{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idpers;
	private String login;
	private String pwd;
	private String nom;
	private String prenom;
	private String adresse;
	private String sexe;
	private String email;
	private String telephone;
	private String nationalite;
	private int type;

	@OneToMany(mappedBy = "personne")
	private  List<Bien> bienList;

	@OneToMany(mappedBy = "personne")
	private List<Location> locationList;
}
