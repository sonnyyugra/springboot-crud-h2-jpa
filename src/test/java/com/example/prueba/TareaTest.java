package com.example.prueba;

import org.junit.Test;

import com.example.prueba.Model.Tarea;

import static org.junit.Assert.assertEquals;

public class TareaTest {

    @Test
    public void testFunciones() {
        Tarea tarea = new Tarea("prueba");   
        assertEquals("prueba", tarea.getNombreTarea());
        tarea.setNombreTarea("prueba2");
        assertEquals("prueba2", tarea.getNombreTarea());
    }
}
