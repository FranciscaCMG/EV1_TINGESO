package cl.usach.tingeso.ev1.services;

import cl.usach.tingeso.ev1.entities.ArancelEntity;
import cl.usach.tingeso.ev1.entities.EstudianteEntity;
import cl.usach.tingeso.ev1.repositories.ArancelRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArancelService {

    @Autowired
    ArancelRepository arancelRepository;

    @Autowired
    EstudianteService estudianteService;


    public List<ArancelEntity> obtenerArancel() {
        return arancelRepository.findAll();
    }

    public ArancelEntity obtenerArancelPorId(Integer idArancel) {
        Optional<ArancelEntity> optionalArancel = arancelRepository.findById(idArancel);
        if (optionalArancel.isPresent()) {
            return optionalArancel.get();
        } else {
            // Puedes manejar el caso de que el arancel no se encuentra, por ejemplo, lanzando una excepción o devolviendo un valor predeterminado.
            return null; // O cualquier otro manejo de error que prefieras.
        }
    }

    public Integer descuentoTipoPago(String tipoPago, EstudianteEntity estudianteEntity){
        Integer descuento = 0;
        Integer anioActual= 2023;
        if (tipoPago.equals("Contado")){
            descuento = 50;
        }
        else if (tipoPago.equals("Cuotas")){

            if (estudianteEntity.getTipoColegioP().equals("Municipal")){
                descuento = 20;
            }
            else if (estudianteEntity.getTipoColegioP().equals("Subvencionado")){
                descuento = 10;
            }
            else if (estudianteEntity.getTipoColegioP().equals("Particular")){
                descuento = 0;
            }

            if (estudianteEntity.getAnioEgreso().equals(anioActual)){
                descuento += 15;
            } else if (anioActual-estudianteEntity.getAnioEgreso()<= 2 && anioActual-estudianteEntity.getAnioEgreso() > 1) {
                descuento += 8;
            } else if (anioActual-estudianteEntity.getAnioEgreso()<= 4 && anioActual-estudianteEntity.getAnioEgreso() > 2) {
                descuento += 4;

            }
            else if (anioActual-estudianteEntity.getAnioEgreso()> 4) {
                descuento += 0;
            }
        }

        return descuento;
    }

    public Integer modificarMontoTotal(Integer descuento, Integer monto){

        Integer montoFinal = monto - (monto*descuento/100);
        return montoFinal;
    }



    public void guardarArancel(String rut, Integer monto, String tipoPago, Integer cantidadCuotas){
        Integer descuento = 0;
        EstudianteEntity estudiante = estudianteService.obtenerEstudiantePorRut(rut);

        ArancelEntity arancel= new ArancelEntity();
        arancel.setRutEstudiante(rut);

        descuento = descuentoTipoPago(tipoPago, estudiante);
        monto = modificarMontoTotal(descuento, monto);
        arancel.setMonto(monto);

        arancel.setTipoPago(tipoPago);
        arancel.setCantidadCuotas(cantidadCuotas);
        System.out.println(arancel);
        arancelRepository.save(arancel);
    }






}
