package com.rancho_smart.ms_historial_medico.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rancho_smart.ms_historial_medico.entity.HistorialMedico;
import com.rancho_smart.ms_historial_medico.service.HistorialMedicoService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/historiales-medicos")
public class HistorialMedicoRESTController {

    @Autowired
    private HistorialMedicoService historialMedicoService;

    @GetMapping
    public ResponseEntity<List<HistorialMedico>> getHistorialesMedicos() {
        List<HistorialMedico> listado = this.historialMedicoService.getHistorialesMedicos();
        return new ResponseEntity<>(listado, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistorialMedico> getHistorialMedico(@PathVariable Long id) {
        Optional<HistorialMedico> historialMedico = this.historialMedicoService.getHistorialMedico(id);
        return historialMedico.map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/animal/{idAnimal}")
    public ResponseEntity<HistorialMedico> getHistorialMedicoByIdAnimal(@PathVariable Long idAnimal) {
        HistorialMedico historiales = this.historialMedicoService.getHistorialesMedicosByIdAnimal(idAnimal);
        if (historiales != null) {
            return ResponseEntity.ok(historiales);
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<HistorialMedico> saveHistorialMedico(@RequestBody HistorialMedico historialMedico) {
        HistorialMedico historialMedicoCreado = this.historialMedicoService.saveHistorialMedico(historialMedico);
        return new ResponseEntity<>(historialMedicoCreado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HistorialMedico> updateHistorialMedico(@PathVariable Long id,
            @RequestBody HistorialMedico historialMedico) {
        if (!this.historialMedicoService.getHistorialMedico(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            historialMedico.setIdHistorialMedico(id);
            HistorialMedico historialMedicoActualizado = this.historialMedicoService
                    .saveHistorialMedico(historialMedico);
            return new ResponseEntity<>(historialMedicoActualizado, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HistorialMedico> deleteHistorialMedico(@PathVariable Long id) {
        if (!this.historialMedicoService.getHistorialMedico(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            this.historialMedicoService.deleteHistorialMedico(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}