package com.rancho_smart.ms_historial_medico.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rancho_smart.ms_historial_medico.entity.HistorialMedico;

import jakarta.transaction.Transactional;

@Repository
public interface HistorialMedicoRepository extends JpaRepository<HistorialMedico, Long>{
    
    List<HistorialMedico> findByIdAnimal(Long idAnimal);

    @Transactional
    @Query("SELECT hm.id FROM HISTORIAL_MEDICO hm WHERE hm.idAnimal = :idAnimal")
    List<Long> findIdByIdAnimal(@Param("idAnimal") Long idAnimal);
}
