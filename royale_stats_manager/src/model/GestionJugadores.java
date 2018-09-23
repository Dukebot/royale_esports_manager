package model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import entities.Jugador;

public class GestionJugadores {

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("royale_stats_manager");
		return factory.createEntityManager();
	}
	
	public void altaJugador(Jugador j) {
		EntityManager em = getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		{
			em.persist(j);
		}
		tx.commit();
	}
	
	public List<Jugador> recuperarJugadores() {
		EntityManager em = getEntityManager();
		TypedQuery<Jugador> qr = em.createQuery("Select j from Jugador j", Jugador.class);
		return qr.getResultList();
	}
	
	public void eliminarJugador(int idJugador) {
		EntityManager em = getEntityManager();
		Jugador j = em.find(Jugador.class, idJugador);
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		{
			if (j != null) em.remove(j);
			else System.out.println("No se ha encontrado el jugador con id " + idJugador);
		}
		tx.commit();
	}
}
