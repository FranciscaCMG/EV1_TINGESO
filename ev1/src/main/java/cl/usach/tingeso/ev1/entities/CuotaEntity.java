package cl.usach.tingeso.ev1.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cuota")
public class CuotaEntity {
    @Id
    @Column(name = "id_cuota", nullable = false)
    private Integer id_cuota;
    private Integer monto_cuota;
    private Integer nro_cuota;
    private Boolean estado_cuota;
    private Date fecha_vencimiento_cuota;
    private Date fecha_pago_cuota;
    private Integer interes_cuota;

    @ManyToOne
    @JoinColumn(name = "id_arancel")
    private ArancelEntity arancel;

    public Integer getId_cuota() {
        return id_cuota;
    }

    public void setId_cuota(Integer id_cuota) {
        this.id_cuota = id_cuota;
    }

    public Integer getMonto_cuota() {
        return monto_cuota;
    }

    public void setMonto_cuota(Integer monto_cuota) {
        this.monto_cuota = monto_cuota;
    }

    public Integer getNro_cuota() {
        return nro_cuota;
    }

    public void setNro_cuota(Integer nro_cuota) {
        this.nro_cuota = nro_cuota;
    }

    public Boolean getEstado_cuota() {
        return estado_cuota;
    }

    public void setEstado_cuota(Boolean estado_cuota) {
        this.estado_cuota = estado_cuota;
    }

    public Date getFecha_vencimiento_cuota() {
        return fecha_vencimiento_cuota;
    }

    public void setFecha_vencimiento_cuota(Date fecha_vencimiento_cuota) {
        this.fecha_vencimiento_cuota = fecha_vencimiento_cuota;
    }

    public Date getFecha_pago_cuota() {
        return fecha_pago_cuota;
    }

    public void setFecha_pago_cuota(Date fecha_pago_cuota) {
        this.fecha_pago_cuota = fecha_pago_cuota;
    }

    public Integer getInteres_cuota() {
        return interes_cuota;
    }

    public void setInteres_cuota(Integer interes_cuota) {
        this.interes_cuota = interes_cuota;
    }

    public ArancelEntity getArancel() {
        return arancel;
    }

    public void setArancel(ArancelEntity arancel) {
        this.arancel = arancel;
    }

    public void setId(Integer id) {
    }
}
