package com.dh.clinica_Odontologica.controller;

import com.dh.clinica_Odontologica.dao.impl.PacienteDAOH2;
import com.dh.clinica_Odontologica.domain.Odontologo;
import com.dh.clinica_Odontologica.domain.Paciente;
import com.dh.clinica_Odontologica.domain.Turno;
import com.dh.clinica_Odontologica.service.IOdontologoService;
import com.dh.clinica_Odontologica.service.IPacienteService;
import com.dh.clinica_Odontologica.service.ITurnoService;
import com.dh.clinica_Odontologica.service.impl.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/turnos")
public class TurnoController {


    private ITurnoService turnoService;
    private IPacienteService pacienteService;
    private IOdontologoService odontologoService;
    @Autowired
    public TurnoController(ITurnoService turnoService,IPacienteService pacienteService,IOdontologoService odontologoService) {
        this.turnoService = turnoService;
        this.pacienteService=pacienteService;
        this.odontologoService=odontologoService;
    }

    @GetMapping("/turnos")
    public ResponseEntity<List<Turno>> getAllTurnos(){
        ResponseEntity response=null;
        return response.ok(turnoService.listarTodosTurnos());

    }

   /* @GetMapping("/turnos")
    public List<Turno> getAllTurnos(){
        return turnoService.listarTodosTurnos();
    }*/

    @GetMapping("searchById/{id}")
    public Turno getTurnoById(@PathVariable("id") Integer id){
        return turnoService.buscarTurnoXId(id);
    }

    @PostMapping("/turnos")
    public ResponseEntity<Turno> addTurno(@RequestBody Turno turno){
        ResponseEntity<Turno> response=null;
        Paciente pacienteABuscar= pacienteService.buscarXId(turno.getPaciente().getId());
        Odontologo odontologoABuscar= odontologoService.buscarOdontologoXId(turno.getOdontologo().getId());
        if(pacienteABuscar!=null && odontologoABuscar!=null){
           response=ResponseEntity.ok(turnoService.guardarTurno(turno));
        }
        else{
            response=ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return response;
    }

    @DeleteMapping("/turnos/{id}")
    public ResponseEntity<String> deleteTurno(@PathVariable("id") Integer id){
        ResponseEntity<String> response=null;
        if(turnoService.buscarTurnoXId(id)!=null){
            turnoService.eliminarTurno(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");
        }
        else{
            response= ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

}
