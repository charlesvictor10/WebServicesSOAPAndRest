package com.youssfi.metier;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless(name = "TRANS")
public class TransportEJBImpl implements ITransportLocal{
	@PersistenceContext(name = "UP_TRANSPORT")
	EntityManager em;
	
	@Override
	public void addCargaison(Cargaison c) {
		em.persist(c);
	}

	@Override
	public void addMarchandise(Marchandise m, String refCarg) {
		Cargaison c = em.find(Cargaison.class, refCarg);
		m.setCargaison(c);
		em.persist(m);
	}

	@Override
	public List<Cargaison> getAllCargaisons() {
		Query req = em.createQuery("select c from Cargaison c");
		return req.getResultList();
	}

	@Override
	public List<Marchandise> getMarchParCarg(String refCarg) {
		Query req = em.createQuery("select m from Marchandise m where m.cargaison.reference=:x");
		req.setParameter("x", refCarg);
		return req.getResultList();
	}

	@Override
	public List<Marchandise> getMarchParMC(String motCle) {
		Query req = em.createQuery("select m from Marchandise m where m.nom like :x");
		req.setParameter("x", motCle);
		return req.getResultList();
	}

	@Override
	public void supprimerMarchandise(Long numMarch) {
		Marchandise m = em.find(Marchandise.class, numMarch);
		em.remove(m);
	}
}
