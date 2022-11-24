package com.dh.clinica_Odontologica.controller;

import com.dh.clinica_Odontologica.domain.Paciente;
import com.dh.clinica_Odontologica.service.IPacienteService;
import com.dh.clinica_Odontologica.service.impl.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private IPacienteService pacienteService;
    private Paciente paciente;

    //constructor
    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    /*
    //Con vista index
    @GetMapping("/{email}")
    public String getPacienteXEmail(Model model, @PathVariable("email") String email){
        paciente=pacienteService.buscarXEmail(email);
        model.addAttribute("nombre",paciente.getNombre());
        model.addAttribute("apellido",paciente.getApellido());
        return "index";
    }
    */


    /*@GetMapping("/{id}")
    public String getPacienteXId(Model model,@PathVariable("id") Integer id){
        paciente=pacienteService.buscarXId(id);
        model.addAttribute("nombre",paciente.getNombre());
        model.addAttribute("apellido",paciente.getApellido());
        return "index";
    }*/

    @GetMapping("searchById/{id}")
    public Paciente getPacienteXId(@PathVariable ("id") Integer id){
        return pacienteService.buscarXId(id);
    }

    @GetMapping("searchByEmail/{email}")
    public Paciente getPacienteXEmail(@PathVariable("email") String email){
        return pacienteService.buscarXEmail(email);
    }

    @PostMapping()
    public Paciente addPaciente(@RequestBody Paciente paciente){
        return pacienteService.guardarPaciente(paciente);
    }

    @PutMapping()
    public Paciente updatePaciente(@RequestBody Paciente paciente){

        /*Paciente pacienteActualizado= null;
        if(paciente.getId()!=null && pacienteService.buscarXId(paciente.getId())!=null){
            pacienteActualizado= pacienteService.actualizarPaciente(paciente);
        }
        return pacienteActualizado;
        */
        return pacienteService.actualizarPaciente(paciente);
    }

    @GetMapping()
    public List<Paciente> getAllPacientes(){
        return pacienteService.listarTodosPacientes();
    }

    @DeleteMapping("/{id}")
    public void detelePaciente(@PathVariable("id") Integer id){
        pacienteService.eliminarPaciente(id);
    }



}
