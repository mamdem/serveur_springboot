package com.projet.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Bien{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idbiens;
	private String nom;
	private String description;
	private double prix;
	private Date date;
	private Long nbpiece;
	private String categorie;

	@ManyToOne
	@JoinColumn(name = "idpers")
	private Personne personne;

	@OneToMany(mappedBy = "bien")
	private List<Location> locationList;


}
