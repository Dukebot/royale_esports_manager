package model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import entities.Equipo;

public class GestionEquipos {

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("royale_stats_manager");
		return factory.createEntityManager();
	}
	
	public void altaEquipo(Equipo e) {
		EntityManager em = getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		{
			em.persist(e);
		}
		tx.commit();
	}
	
	public Equipo recuperarEquipo(String idEquipo) {
		EntityManager em = getEntityManager();
		Query qr = em.createQuery("Select e from Equipo e where e.id=?1");
		qr.setParameter(1, Integer.valueOf(idEquipo) );
		return (Equipo) qr.getSingleResult();
	}
	
	public List<Equipo> recuperarEquipos() {
		EntityManager em = getEntityManager();
		TypedQuery<Equipo> qr = em.createQuery("Select e from Equipo e", Equipo.class);
		return qr.getResultList();
	}
	
	public void eliminarEquipo(int idEquipo) {
		EntityManager em = getEntityManager();
		Equipo e = em.find(Equipo.class, idEquipo);
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		{
			if (e != null) em.remove(e);
			else System.out.println("No hay ningún equipo con el id " + idEquipo);
		}
		tx.commit();
	}
}
