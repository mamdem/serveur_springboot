package com.projet.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Location{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idLocation;
	private Date dateDebut;
	private Date dateFin;
	private boolean etat;

	@ManyToOne
	@JoinColumn(name = "idpers")
	private Personne personne;
	
	@ManyToOne
	@JoinColumn(name = "idbiens")
	private Bien bien;


}
