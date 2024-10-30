package com.rancho_smart.ms_historial_medico.service;

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
            this.historialMedicoService.saveHistorialMedico(historialMedico);
            System.out.println("Historial Médico creado para el animal ID: " + animalDTO.getIdAnimal());
        } catch (Exception e) {
            System.out.println("Error al procesar el mensaje de animal creado: " + e.getMessage());
            // Aquí podrías agregar lógica adicional, como enviar el mensaje a un tópico de errores
        }
    }
}
