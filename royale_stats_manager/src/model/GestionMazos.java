package model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import entities.Carta;
import entities.Mazo;

public class GestionMazos {

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("royale_stats_manager");
		return factory.createEntityManager();
	}
	
	public void altaMazo(Mazo m) {
		EntityManager em = getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		{
			em.persist(m);
		}
		tx.commit();
	}
	
	public List<Mazo> recuperarMazos() {
		EntityManager em = getEntityManager();
		TypedQuery<Mazo> qr = em.createQuery("Select m from Mazo m", Mazo.class);
		return qr.getResultList();
	}
	
	public void eliminarMazo(int idMazo) {
		EntityManager em = getEntityManager();
		Carta c = em.find(Carta.class, idMazo);
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		{
			if (c != null) em.remove(c);
		}
		tx.commit();
	}
}
