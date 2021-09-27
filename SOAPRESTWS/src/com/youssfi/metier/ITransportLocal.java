package com.youssfi.metier;

import java.util.List;

import javax.ejb.Local;

import com.youssfi.entities.Cargaison;
import com.youssfi.entities.Marchandise;

@Local
public interface ITransportLocal {
	public void addCargaison(Cargaison c);
	public void addMarchandise(Marchandise m, String refCarg);
	public List<Cargaison> getAllCargaisons();
	public List<Marchandise> getMarchandisesParCarg(String refCarg);
	public Cargaison getCargaison(String reg);
	public void supprimerMarchandise(Long numero);
}
