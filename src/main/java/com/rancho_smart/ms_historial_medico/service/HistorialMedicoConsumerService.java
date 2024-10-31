package com.rancho_smart.ms_historial_medico.service;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.rancho_smart.AnimalDTO;
import com.rancho_smart.ms_historial_medico.entity.HistorialMedico;

@Service
public class HistorialMedicoConsumerService {
    
    @Autowired
    private HistorialMedicoService historialMedicoService;

    @KafkaListener(topics = "animal_creado", groupId = "salud")
    public void recibirMensajeAnimalCreado(@Payload AnimalDTO animalDTO) {
        System.out.println("Mensaje de animal creado recibido: " + animalDTO);
        
        try {
            if (animalDTO.getIdAnimal() == null) {
                System.out.println("El ID del animal es nulo. Mensaje ignorado.");
                return;
            }
            
            HistorialMedico historialMedico = new HistorialMedico();
            historialMedico.setIdAnimal(animalDTO.getIdAnimal());
            historialMedico.setDescripcion("Este es el historial médico de " + animalDTO.getNombre() + ".\nFecha de Creación: " + LocalDateTime.now());
            if(historialMedico.getObservaciones() == null){
                historialMedico.setObservaciones(new ArrayList<>());
            }
            historialMedico.getObservaciones().add("Este Historial Médico se creó de manera automática.");
            this.historialMedicoService.saveHistorialMedico(historialMedico);
            System.out.println("Historial Médico creado para el animal ID: " + animalDTO.getIdAnimal());
        } catch (Exception e) {
            System.out.println("Error al procesar el mensaje de animal creado: " + e.getMessage());
            // Aquí podrías agregar lógica adicional, como enviar el mensaje a un tópico de errores
        }
    }
}
