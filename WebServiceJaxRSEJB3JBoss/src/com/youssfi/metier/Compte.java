package com.youssfi.metier;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
public class Compte implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long code;
	private double solde;
	private Date dateCreation;
	
	public Compte() {
		
	}
	
	public Compte(double solde) {
		this.solde = solde;
		this.dateCreation = new Date();
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
}
