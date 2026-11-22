package ut4.sqlite.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Clase base abstracta de la jerarquía. Estrategia JOINED:
 * los datos comunes viven en "naves" y cada subclase tiene su propia tabla
 * que comparte la clave primaria con "naves".
 */
@Entity
@Table(name = "naves")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Nave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nave_id")
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "modelo", nullable = false, length = 50)
    private String modelo;

    @Column(name = "estado_sistema", nullable = false, length = 20)
    private String estadoSistema;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "planeta_origen_id")
    private Planeta planetaOrigen;

    protected Nave() {
    }

    protected Nave(String nombre, String modelo, String estadoSistema, Planeta planetaOrigen) {
        this.nombre = nombre;
        this.modelo = modelo;
        this.estadoSistema = estadoSistema;
        this.planetaOrigen = planetaOrigen;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public String getEstadoSistema() { return estadoSistema; }
    public void setEstadoSistema(String estadoSistema) { this.estadoSistema = estadoSistema; }

    public Planeta getPlanetaOrigen() { return planetaOrigen; }
    public void setPlanetaOrigen(Planeta planetaOrigen) { this.planetaOrigen = planetaOrigen; }

    // OJO: no se toca planetaOrigen aquí para no provocar LazyInitializationException.
    @Override
    public String toString() {
        return getClass().getSimpleName() + "{id=" + id + ", nombre=" + nombre
                + ", modelo=" + modelo + ", estado=" + estadoSistema + "}";
    }
}
