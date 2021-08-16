package com.projet.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Image implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idImage;
	private String url;
	
	public Image() {
		super();
	}
	public Image(String url,Bien bien) {
		super();
		this.url = url;
	}
	public Long getIdImage() {
		return idImage;
	}
	public void setIdImage(Long idImage) {
		this.idImage = idImage;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

}
