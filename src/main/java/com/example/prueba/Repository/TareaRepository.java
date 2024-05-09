package com.example.prueba.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.prueba.Model.Tarea;


@Repository
public interface TareaRepository extends JpaRepository<Tarea, Long>{

}
