package cl.usach.tingeso.ev1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cuotas")
public class CuotasController {

        @RequestMapping("/listar")
        public String listar(){
            return "mostrarCuotas";
        }

        @RequestMapping("/agregar-cuotas")
        public String agregar(){
            return "ingresar-cuotas";
        }

        @RequestMapping("/editar-cuotas")
        public String editar(){
            return "editar-cuotas";
        }

        @RequestMapping("/eliminar-cuotas")
        public String eliminar(){
            return "eliminar-cuotas";
        }
}
