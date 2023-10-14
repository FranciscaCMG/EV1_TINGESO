package cl.usach.tingeso.ev1.controllers;

import cl.usach.tingeso.ev1.entities.ArancelEntity;
import cl.usach.tingeso.ev1.entities.EstudianteEntity;
import cl.usach.tingeso.ev1.services.ArancelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/arancel")
public class ArancelController {

    @Autowired
    ArancelService arancelService;

    @GetMapping("/listar")
    public String listar(Model model) {
        List<ArancelEntity> aranceles= arancelService.obtenerArancel();
        model.addAttribute("aranceles", aranceles);
        return "mostrarArancel";
    }

    @GetMapping("/agregar-arancel")
    public String arancel(){
        return "ingresar-arancel"; }

    @PostMapping("/agregar-arancel")
    public String nuevoArancel(@RequestParam("rutEstudiante") String rutEstudiante,
                               @RequestParam("monto") Integer monto,
                               @RequestParam("tipoPago") String tipoPago,
                               @RequestParam("cantidadCuotas") Integer cantidadCuotas){
        System.out.println("Rut: "+rutEstudiante);
        System.out.println("Monto: "+monto);
        System.out.println("Tipo de pago: "+tipoPago);
        System.out.println("Cantidad de cuotas: "+cantidadCuotas);
        arancelService.guardarArancel(rutEstudiante, monto, tipoPago, cantidadCuotas);
        return "redirect:/arancel/listar";
    }


    /*
        EstudianteEntity estudiante = estudianteService.obtenerEstudiantePorRut(rut);
        arancelService.crearArancel(rut, tipoColegioP, estudiante);
     */

}
