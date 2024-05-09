package com.example.prueba.Controller;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.prueba.Exception.ResourceNotFoundException;
import com.example.prueba.Model.Tarea;
import com.example.prueba.Repository.TareaRepository;

@RestController
@RequestMapping("/api/v1")
public class TareaController {
    @Autowired
    private TareaRepository tareaRepository;

    @GetMapping("/tareas")
    public List < Tarea > getAllTareas() {
        return tareaRepository.findAll();
    }

    @GetMapping("/tareas/{id}")
    public ResponseEntity < Tarea > getTareaById(@PathVariable(value = "id") Long tareaId)
    throws ResourceNotFoundException {
        Tarea tarea = tareaRepository.findById(tareaId)
            .orElseThrow(() -> new ResourceNotFoundException("tarea no encontrada para id :: " + tareaId));
        return ResponseEntity.ok().body(tarea);
    }

    @PostMapping("/tareas")
    public Tarea createTarea(@Valid @RequestBody Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    @PutMapping("/tareas/{id}")
    public ResponseEntity < Tarea > updateTarea(@PathVariable(value = "id") Long tareaId,
        @Valid @RequestBody Tarea tareaDetails) throws ResourceNotFoundException {
        Tarea tarea = tareaRepository.findById(tareaId)
            .orElseThrow(() -> new ResourceNotFoundException("tarea no encontrada para id :: " + tareaId));

        tarea.setNombreTarea(tareaDetails.getNombreTarea());
        final Tarea updatedEmployee = tareaRepository.save(tarea);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/tareas/{id}")
    public Map < String, Boolean > deleteTarea(@PathVariable(value = "id") Long tareaId)
    throws ResourceNotFoundException {
        Tarea tarea = tareaRepository.findById(tareaId)
            .orElseThrow(() -> new ResourceNotFoundException("tarea no encontrada para id :: " + tareaId));

            tareaRepository.delete(tarea);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
