package com.youssfi.service;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.inject.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import com.youssfi.metier.Cargaison;
import com.youssfi.metier.CargaisonAerienne;
import com.youssfi.metier.CargaisonRoutiere;
import com.youssfi.metier.ITransportLocal;
import com.youssfi.metier.Marchandise;

@Stateless
@Path("/transport")
public class TransportRESTService {
	@EJB
	private ITransportLocal metier;
	
	@GET
	@Path("/addCargRout/{ref}/{dist}/{date}/{temp}")
	@Produces(MediaType.APPLICATION_JSON)
	public void ajouterCargaisonRoutiere(@PathParam(value = "ref") String ref, @PathParam(value = "dist") int dist, @PathParam(value = "date") Date date, @PathParam(value = "temp") double temp) {
		metier.addCargaison(new CargaisonRoutiere(ref, dist, date, temp));
	}
	
	@GET
	@Path("/addCargAer/{ref}/{dist}/{date}/{poids}")
	@Produces(MediaType.APPLICATION_JSON)
	public void ajouterCargaisonAerienne(@PathParam(value = "ref") String ref, @PathParam(value = "dist") int dist, @PathParam(value = "date") Date date, @PathParam(value = "poids") double poids) {
		metier.addCargaison(new CargaisonAerienne(ref, dist, date, poids));
	}
	
	@GET
	@Path("/addMarch/{nom}/{poids}/{vol}/{refCarg}")
	@Produces(MediaType.APPLICATION_JSON)
	public void ajouterMarchandise(@PathParam(value = "nom") String nom, @PathParam(value = "poids") double poids, @PathParam(value = "vol") double vol, @PathParam(value = "refCarg") String refCarg) {
		metier.addMarchandise(new Marchandise(poids, vol, nom), refCarg);
	}
	
	@GET
	@Path("/consulterCarg")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cargaison> consulterCargaison(){
		return metier.getAllCargaisons();
	}
	
	@GET
	@Path("/consulterMarchParCarg/{ref}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Marchandise> getMarchParCarg(@PathParam(value = "ref") String ref){
		return metier.getMarchParCarg(ref);
	}
	
	@GET
	@Path("/consulterMarchParMC/{mc}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Marchandise> getMarchParMC(@PathParam(value = "mc") String mc){
		return metier.getMarchParMC(mc);
	}
	
	@GET
	@Path("/supprimerMarch/{num}")
	@Produces(MediaType.APPLICATION_JSON)
	public void supprimerMarch(@PathParam(value = "num") Long num) {
		metier.supprimerMarchandise(num);
	}
}
