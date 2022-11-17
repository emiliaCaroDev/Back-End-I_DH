package com.dh.clinica_Odontologica.controller;

import com.dh.clinica_Odontologica.domain.Odontologo;
import com.dh.clinica_Odontologica.service.IOdontologoService;
import com.dh.clinica_Odontologica.service.impl.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/odontologo")
public class OdontologoController {

private IOdontologoService odontologoService;

    @Autowired
    public OdontologoController(IOdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }

    @GetMapping("odontologo/{id}")
    public String getOdontologoXId(Model model, @PathVariable("id") Integer id){

        Odontologo odontologo=odontologoService.buscarOdontologoXId(id);
        model.addAttribute("nombreOdontologo",odontologo.getNombre());
        model.addAttribute("apellidoOdontologo",odontologo.getApellido());
        model.addAttribute("matriculaOdontologo",odontologo.getNumeroMatricula());

        return "odontologo";
    }


}
