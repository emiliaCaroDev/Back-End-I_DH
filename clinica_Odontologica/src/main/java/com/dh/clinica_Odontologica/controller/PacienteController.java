package com.dh.clinica_Odontologica.controller;

import com.dh.clinica_Odontologica.domain.Paciente;
import com.dh.clinica_Odontologica.service.impl.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PacienteController {

    private PacienteService pacienteService;

    //constructor
    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping("/paciente/{email}")
    public String getPacienteXEmail(Model model, @PathVariable("email") String email){
        Paciente paciente=pacienteService.buscarXEmail(email);
        model.addAttribute("nombre",paciente.getNombre());
        model.addAttribute("apellido",paciente.getApellido());
        return "index";
    }
}
