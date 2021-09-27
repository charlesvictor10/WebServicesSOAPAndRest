package com.youssfi.metier;

@Local
public class IBanqueLocal {
	public Compte addCompte(Compte c);
	public List<Compte> getAllComptes();
	public void verser(Long code, double montant);
	public void retirer(Long code, double montant);
	public Compte consulterCompte(Long code);
}
