package com.youssfi.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Marchandise implements Serializable {
	/**
	 * Attributs de la classe Marchandise
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numero;
	private String nom;
	private double poids;
	private double volume;
	/**
	 * Relation plusieurs à un 
	 * entre la classe Marchandise
	 * et Cargaison
	 */
	@ManyToOne
	@JoinColumn(name = "REF_CARG")
	private Cargaison cargaison;
	
	/**
	 * Constructeur sans paramètre
	 */
	public Marchandise() {
		super();
	}

	/**
	 * Constructeur avec ces paramètres
	 * @param numero
	 * @param nom
	 * @param poids
	 * @param volume
	 * @param cargaison
	 */
	public Marchandise(Long numero, String nom, double poids, double volume, Cargaison cargaison) {
		super();
		this.numero = numero;
		this.nom = nom;
		this.poids = poids;
		this.volume = volume;
		this.cargaison = cargaison;
	}

	/**
	 * Constructeur avec ces paramètres
	 * @param nom
	 * @param poids
	 * @param volume
	 */
	public Marchandise(String nom, double poids, double volume) {
		super();
		this.nom = nom;
		this.poids = poids;
		this.volume = volume;
	}

	/**
	 * Génération des getters et setters
	 */
	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPoids() {
		return poids;
	}

	public void setPoids(double poids) {
		this.poids = poids;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public Cargaison getCargaison() {
		return cargaison;
	}

	public void setCargaison(Cargaison cargaison) {
		this.cargaison = cargaison;
	}	
}
