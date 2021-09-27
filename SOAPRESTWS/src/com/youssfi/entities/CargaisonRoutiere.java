package com.youssfi.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CR")
public class CargaisonRoutiere extends Cargaison {
	private float temperatureConservation;

	public CargaisonRoutiere() {
		super();
	}

	public CargaisonRoutiere(String reference, int distance, Date dateLivraison, float temperatureConservation) {
		super(reference, distance, dateLivraison);
		this.temperatureConservation = temperatureConservation;
	}

	public float getTemperatureConservation() {
		return temperatureConservation;
	}

	public void setTemperatureConservation(float temperatureConservation) {
		this.temperatureConservation = temperatureConservation;
	}
}
