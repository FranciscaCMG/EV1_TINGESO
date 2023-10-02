package cl.usach.tingeso.ev1.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "arancel")
public class ArancelEntity {
    @Id
    @Column(name = "id_arancel", nullable = false)
    private Integer id_arancel;
    private Integer monto_arancel;
    private Date fecha_pago_arancel;
    private Date fecha_vencimiento_arancel;
    private Integer nro_cuotas_arancel;
    private String tipo_pago_arancel;
    private Integer nro_cuotas_pagadas;
    private Integer nro_cuotas_atrasadas;

    public Integer getId_arancel() {
        return id_arancel;
    }

    public void setId_arancel(Integer id_arancel) {
        this.id_arancel = id_arancel;
    }

    public Integer getMonto_arancel() {
        return monto_arancel;
    }

    public void setMonto_arancel(Integer monto_arancel) {
        this.monto_arancel = monto_arancel;
    }

    public Date getFecha_pago_arancel() {
        return fecha_pago_arancel;
    }

    public void setFecha_pago_arancel(Date fecha_pago_arancel) {
        this.fecha_pago_arancel = fecha_pago_arancel;
    }

    public Date getFecha_vencimiento_arancel() {
        return fecha_vencimiento_arancel;
    }

    public void setFecha_vencimiento_arancel(Date fecha_vencimiento_arancel) {
        this.fecha_vencimiento_arancel = fecha_vencimiento_arancel;
    }

    public Integer getNro_cuotas_arancel() {
        return nro_cuotas_arancel;
    }

    public void setNro_cuotas_arancel(Integer nro_cuotas_arancel) {
        this.nro_cuotas_arancel = nro_cuotas_arancel;
    }

    public String getTipo_pago_arancel() {
        return tipo_pago_arancel;
    }

    public void setTipo_pago_arancel(String tipo_pago_arancel) {
        this.tipo_pago_arancel = tipo_pago_arancel;
    }

    public Integer getNro_cuotas_pagadas() {
        return nro_cuotas_pagadas;
    }

    public void setNro_cuotas_pagadas(Integer nro_cuotas_pagadas) {
        this.nro_cuotas_pagadas = nro_cuotas_pagadas;
    }

    public Integer getNro_cuotas_atrasadas() {
        return nro_cuotas_atrasadas;
    }

    public void setNro_cuotas_atrasadas(Integer nro_cuotas_atrasadas) {
        this.nro_cuotas_atrasadas = nro_cuotas_atrasadas;
    }
}
