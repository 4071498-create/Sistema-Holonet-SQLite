package ut4.sqlite.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "cazas_ligeros")
@PrimaryKeyJoinColumn(name = "caza_id")
public class CazaLigero extends Nave {

    @Column(name = "potencia_fuego", nullable = false)
    private Integer potenciaFuego;

    public CazaLigero() {
    }

    public CazaLigero(String nombre, String modelo, String estadoSistema,
                      Planeta planetaOrigen, Integer potenciaFuego) {
        super(nombre, modelo, estadoSistema, planetaOrigen);
        this.potenciaFuego = potenciaFuego;
    }

    public Integer getPotenciaFuego() { return potenciaFuego; }
    public void setPotenciaFuego(Integer potenciaFuego) { this.potenciaFuego = potenciaFuego; }

    @Override
    public String toString() {
        return super.toString() + " potenciaFuego=" + potenciaFuego;
    }
}
