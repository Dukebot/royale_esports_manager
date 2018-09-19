package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the partido database table.
 * 
 */
@Entity
@NamedQuery(name="Partido.findAll", query="SELECT p FROM Partido p")
public class Partido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="coronas_jugador1")
	private Integer coronasJugador1;

	@Column(name="coronas_jugador2")
	private Integer coronasJugador2;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	//bi-directional many-to-one association to Ban
	@OneToMany(mappedBy="partido")
	private List<Ban> bans;

	//bi-directional many-to-one association to Campeonato
	@ManyToOne
	private Campeonato campeonato;

	//bi-directional many-to-one association to Jugador
	@ManyToOne
	private Jugador jugador1;

	//bi-directional many-to-one association to Jugador
	@ManyToOne
	private Jugador jugador2;

	//bi-directional many-to-one association to Mazo
	@ManyToOne
	private Mazo mazo1;

	//bi-directional many-to-one association to Mazo
	@ManyToOne
	private Mazo mazo2;

	public Partido() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCoronasJugador1() {
		return this.coronasJugador1;
	}

	public void setCoronasJugador1(Integer coronasJugador1) {
		this.coronasJugador1 = coronasJugador1;
	}

	public Integer getCoronasJugador2() {
		return this.coronasJugador2;
	}

	public void setCoronasJugador2(Integer coronasJugador2) {
		this.coronasJugador2 = coronasJugador2;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public List<Ban> getBans() {
		return this.bans;
	}

	public void setBans(List<Ban> bans) {
		this.bans = bans;
	}

	public Ban addBan(Ban ban) {
		getBans().add(ban);
		ban.setPartido(this);

		return ban;
	}

	public Ban removeBan(Ban ban) {
		getBans().remove(ban);
		ban.setPartido(null);

		return ban;
	}

	public Campeonato getCampeonato() {
		return this.campeonato;
	}

	public void setCampeonato(Campeonato campeonato) {
		this.campeonato = campeonato;
	}

	public Jugador getJugador1() {
		return this.jugador1;
	}

	public void setJugador1(Jugador jugador1) {
		this.jugador1 = jugador1;
	}

	public Jugador getJugador2() {
		return this.jugador2;
	}

	public void setJugador2(Jugador jugador2) {
		this.jugador2 = jugador2;
	}

	public Mazo getMazo1() {
		return this.mazo1;
	}

	public void setMazo1(Mazo mazo1) {
		this.mazo1 = mazo1;
	}

	public Mazo getMazo2() {
		return this.mazo2;
	}

	public void setMazo2(Mazo mazo2) {
		this.mazo2 = mazo2;
	}

}