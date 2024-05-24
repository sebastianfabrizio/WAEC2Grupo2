package com.example.WAEC2Grupo2.Controller.backoffice;

import com.example.WAEC2Grupo2.Model.bd.Especialidad;
import com.example.WAEC2Grupo2.Model.bd.Medico;
import com.example.WAEC2Grupo2.Model.dto.request.EspecialidadRequest;
import com.example.WAEC2Grupo2.Model.dto.response.RespuestaResponse;
import com.example.WAEC2Grupo2.Services.IEspecialidadService;
import com.example.WAEC2Grupo2.Services.IMedicoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/especialidad")
public class EspecialidadController {

    private IEspecialidadService especialidadService;
    private IMedicoService medicoService;

    @GetMapping(value = "/home")
    public String especialida(Model model) {
        model.addAttribute("especialidad", especialidadService.listaEspecialidad());
        return "backoffice/especialidad/frmespecialidad";
    }

    @GetMapping(value = "/list")
    @ResponseBody
    public List<Especialidad> listadoEspecialidad() {
        return especialidadService.listaEspecialidad();
    }

    @GetMapping(value = "/medico")
    @ResponseBody
    public List<Medico> listadoMedico() {
        return medicoService.listadoMedicos();
    }

    @PostMapping(value = "/home")
    @ResponseBody
    public RespuestaResponse guardarEspecialidad(@RequestBody EspecialidadRequest especialidadRequest) {
        boolean rs = true;
        String men = "Guardado Exitosamente";
        try {
            Medico m = new Medico();
            m.setIdmedico(especialidadRequest.getIdmedico());
            Especialidad e = new Especialidad();
            if(especialidadRequest.getIdmedico() > 0) {
                e.setIdespecialidad(especialidadRequest.getIdespecialidad());
            }
            e.setTitulo(especialidadRequest.getTitulo());
            e.setFuncion(especialidadRequest.getFuncion());
            e.setFechgraduacion(especialidadRequest.getFechgraduacion());
            especialidadService.guardarEspecialidad(e);
        }catch (Exception e) {
            rs = false;
            men = "Error No Se Pudo Guardar";
        }
        return RespuestaResponse.builder().resultado(rs).mensaje(men).build();
    }

    @GetMapping(value = "/especialidad/{idespecialidad}")
    @ResponseBody
    public Especialidad buscarEspecialidad(@PathVariable Integer idespecialidad) {
        return especialidadService.buscarEspecialidad(idespecialidad);
    }
}
