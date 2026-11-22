package ut4.sqlite.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "destructores_estelares")
@PrimaryKeyJoinColumn(name = "destructor_id")
public class DestructorEstelar extends Nave {

    @Column(name = "capacidad_escudos", nullable = false)
    private Integer capacidadEscudos;

    public DestructorEstelar() {
    }

    public DestructorEstelar(String nombre, String modelo, String estadoSistema,
                             Planeta planetaOrigen, Integer capacidadEscudos) {
        super(nombre, modelo, estadoSistema, planetaOrigen);
        this.capacidadEscudos = capacidadEscudos;
    }

    public Integer getCapacidadEscudos() { return capacidadEscudos; }
    public void setCapacidadEscudos(Integer capacidadEscudos) { this.capacidadEscudos = capacidadEscudos; }

    @Override
    public String toString() {
        return super.toString() + " capacidadEscudos=" + capacidadEscudos;
    }
}
