package com.youssfi.metier;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.*;

import com.youssfi.entities.Cargaison;
import com.youssfi.entities.Marchandise;

@Stateless(name="TRANS")
public class TransportEJBImpl implements ITransportLocal {
	@PersistenceContext(unitName = "UP_TRANSPORT")
	private EntityManager em;

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
	public List<Marchandise> getMarchandisesParCarg(String refCarg) {
		Query req = em.createQuery("select m from Marchandise m where m.cargaison.reference=:x");
		req.setParameter("x", refCarg);
		return req.getResultList();
	}

	@Override
	public Cargaison getCargaison(String reg) {
		Cargaison c = em.find(Cargaison.class, reg);
		return c;
	}

	@Override
	public void supprimerMarchandise(Long numero) {
		Marchandise m = em.find(Marchandise.class, numero);
		em.remove(m);
	}

}
