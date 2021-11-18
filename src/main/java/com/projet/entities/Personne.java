package com.projet.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jdk.nashorn.internal.objects.annotations.Getter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import net.minidev.json.annotate.JsonIgnore;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idpers")
public class Personne implements Serializable{
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

	// List Bien

	@OneToMany(mappedBy = "personne")
	private List<Bien> bienList;


}
