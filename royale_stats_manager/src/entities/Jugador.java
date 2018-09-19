package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the jugador database table.
 * 
 */
@Entity
@NamedQuery(name="Jugador.findAll", query="SELECT j FROM Jugador j")
public class Jugador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String nombre;

	//bi-directional many-to-one association to Ban
	@OneToMany(mappedBy="jugador")
	private List<Ban> bans;

	//bi-directional many-to-one association to Partido
	@OneToMany(mappedBy="jugador1")
	private List<Partido> partidos1;

	//bi-directional many-to-one association to Partido
	@OneToMany(mappedBy="jugador2")
	private List<Partido> partidos2;

	public Jugador() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Ban> getBans() {
		return this.bans;
	}

	public void setBans(List<Ban> bans) {
		this.bans = bans;
	}

	public Ban addBan(Ban ban) {
		getBans().add(ban);
		ban.setJugador(this);

		return ban;
	}

	public Ban removeBan(Ban ban) {
		getBans().remove(ban);
		ban.setJugador(null);

		return ban;
	}

	public List<Partido> getPartidos1() {
		return this.partidos1;
	}

	public void setPartidos1(List<Partido> partidos1) {
		this.partidos1 = partidos1;
	}

	public Partido addPartidos1(Partido partidos1) {
		getPartidos1().add(partidos1);
		partidos1.setJugador1(this);

		return partidos1;
	}

	public Partido removePartidos1(Partido partidos1) {
		getPartidos1().remove(partidos1);
		partidos1.setJugador1(null);

		return partidos1;
	}

	public List<Partido> getPartidos2() {
		return this.partidos2;
	}

	public void setPartidos2(List<Partido> partidos2) {
		this.partidos2 = partidos2;
	}

	public Partido addPartidos2(Partido partidos2) {
		getPartidos2().add(partidos2);
		partidos2.setJugador2(this);

		return partidos2;
	}

	public Partido removePartidos2(Partido partidos2) {
		getPartidos2().remove(partidos2);
		partidos2.setJugador2(null);

		return partidos2;
	}

}