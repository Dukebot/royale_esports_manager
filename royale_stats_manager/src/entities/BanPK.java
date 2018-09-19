package entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ban database table.
 * 
 */
@Embeddable
public class BanPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="jugador_id", insertable=false, updatable=false)
	private Long jugadorId;

	@Column(name="partido_id", insertable=false, updatable=false)
	private Long partidoId;

	@Column(name="carta_id", insertable=false, updatable=false)
	private Long cartaId;

	public BanPK() {
	}
	public Long getJugadorId() {
		return this.jugadorId;
	}
	public void setJugadorId(Long jugadorId) {
		this.jugadorId = jugadorId;
	}
	public Long getPartidoId() {
		return this.partidoId;
	}
	public void setPartidoId(Long partidoId) {
		this.partidoId = partidoId;
	}
	public Long getCartaId() {
		return this.cartaId;
	}
	public void setCartaId(Long cartaId) {
		this.cartaId = cartaId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof BanPK)) {
			return false;
		}
		BanPK castOther = (BanPK)other;
		return 
			this.jugadorId.equals(castOther.jugadorId)
			&& this.partidoId.equals(castOther.partidoId)
			&& this.cartaId.equals(castOther.cartaId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.jugadorId.hashCode();
		hash = hash * prime + this.partidoId.hashCode();
		hash = hash * prime + this.cartaId.hashCode();
		
		return hash;
	}
}