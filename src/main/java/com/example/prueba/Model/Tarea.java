package com.example.prueba.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tareas")
public class Tarea {

    private long id;
    private String nombreTarea;

    public Tarea() {

    }

    public Tarea(String nombreTarea) {
        this.nombreTarea = nombreTarea;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "nombre_tarea", nullable = false)
    public String getNombreTarea() {
        return nombreTarea;
    }
    public void setNombreTarea(String nombreTarea) {
        this.nombreTarea = nombreTarea;
    }
}
