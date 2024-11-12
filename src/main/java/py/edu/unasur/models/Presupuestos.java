package py.edu.unasur.models;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.*;

@Entity
@Table(name = "presupuestos", schema = "public")
public class Presupuestos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "presupuesto_id")
    private Integer presupuestoId;

    @Column(name = "nombres_cliente", nullable = false)
    private String nombresCliente;

    @Column(name = "apellido_cliente", nullable = false)
    private String apellidoCliente;

    @Column(name = "fecha_inicio", nullable = false)
    private Date fechaInicio;

    @Column(name = "fecha_fin", nullable = false)
    private Date fechaFin;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @JsonIgnore
    @OneToMany(mappedBy = "presupuesto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Gasto> gastos;

    /*
     * @OneToMany(mappedBy = "presupuesto", cascade = CascadeType.ALL, fetch =
     * FetchType.LAZY)
     * private List<Gasto> gastos;
     */

    // Getters and Setters
    public Integer getPresupuestoId() {
        return presupuestoId;
    }

    public void setPresupuestoId(Integer presupuestoId) {
        this.presupuestoId = presupuestoId;
    }

    public String getNombresCliente() {
        return nombresCliente;
    }

    public void setNombresCliente(String nombresCliente) {
        this.nombresCliente = nombresCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Gasto> getGastos() {
        return gastos;
    }

    public void setGastos(List<Gasto> gastos) {
        this.gastos = gastos;
    }

    /*
     * public List<Gasto> getGastos() {
     * return gastos;
     * }
     * 
     * public void setGastos(List<Gasto> gastos) {
     * this.gastos = gastos;
     * }
     */
}
