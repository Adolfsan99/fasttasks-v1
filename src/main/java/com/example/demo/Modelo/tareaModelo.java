package com.example.demo.Modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity(name = "tareas")
@AllArgsConstructor
@NoArgsConstructor

public class tareaModelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private int id;
    @Column(name = "descripcion")
    private String descripcion;

}
