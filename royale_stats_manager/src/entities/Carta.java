package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the carta database table.
 * 
 */
@Entity
@NamedQuery(name="Carta.findAll", query="SELECT c FROM Carta c")
public class Carta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private Integer coste;

	private String nombre;

	public Carta() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCoste() {
		return this.coste;
	}

	public void setCoste(Integer coste) {
		this.coste = coste;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}