package cl.usach.tingeso.ev1.services;

import cl.usach.tingeso.ev1.entities.ArancelEntity;
import cl.usach.tingeso.ev1.repositories.CuotaRepository;
import cl.usach.tingeso.ev1.entities.CuotaEntity;
import cl.usach.tingeso.ev1.entities.EstudianteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;

@Service
public class CuotaService {

    @Autowired
    CuotaRepository cuotaRepository;

    @Autowired
    EstudianteService estudianteService;

    @Autowired
    ArancelService arancelService;

    public List<CuotaEntity> obtenerCuotaPorRut(String rutEstudiante) {
        return cuotaRepository.findByRutEstudiante(rutEstudiante);
    }

    public void guardarCuota( Integer idArancel,Integer nroCuota) {

        System.out.println("entre ");
        Integer valor;
        String rut = "";
        String fechaP = "";
        String estado = "No pagada";


        ArancelEntity arancel = arancelService.obtenerArancelPorId(idArancel);
        rut = arancel.getRutEstudiante();
        valor = arancel.getMonto() / arancel.getCantidadCuotas();
        List<CuotaEntity> cuotasExistentes = cuotaRepository.findByRutEstudianteAndNroCuota(rut, nroCuota);

        System.out.println(cuotasExistentes);


        if (cuotasExistentes.isEmpty()) {
            // Si no existen cuotas para el mismo rut y número de cuota, crear una nueva cuota
            CuotaEntity cuotaEntity = new CuotaEntity();
            cuotaEntity.setRutEstudiante(rut);
            cuotaEntity.setNroCuota(nroCuota);
            cuotaEntity.setValorCuota(valor);
            cuotaEntity.setFechaVencimiento("05-"+ String.valueOf(nroCuota+9) + "-2023");
            cuotaEntity.setFechaPago(fechaP);
            cuotaEntity.setEstado(estado);
            cuotaRepository.save(cuotaEntity);

        } else {
            // Puedes manejar la situación donde ya existe una cuota con el mismo rut y número de cuota
            System.out.println("Ya existe una cuota para el mismo rut y número de cuota.");
        }

    }


    public void pagarCuota(Integer idCuota) {
        CuotaEntity cuota = cuotaRepository.findById(idCuota).get();
        Date fecha = new Date();
        // Crear un formato de fecha
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        cuota.setFechaPago(formato.format(fecha));
        cuota.setEstado("Pagada");
        cuotaRepository.save(cuota);
    }
}
