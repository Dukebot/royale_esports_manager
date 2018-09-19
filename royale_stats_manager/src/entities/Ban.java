package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ban database table.
 * 
 */
@Entity
@NamedQuery(name="Ban.findAll", query="SELECT b FROM Ban b")
public class Ban implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private BanPK id;

	//bi-directional many-to-one association to Carta
	@ManyToOne
	private Carta carta;

	//bi-directional many-to-one association to Jugador
	@ManyToOne
	private Jugador jugador;

	//bi-directional many-to-one association to Partido
	@ManyToOne
	private Partido partido;

	public Ban() {
	}

	public BanPK getId() {
		return this.id;
	}

	public void setId(BanPK id) {
		this.id = id;
	}

	public Carta getCarta() {
		return this.carta;
	}

	public void setCarta(Carta carta) {
		this.carta = carta;
	}

	public Jugador getJugador() {
		return this.jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public Partido getPartido() {
		return this.partido;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}

}