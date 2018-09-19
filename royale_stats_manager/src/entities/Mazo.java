package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the mazo database table.
 * 
 */
@Entity
@NamedQuery(name="Mazo.findAll", query="SELECT m FROM Mazo m")
public class Mazo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	//uni-directional many-to-one association to Carta
	@ManyToOne
	private Carta carta1;

	//uni-directional many-to-one association to Carta
	@ManyToOne
	private Carta carta2;

	//uni-directional many-to-one association to Carta
	@ManyToOne
	private Carta carta3;

	//uni-directional many-to-one association to Carta
	@ManyToOne
	private Carta carta4;

	//uni-directional many-to-one association to Carta
	@ManyToOne
	private Carta carta5;

	//uni-directional many-to-one association to Carta
	@ManyToOne
	private Carta carta6;

	//uni-directional many-to-one association to Carta
	@ManyToOne
	private Carta carta7;

	//uni-directional many-to-one association to Carta
	@ManyToOne
	private Carta carta8;

	public Mazo() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Carta getCarta1() {
		return this.carta1;
	}

	public void setCarta1(Carta carta1) {
		this.carta1 = carta1;
	}

	public Carta getCarta2() {
		return this.carta2;
	}

	public void setCarta2(Carta carta2) {
		this.carta2 = carta2;
	}

	public Carta getCarta3() {
		return this.carta3;
	}

	public void setCarta3(Carta carta3) {
		this.carta3 = carta3;
	}

	public Carta getCarta4() {
		return this.carta4;
	}

	public void setCarta4(Carta carta4) {
		this.carta4 = carta4;
	}

	public Carta getCarta5() {
		return this.carta5;
	}

	public void setCarta5(Carta carta5) {
		this.carta5 = carta5;
	}

	public Carta getCarta6() {
		return this.carta6;
	}

	public void setCarta6(Carta carta6) {
		this.carta6 = carta6;
	}

	public Carta getCarta7() {
		return this.carta7;
	}

	public void setCarta7(Carta carta7) {
		this.carta7 = carta7;
	}

	public Carta getCarta8() {
		return this.carta8;
	}

	public void setCarta8(Carta carta8) {
		this.carta8 = carta8;
	}

}