package cl.usach.tingeso.ev1.services;

import cl.usach.tingeso.ev1.entities.CuotaEntity;
import cl.usach.tingeso.ev1.entities.EstudianteEntity;
import cl.usach.tingeso.ev1.repositories.CuotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CoutaService {

    @Autowired
    CuotaRepository cuotaRepository;

    @Autowired
    DescuentoService descuento;

    public List<CuotaEntity> obtenerCuotas() {
        return cuotaRepository.findAll();
    }

    public void guardarCuota(Integer id, Integer monto, Integer nro, Boolean estado,  Date fechaVencimiento, Date fechaPago, Integer interes){
        CuotaEntity cuota = new CuotaEntity();
        cuota.setId_cuota(id);
        cuota.setMonto_cuota(monto);
        cuota.setNro_cuota(nro);
        cuota.setEstado_cuota(estado);
        cuota.setFecha_vencimiento_cuota(fechaVencimiento);
        cuota.setFecha_pago_cuota(fechaPago);
        cuota.setInteres_cuota(interes);
        cuotaRepository.save(cuota);
    }

    public void generarCuotas(EstudianteEntity estudiante){
        Integer arancel= 1500000;
        Integer cuotas_maximas = 0;

        Integer dcto= descuento.calcularDescuento(estudiante);

        if (estudiante.getTipoColegioP().equals("Municipal")){
            cuotas_maximas = 10;
        }
        else if(estudiante.getTipoColegioP().equals("Subvencionado")){
            cuotas_maximas = 7;
        }
        else if(estudiante.getTipoColegioP().equals("Privado")){
            cuotas_maximas = 4;
        }

        for (int i = 0; i < cuotas_maximas; i++) {
            CuotaEntity cuota = new CuotaEntity();
            cuota.setId_cuota(i);
            cuota.setMonto_cuota(arancel-(arancel*dcto)/cuotas_maximas);
            cuota.setNro_cuota(i);
            cuota.setEstado_cuota(false);
            cuota.setFecha_vencimiento_cuota(new Date());
            cuota.setFecha_pago_cuota(new Date());
            cuota.setInteres_cuota(0);
            cuotaRepository.save(cuota);
        }
    }
}
