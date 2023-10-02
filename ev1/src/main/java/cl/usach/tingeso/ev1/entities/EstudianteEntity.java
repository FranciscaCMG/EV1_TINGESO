package cl.usach.tingeso.ev1.entities;

import javax.persistence.*;

@Entity
@Table(name = "estudiante")
public class EstudianteEntity {
    @Id
    @Column(name = "rut", nullable = false)
    private String rut;
    private String apellidos;
    private String nombres;
    private String fechanacimiento;
    private String tipoColegioP;
    private String nombreColegio;
    private Integer anioEgreso;

    @ManyToOne
    @JoinColumn(name = "id_matricula")
    private MatriculaEntity matricula;


    public void showEstudiante(EstudianteEntity estudiante){
        System.out.println("Rut: " + estudiante.getRut());
        System.out.println("Apellidos: " + estudiante.getApellidos());
        System.out.println("Nombres: " + estudiante.getNombres());
        System.out.println("Fecha de nacimiento: " + estudiante.getFechanacimiento());
        System.out.println("Tipo de colegio: " + estudiante.getTipoColegioP());
        System.out.println("Nombre de colegio: " + estudiante.getNombreColegio());
        System.out.println("Año de egreso: " + estudiante.getAnioEgreso());
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(String fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public String getTipoColegioP() {
        return tipoColegioP;
    }

    public void setTipoColegioP(String tipoColegioP) {
        this.tipoColegioP = tipoColegioP;
    }

    public String getNombreColegio() {
        return nombreColegio;
    }

    public void setNombreColegio(String nombreColegio) {
        this.nombreColegio = nombreColegio;
    }

    public Integer getAnioEgreso() {
        return anioEgreso;
    }

    public void setAnioEgreso(Integer anioEgreso) {
        this.anioEgreso = anioEgreso;
    }

    public MatriculaEntity getMatricula() {
        return matricula;
    }

    public void setMatricula(MatriculaEntity matricula) {
        this.matricula = matricula;
    }
}
