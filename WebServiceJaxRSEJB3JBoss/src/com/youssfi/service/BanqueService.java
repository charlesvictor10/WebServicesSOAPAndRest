package com.youssfi.service;

import com.youssfi.metier.*;

import javax.jws.*;
import javax.ejb.EJB;
import java.util.List;

@WebService
public class BanqueService {
	@EJB
	private IBanqueLocal metier;	
	
	@WebMethod
	public Compte addCompte(@WebParam(name="solde") double solde) {
		return metier.addCompte(new Compte(solde));
	}
	
	@WebMethod
	public List<Compte> getAllComptes(){
		return metier.getAllComptes();
	}
	
	@WebMethod
	public void verser(@WebParam(name="code") Long code, @WebParam(name="montant") double montant) {
		metier.verser(code, montant);
	}
	
	@WebMethod
	public void retirer(@WebParam(name="code") Long code, @WebParam(name="montant") double montant) {
		metier.retirer(code, montant);
	}
	
	@WebMethod
	public Compte consulterCompte(@WebParam(name="code") Long code) {
		return metier.consulterCompte(code);
	}
}
