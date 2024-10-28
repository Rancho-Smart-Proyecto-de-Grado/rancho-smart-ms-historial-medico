package com.rancho_smart.ms_historial_medico.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rancho_smart.ms_historial_medico.entity.HistorialMedico;
import com.rancho_smart.ms_historial_medico.repository.HistorialMedicoRepository;

@Service
public class HistorialMedicoService {
    
    @Autowired
    private HistorialMedicoRepository historialMedicoRepository;

    public List<HistorialMedico>getHistorialesMedicos(){
        return this.historialMedicoRepository.findAll();
    }

    public List<HistorialMedico>getHistorialesMedicosByAnimal(Long idAnimal){
        return this.historialMedicoRepository.findByIdAnimal(idAnimal);
    }

    public List<Long> getHistorialIdsPorIdAnimal(Long idAnimal) {
        return historialMedicoRepository.findIdByIdAnimal(idAnimal);
    }
    
    public Optional<HistorialMedico> getHistorialMedico(Long id){
        return this.historialMedicoRepository.findById(id);
    }

    public HistorialMedico saveHistorialMedico(HistorialMedico historialMedico){
        return this.saveHistorialMedico(historialMedico);
    }

    public void deleteHistorialMedico(Long id){
        this.historialMedicoRepository.deleteById(id);
    } 
}