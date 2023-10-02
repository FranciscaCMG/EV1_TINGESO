package cl.usach.tingeso.ev1.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "matricula")
public class MatriculaEntity {
    @Id
    @Column(name = "id_matricula", nullable = false)
    private Integer id_matricula;
    private Integer monto_matricula;
    private Date fecha_matricula;
    private Date fecha_vencimiento;

    @ManyToOne
    @JoinColumn(name = "id_arancel")
    private ArancelEntity arancel;




}
