package com.projet.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import net.minidev.json.annotate.JsonIgnore;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idbien")
public class Bien implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idbien;
	private String nom;
	private String description;
	private double prix;
	private Date date;
	private Long nbpiece;
	private String categorie;

	// Personne
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "idpers")
	private Personne personne;

	// List image
	@OneToMany(mappedBy = "bien",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Image> imageList;


	// List Location
	@OneToMany(mappedBy = "bien")
	private List<Location> locationList;
}
