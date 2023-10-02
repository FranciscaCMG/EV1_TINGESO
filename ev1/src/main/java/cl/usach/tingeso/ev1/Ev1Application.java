package cl.usach.tingeso.ev1;

import cl.usach.tingeso.ev1.entities.EstudianteEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ev1Application {

	public static void main(String[] args) {
		SpringApplication.run(Ev1Application.class, args);

		EstudianteEntity estudiante = new EstudianteEntity();

		estudiante.setRut("12345678-9");
		estudiante.setApellidos("Perez");
		estudiante.setNombres("Juan");
		estudiante.setFechanacimiento("01-01-1990");
		estudiante.setTipoColegioP("Municipal");
		estudiante.setNombreColegio("Colegio de la esquina");
		estudiante.setAnioEgreso(2010);

		estudiante.showEstudiante(estudiante);

	}
}
