package com.example.demo.Repositorio;

import com.example.demo.Modelo.tareaModelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface tareaRepositorio extends JpaRepository<tareaModelo, Integer> {

}