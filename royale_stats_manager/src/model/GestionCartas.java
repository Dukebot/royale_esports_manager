package model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import entities.Carta;

public class GestionCartas {

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("royale_stats_manager");
		return factory.createEntityManager();
	}

	public void altaCarta(Carta c) {
		EntityManager em = getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(c);
		tx.commit();
	}

	public List<Carta> recuperarCartas() {
		EntityManager em = getEntityManager();
		TypedQuery<Carta> qr = em.createQuery("Select c from Carta c", Carta.class);
		return qr.getResultList();
	}

	public Carta buscarCarta(String nombre) {
		EntityManager em = getEntityManager();
		String jpql = "Select c from Carta c where c.nombre=?1";
		TypedQuery<Carta> qr = em.createQuery(jpql, Carta.class);
		qr.setParameter(1, nombre);
		// return qr.getSingleResult();
		return qr.getResultList().get(0);
	}

	public void eliminarCarta(int idCarta) {
		EntityManager em = getEntityManager();
		Carta c = em.find(Carta.class, idCarta);
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		if (c != null) {
			em.remove(c);
		}
		tx.commit();
	}
}
