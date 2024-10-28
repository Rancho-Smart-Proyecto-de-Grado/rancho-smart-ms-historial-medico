package com.rancho_smart.ms_historial_medico.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "HISTORIAL_MEDICO")
public class HistorialMedico {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DESCRIPCION")
    private String descripcion;
     
    @Column(name = "ID_ANIMAL")
    private Long idAnimal;

    @Column(name = "DIAGNOSTICO")
    private String diagnostico;

    @Column(name = "ENFERMEDADES_CRONICAS")
    private boolean enfermedadesCronicas;
    
    @ElementCollection
    private List<String> observaciones;

    public HistorialMedico() {
    }

    public HistorialMedico(String descripcion, Long idAnimal, String diagnostico, boolean enfermedadesCronicas) {
        this.descripcion = descripcion;
        this.idAnimal = idAnimal;
        this.diagnostico = diagnostico;
        this.enfermedadesCronicas = enfermedadesCronicas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
