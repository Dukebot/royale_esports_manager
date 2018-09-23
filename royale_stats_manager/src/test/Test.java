package test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import entities.Carta;
import entities.Mazo;

public class Test {

	private static EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("royale_stats_manager_test");
		return factory.createEntityManager();
	}

	public static void main(String[] args) {
		// crearCartas();
		// crearMazos();
		verCartasMazo();
	}

	private static void crearCartas() {
		EntityManager em = getEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		{
			Carta c;
			for (int i = 0; i < 50; i++) {
				c = new Carta();
				c.setNombre("Carta " + i);
				c.setCoste(1);
				em.persist(c);
				System.out.println("Hemos guardado la carta con nombre " + c.getNombre() + " en la base de datos");
			}
		}
		t.commit();
	}

	private static void crearMazos() {
		EntityManager em = getEntityManager();
		EntityTransaction t = em.getTransaction();

		TypedQuery<Carta> qr = em.createQuery("Select c from Carta c", Carta.class);
		List<Carta> cartas = qr.getResultList();

		t.begin();
		{
			Mazo m = new Mazo();
			m.setCarta1(cartas.get(1));
			m.setCarta2(cartas.get(2));
			m.setCarta3(cartas.get(3));
			m.setCarta4(cartas.get(4));
			m.setCarta5(cartas.get(5));
			m.setCarta6(cartas.get(6));
			m.setCarta7(cartas.get(7));
			m.setCarta8(cartas.get(8));

			em.persist(m);
		}
		t.commit();
	}

	private static void verCartasMazo() {
		EntityManager em = getEntityManager();
		TypedQuery<Mazo> qr = em.createQuery("Select m from Mazo m", Mazo.class);
		Mazo mazo = qr.getSingleResult();
		System.out.println("Las cartas del mazo son:");
		System.out.println(mazo.getCarta1().getNombre());
		System.out.println(mazo.getCarta2().getNombre());
		System.out.println(mazo.getCarta3().getNombre());
		System.out.println(mazo.getCarta4().getNombre());
		System.out.println(mazo.getCarta5().getNombre());
		System.out.println(mazo.getCarta6().getNombre());
		System.out.println(mazo.getCarta7().getNombre());
		System.out.println(mazo.getCarta8().getNombre());
	}
}
