package com.dh.clinica_Odontologica.controller;

import com.dh.clinica_Odontologica.domain.Odontologo;
import com.dh.clinica_Odontologica.service.IOdontologoService;
import com.dh.clinica_Odontologica.service.impl.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

private IOdontologoService odontologoService;

    @Autowired
    public OdontologoController(IOdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }

    /*
    @GetMapping("odontologos/{id}")
    public String getOdontologoXId(Model model, @PathVariable("id") Integer id){

        Odontologo odontologo=odontologoService.buscarOdontologoXId(id);
        model.addAttribute("nombreOdontologo",odontologo.getNombre());
        model.addAttribute("apellidoOdontologo",odontologo.getApellido());
        model.addAttribute("matriculaOdontologo",odontologo.getNumeroMatricula());

        return "odontologo";
    }
    */

    @GetMapping("/{id}")
    public Odontologo getOdontologoXId(@PathVariable("id") Integer id){
        return odontologoService.buscarOdontologoXId(id);
    }

    @PostMapping()
    public Odontologo addOdontologo(@RequestBody Odontologo odontologo){
        return odontologoService.guardarOdontologo(odontologo);
    }

    @PutMapping()
    public Odontologo updateOdontologo(@RequestBody Odontologo odontologo){
        return odontologoService.actualizarOdontologo(odontologo);
    }

    @DeleteMapping("/{id}")
    public void deleteOdontologo(@PathVariable("id") Integer id){
        odontologoService.eliminarOdontologo(id);
    }

    @GetMapping()
    public List<Odontologo> getAllOdontologos(){
        return odontologoService.listarTodosOdontologos();
    }




}
