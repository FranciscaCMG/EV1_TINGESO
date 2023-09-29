package cl.usach.tingeso.ev1.services;

import cl.usach.tingeso.ev1.entities.EstudianteEntity;
import cl.usach.tingeso.ev1.repositories.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteService {
    @Autowired
    EstudianteRepository estudianteRepository;

    public List<EstudianteEntity> obtenerEstudiantes() {
        return estudianteRepository.findAll();
    }

    public void guardarEstudiante(String rut, String apellidos, String nombres, String fechanacimiento, String tipoColegioP, String nombreColegio, Integer anioEgreso){
        EstudianteEntity estudiante = new EstudianteEntity();
        estudiante.setRut(rut);
        estudiante.setApellidos(apellidos);
        estudiante.setNombres(nombres);
        estudiante.setFechanacimiento(fechanacimiento);
        estudiante.setTipoColegioP(tipoColegioP);
        estudiante.setNombreColegio(nombreColegio);
        estudiante.setAnioEgreso(anioEgreso);
        estudianteRepository.save(estudiante);
    }
}

