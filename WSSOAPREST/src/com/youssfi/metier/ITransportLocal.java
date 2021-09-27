package com.youssfi.metier;

import java.util.List;

import javax.ejb.Local;

@Local
public interface ITransportLocal {
	public void addCargaison(Cargaison c);
	public void addMarchandise(Marchandise m, String refCarg);
	public List<Cargaison> getAllCargaisons();
	public List<Marchandise> getMarchParCarg(String refCarg);
	public List<Marchandise> getMarchParMC(String motCle);
	public void supprimerMarchandise(Long numMarch);
}
