package com.youssfi.service;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.youssfi.entities.Cargaison;
import com.youssfi.entities.CargaisonAerienne;
import com.youssfi.entities.CargaisonRoutiere;
import com.youssfi.entities.Marchandise;
import com.youssfi.metier.TransportEJBImpl;

@WebService
@Stateless
public class TransportSOAPService {
	@EJB
	private TransportEJBImpl metier;

	@WebMethod
	public void ajouterCargaisonRoutiere(@WebParam(name = "ref") String ref, @WebParam(name = "distance") int dist, @WebParam(name = "dateLivraison") Date dateLiv, @WebParam(name = "tempConservation") float temp) {
		CargaisonRoutiere cr = new CargaisonRoutiere(ref, dist, dateLiv, temp);
		metier.addCargaison(cr);
	}
	
	@WebMethod
	public void ajouterCargaisonAerienne(@WebParam(name = "ref") String ref, @WebParam(name = "distance") int dist, @WebParam(name = "dateLivraison") Date dateLiv, @WebParam(name = "poidsMax") float poids) {
		CargaisonAerienne ca = new CargaisonAerienne(ref, dist, dateLiv, poids);
		metier.addCargaison(ca);
	}
	
	@WebMethod
	public void ajouterMarchandise(@WebParam(name = "nom") String nom, @WebParam(name = "poids") double poids, @WebParam(name = "volume") double volume, @WebParam(name = "refCarg") String refCarg) {
		Marchandise m = new Marchandise(nom, poids, volume);
		metier.addMarchandise(m, refCarg);
	}
	
	@WebMethod
	public List<Cargaison> getAllCargaisons(){
		return metier.getAllCargaisons();
	}
	
	@WebMethod
	public List<Marchandise> getMarchParCarg(@WebParam(name = "refCarg") String refCarg){
		return metier.getMarchandisesParCarg(refCarg);
	}
	
	@WebMethod
	public Cargaison consulterCargaison(@WebParam(name = "refCarg") String refCarg) {
		return metier.getCargaison(refCarg);
	}
	
	@WebMethod
	public void supprimerMarchandise(@WebParam(name = "numero") Long numero) {
		metier.supprimerMarchandise(numero);
	}
}
