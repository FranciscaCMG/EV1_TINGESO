package cl.usach.tingeso.ev1.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "descuento")
public class DescuentoEntity {
    @Id
    @Column(name = "id_descuento", nullable = false)
    private Integer id_descuento;
    private Integer dcto_colegio;
    private Integer dcto_egreso;
    private Integer dcto_promedio;
    private Integer interes_meses_atraso;

    @OneToOne
    @JoinColumn(name = "rut")
    private EstudianteEntity estudiante;

    public Integer getId_descuento() {
        return id_descuento;
    }

    public void setId_descuento(Integer id_descuento) {
        this.id_descuento = id_descuento;
    }

    public Integer getDcto_colegio() {
        return dcto_colegio;
    }

    public void setDcto_colegio(Integer dcto_colegio) {
        this.dcto_colegio = dcto_colegio;
    }

    public Integer getDcto_egreso() {
        return dcto_egreso;
    }

    public void setDcto_egreso(Integer dcto_egreso) {
        this.dcto_egreso = dcto_egreso;
    }

    public Integer getDcto_promedio() {
        return dcto_promedio;
    }

    public void setDcto_promedio(Integer dcto_promedio) {
        this.dcto_promedio = dcto_promedio;
    }

    public Integer getInteres_meses_atraso() {
        return interes_meses_atraso;
    }

    public void setInteres_meses_atraso(Integer interes_meses_atraso) {
        this.interes_meses_atraso = interes_meses_atraso;
    }

    public EstudianteEntity getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(EstudianteEntity estudiante) {
        this.estudiante = estudiante;
    }
}
