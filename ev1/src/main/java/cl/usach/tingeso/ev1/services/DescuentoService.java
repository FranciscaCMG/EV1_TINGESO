package cl.usach.tingeso.ev1.services;

import cl.usach.tingeso.ev1.entities.DescuentoEntity;
import cl.usach.tingeso.ev1.entities.EstudianteEntity;
import cl.usach.tingeso.ev1.repositories.DescuentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class DescuentoService {

    @Autowired
    DescuentoRepository descuentoRepository;

    public List<DescuentoEntity> obtenerDescuentos() {
        return descuentoRepository.findAll();
    }

    public void guardarDescuento(Integer id, Integer dcto_colegio, Integer dcto_egreso, Integer dcto_promedio, Integer interes_meses_atraso){

          DescuentoEntity descuento = new DescuentoEntity();
          descuento.setId_descuento(id);
          descuento.setDcto_colegio(dcto_colegio);
          descuento.setDcto_egreso(dcto_egreso);
          descuento.setDcto_promedio(dcto_promedio);
          descuento.setInteres_meses_atraso(interes_meses_atraso);
          descuentoRepository.save(descuento);

    }

    public Integer calcularDescuento(EstudianteEntity estudiante){
        Integer dcto_colegio=0;
        Integer dcto_egreso=0;
        Integer dcto_total=0;

        // Descuento Colegio

        if(estudiante.getTipoColegioP().equals("Municipal")){
            dcto_colegio=20;
        }
        else if(estudiante.getTipoColegioP().equals("Subvencionado")){
            dcto_colegio=10;
        }
        else if(estudiante.getTipoColegioP().equals("Privado")){
            dcto_colegio=0;
        }

        // Descuento Egreso

        if(estudiante.getAnioEgreso()<=2018){
            dcto_egreso=0;
        }
        else if(estudiante.getAnioEgreso()<=2020 && estudiante.getAnioEgreso()>2018){
            dcto_egreso=4;
        }
        else if(estudiante.getAnioEgreso()<=2022 && estudiante.getAnioEgreso()>2020){
            dcto_egreso=8;
        }
        else if(estudiante.getAnioEgreso()>=2023){
            dcto_egreso=15;
        }
        dcto_total=dcto_colegio+dcto_egreso;

        return dcto_total;
    }
}
