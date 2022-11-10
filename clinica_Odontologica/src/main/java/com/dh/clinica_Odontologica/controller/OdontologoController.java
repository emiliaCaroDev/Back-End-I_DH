package com.dh.clinica_Odontologica.controller;

import com.dh.clinica_Odontologica.domain.Odontologo;
import com.dh.clinica_Odontologica.service.impl.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OdontologoController {

private OdontologoService odontologoService;

    @Autowired
    public OdontologoController(OdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }

    @GetMapping("/index")
    public String getOdontologoXId(Model model, @RequestParam("id") Integer id){

        Odontologo odontologo=odontologoService.buscarOdontologoXId(id);
        model.addAttribute("nombre",odontologo.getNombre());
        model.addAttribute("apellido",odontologo.getApellido());
        model.addAttribute("matricula",odontologo.getNumeroMatricula());

        return "index";
    }


}
