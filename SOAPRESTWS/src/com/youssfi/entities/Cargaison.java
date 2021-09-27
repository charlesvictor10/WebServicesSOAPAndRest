package com.youssfi.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_CARG")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({CargaisonAerienne.class, CargaisonRoutiere.class})
public abstract class Cargaison implements Serializable {
	/**
	 * Attributs de la classe Catégorie
	 */
	@Id
	private String reference;
	private int distance;
	private Date dateLivraison;
	/**
	 * Relation un à plusieurs entre Cargaison et Marchandise
	 */
	@OneToMany(mappedBy = "cargaison", fetch = FetchType.LAZY)
	@XmlTransient
	private Collection<Marchandise> marchandises;
	
	/**;
	 * Constructeur sans paramètre
	 */
	public Cargaison() {
		super();
	}
	
	/**
	 * Constructeur avec ces paramètres
	 * @param reference
	 * @param distance
	 * @param dateLivraison
	 * @param marchandises
	 */
	public Cargaison(String reference, int distance, Date dateLivraison, Collection<Marchandise> marchandises) {
		super();
		this.reference = reference;
		this.distance = distance;
		this.dateLivraison = dateLivraison;
		this.marchandises = marchandises;
	}
	
	/**
	 * Constructeur avec ces paramètres
	 * @param reference
	 * @param distance
	 * @param dateLivraison
	 */
	public Cargaison(String reference, int distance, Date dateLivraison) {
		super();
		this.reference = reference;
		this.distance = distance;
		this.dateLivraison = dateLivraison;
	}
	
	/**
	 * Génération des getters et setters
	 */
	public String getReference() {
		return reference;
	}
	
	public void setReference(String reference) {
		this.reference = reference;
	}
	
	public int getDistance() {
		return distance;
	}
	
	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	public Date getDateLivraison() {
		return dateLivraison;
	}
	
	public void setDateLivraison(Date dateLivraison) {
		this.dateLivraison = dateLivraison;
	}
	
	@JsonIgnore
	public Collection<Marchandise> getMarchandises() {
		return marchandises;
	}
	
	public void setMarchandises(Collection<Marchandise> marchandises) {
		this.marchandises = marchandises;
	}
}
