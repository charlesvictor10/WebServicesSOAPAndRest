package com.youssfi.service;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.youssfi.entities.Cargaison;
import com.youssfi.entities.CargaisonAerienne;
import com.youssfi.entities.CargaisonRoutiere;
import com.youssfi.entities.Marchandise;
import com.youssfi.metier.TransportEJBImpl;

@Path("/transport")
@Stateless
public class TransportRESTService {
	@EJB
	private TransportEJBImpl metier;
	
	@GET
	@Path("addCargRoutiere/{ref}/{dist}/{dateLiv}/{temp}")
	@Produces(MediaType.APPLICATION_JSON)
	public void ajouterCargaisonRoutiere(@PathParam(value =  "ref") String ref, @PathParam(value = "distance") int dist, @PathParam(value = "dateLivraison") Date dateLiv, @PathParam(value = "tempConservation") float temp) {
		CargaisonRoutiere cr = new CargaisonRoutiere(ref, dist, dateLiv, temp);
		metier.addCargaison(cr);
	}
	
	@GET
	@Path("addCargAerienne/{ref}/{dist}/{dateLiv}/{poids}")
	@Produces(MediaType.APPLICATION_JSON)
	public void ajouterCargaisonAerienne(@PathParam(value = "ref") String ref, @PathParam(value = "distance") int dist, @PathParam(value = "dateLivraison") Date dateLiv, @PathParam(value = "poidsMax") float poids) {
		CargaisonAerienne ca = new CargaisonAerienne(ref, dist, dateLiv, poids);
		metier.addCargaison(ca);
	}
	
	@GET
	@Path("addMarch/{nom}/{poids}/{volume}/{refCarg}")
	@Produces(MediaType.APPLICATION_JSON)
	public void ajouterMarchandise(@PathParam(value="nom")String nom, @PathParam(value="poids")double poids, @PathParam(value="volume")double volume, @PathParam(value="refCarg")String refCarg){
		Marchandise m=new Marchandise(nom, poids, volume);
		metier.addMarchandise(m, refCarg);
	}
	
	@GET
	@Path("allCarg")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cargaison> getAllCargaisons(){
		return metier.getAllCargaisons();
	}
	
	@GET
	@Path("marchandises/{refCarg}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Marchandise> getMarchParCarg(@PathParam(value="refCarg")String refCarg){
		return metier.getMarchandisesParCarg(refCarg);
	}
	
	@GET
	@Path("consulterCargaison/{refCarg}")
	@Produces(MediaType.APPLICATION_JSON)
	public Cargaison consulterCargaison(@PathParam(value="refCarg")String refCarg){
		return metier.getCargaison(refCarg);
	}
	
	@GET
	@Path("supprimerMarch/{num}")
	@Produces(MediaType.APPLICATION_JSON)
	public void supprimerMarchandise(@PathParam(value="num")Long numero){
		metier.supprimerMarchandise(numero);
	}
}
