package com.youssfi.metier;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "cargaisons")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_CARG", length = 2)
@XmlSeeAlso({CargaisonAerienne.class, CargaisonRoutiere.class})
public class Cargaison implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "REF_CARG", length = 12)
	private String reference;
	private int distance;
	private Date dateLivraison;
	@OneToMany(mappedBy = "cargaison", fetch = FetchType.LAZY)
	private Collection<Marchandise> marchandises;
	
	public Cargaison() {
		super();
	}

	public Cargaison(String reference, int distance, Date dateLivraison) {
		super();
		this.reference = reference;
		this.distance = distance;
		this.dateLivraison = dateLivraison;
	}

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

	@XmlTransient
	@JsonIgnore
	public Collection<Marchandise> getMarchandises() {
		return marchandises;
	}

	public void setMarchandises(Collection<Marchandise> marchandises) {
		this.marchandises = marchandises;
	}
}
