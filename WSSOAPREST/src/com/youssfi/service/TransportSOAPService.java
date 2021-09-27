package com.youssfi.service;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.youssfi.metier.Cargaison;
import com.youssfi.metier.CargaisonAerienne;
import com.youssfi.metier.CargaisonRoutiere;
import com.youssfi.metier.ITransportLocal;
import com.youssfi.metier.Marchandise;

@WebService
public class TransportSOAPService {
	@EJB
	private ITransportLocal metier;
	
	@WebMethod
	public void ajouterCargaisonRoutiere(@WebParam(name = "ref") String ref, @WebParam(name="dist") int dist, @WebParam(name="date") Date date, @WebParam(name="temp") double temp) {
		metier.addCargaison(new CargaisonRoutiere(ref, dist, date, temp));
	}
	
	@WebMethod
	public void ajouterCargaisonAerienne(@WebParam(name = "ref") String ref, @WebParam(name="dist") int dist, @WebParam(name="date") Date date, @WebParam(name = "poids") double poids) {
		metier.addCargaison(new CargaisonAerienne(ref, dist, date, poids));
	}
	
	@WebMethod
	public void ajouterMarchandise(@WebParam(name = "nom") String nom, @WebParam(name="poids") double poids, @WebParam(name="vol") double vol, @WebParam(name="refCarg") String refCarg) {
		metier.addMarchandise(new Marchandise(poids, vol, nom), refCarg);
	}
	
	@WebMethod
	public List<Cargaison> consulterCargaison(){
		return metier.getAllCargaisons();
	}
	
	@WebMethod
	public List<Marchandise> getMarchParCarg(@WebParam(name = "refCarg") String ref){
		return metier.getMarchParCarg(ref);
	}
	
	@WebMethod
	public List<Marchandise> getMarchParMC(@WebParam(name = "motCle") String mc){
		return metier.getMarchParMC(mc);
	}
	
	@WebMethod
	public void supprimerMarch(@WebParam(name = "num") Long num) {
		metier.supprimerMarchandise(num);
	}
}
