package com.youssfi.metier;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CR")
public class CargaisonRoutiere extends Cargaison {
	private static final long serialVersionUID = 1L;
	
	private double temperatureConservation;
	
	public CargaisonRoutiere() {
		super();
	}

	public CargaisonRoutiere(String reference, int distance, Date dateLivraison, double temperatureConservation) {
		super(reference, distance, dateLivraison);
		this.temperatureConservation = temperatureConservation;
	}

	public double getTemperatureConservation() {
		return temperatureConservation;
	}

	public void setTemperatureConservation(double temperatureConservation) {
		this.temperatureConservation = temperatureConservation;
	}
}
