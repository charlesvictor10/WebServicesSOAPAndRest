package com.youssfi.metier;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CA")
public class CargaisonAerienne extends Cargaison {
	private static final long serialVersionUID = 1L;

	private double poidsMax;

	public CargaisonAerienne() {
		super();
	}

	public CargaisonAerienne(String reference, int distance, Date dateLivraison, double poidsMax) {
		super(reference, distance, dateLivraison);
		this.poidsMax = poidsMax;
	}

	public double getPoidsMax() {
		return poidsMax;
	}

	public void setPoidsMax(double poidsMax) {
		this.poidsMax = poidsMax;
	}
}
