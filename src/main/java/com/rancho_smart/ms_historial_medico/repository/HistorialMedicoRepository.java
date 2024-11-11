package com.rancho_smart.ms_historial_medico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rancho_smart.ms_historial_medico.entity.HistorialMedico;


@Repository
public interface HistorialMedicoRepository extends JpaRepository<HistorialMedico, Long>{
    public HistorialMedico findByIdAnimal(Long idAnimal);
}
