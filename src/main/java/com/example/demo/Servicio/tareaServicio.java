package com.example.demo.Servicio;

import com.example.demo.Modelo.tareaModelo;
import com.example.demo.Repositorio.tareaRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class tareaServicio {

    tareaRepositorio tarearepositorio;

    public tareaServicio(tareaRepositorio tarearepositorio) {
        this.tarearepositorio = tarearepositorio;
    }

    public Object crearTarea(tareaModelo tareaModelo){
        return tarearepositorio.save(tareaModelo);
    }

    public List<tareaModelo> obtenerTareas(){
        return tarearepositorio.findAll();
    }


    public tareaModelo save(tareaModelo tareamodelo) {
        return tarearepositorio.save(tareamodelo);
    }

    public Optional<tareaModelo> findById(Integer id) {
        return tarearepositorio.findById(id);
    }

    public void deleteById(Integer id) {
        tarearepositorio.deleteById(id);
    }
}
