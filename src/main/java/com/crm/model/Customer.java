package com.crm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;


@Entity
@Table(name="client")
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(name="nom")
	private String nom;
	
	@NotNull
	private String prenom;
	
	@NotNull
	@Column(unique=true)
	private String Email;
	
	@NotNull
	@Column(unique=true)
	private int numero;
	
	@NotNull
	private String produit;
	
	
	public Customer(Long id, String nom, String prenom, String Email , int numero, String produit) {
		 
		 this.id = id;
		 this.nom = nom;
		 this.prenom = prenom;
		 this.Email = Email;
		 this.numero = numero;
		 this.produit = produit;
		 }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getProduit() {
		return produit;
	}

	public void setProduit(String produit) {
		this.produit = produit;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}


}
