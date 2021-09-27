package com.youssfi.metier;

@stateless(name="BP")
public class BanqueEJBImpl implements IBanqueLocal {
	@PersistenceContext(unitName="UP_BP")
	EntityManager em;
	
	@Override
	public Compte addCompte(Compte c) {
		em.persist(c);
		return c;
	}
	
	@Override
	public List<Compte> getAllComptes(){
		Query req = em.createQuery("select c from Compte c");
		return req.getResultList();
	}
	
	@Override
	public void verser(Long code, double montant) {
		if(montant <= 0)
			throw new RuntimeException("Le montant doit être supérieur à zéro");
		Compte c = em.find(Compte.class, code);
		c.setSolde(c.getSolde() + montant);
		em.persist(c);
	}
	
	@Override
	public void retirer(Long code, double montant) {
		if(montant <= 0)
			throw new RuntimeException("Le montant doit être supérieur à zéro");
		Compte c = em.find(Compte.class, code);
		if(c.getSolde() <= montant)
			throw new RuntimeException("Solde Insuffisant");
		c.setSolde(c.getSolde() - montant);
	}
	
	@Override
	public Compte consulterCompte(Long code) {
		Compte c = em.find(Compte.class, code);
		if(c == null)
			throw new RuntimeException("Compte introuvable");
		return c;
	}
}
