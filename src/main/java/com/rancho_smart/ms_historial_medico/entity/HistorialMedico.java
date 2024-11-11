package com.rancho_smart.ms_historial_medico.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "HISTORIAL_MEDICO")
public class HistorialMedico {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHistorialMedico;

    @Column(name = "DESCRIPCION")
    private String descripcion;
     
    @Column(name = "ID_ANIMAL")
    private Long idAnimal;

    @Column(name = "DIAGNOSTICO")
    private String diagnostico;

    @Column(name = "ENFERMEDADES_CRONICAS")
    private boolean enfermedadesCronicas;
    
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> observaciones;

    public HistorialMedico() {
    }

    public HistorialMedico(String descripcion, Long idAnimal, String diagnostico, boolean enfermedadesCronicas) {
        this.descripcion = descripcion;
        this.idAnimal = idAnimal;
        this.diagnostico = diagnostico;
        this.enfermedadesCronicas = enfermedadesCronicas;
    }

    public Long getIdHistorialMedico() {
        return idHistorialMedico;
    }

    public void setIdHistorialMedico(Long idHistorialMedico) {
        this.idHistorialMedico = idHistorialMedico;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(Long idAnimal) {
        this.idAnimal = idAnimal;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public boolean isEnfermedadesCronicas() {
        return enfermedadesCronicas;
    }

    public void setEnfermedadesCronicas(boolean enfermedadesCronicas) {
        this.enfermedadesCronicas = enfermedadesCronicas;
    }

    public List<String> getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(List<String> observaciones) {
        this.observaciones = observaciones;
    }
}
