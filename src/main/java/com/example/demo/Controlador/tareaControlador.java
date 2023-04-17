package com.example.demo.Controlador;

import com.example.demo.Modelo.tareaModelo;
import com.example.demo.Servicio.tareaServicio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@CrossOrigin
@RequestMapping("/tareas")

public class tareaControlador {

    tareaServicio tareaservicio;

    public tareaControlador(tareaServicio tareaservicio) {
        this.tareaservicio = tareaservicio;
    }

    @PostMapping("/crear")
    public Object crearTarea(@RequestBody tareaModelo tareaModelo){
        return tareaservicio.crearTarea(tareaModelo);
    }

    @GetMapping("/ver")
    public List<tareaModelo> obtenerTareas(){
        return tareaservicio.obtenerTareas();
    }

    @PostMapping("editar={id}")
    public ResponseEntity<tareaModelo> updateById(@PathVariable Integer id, @RequestBody tareaModelo tareamodelo) {
        Optional<tareaModelo> datoOptional = tareaservicio.findById(id);
        if (datoOptional.isPresent()) {
            tareaModelo datoExistente = datoOptional.get();
            datoExistente.setDescripcion(tareamodelo.getDescripcion());
            tareaservicio.save(datoExistente);
            return ResponseEntity.ok(datoExistente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("eliminar={id}")
    public void deleteById(@PathVariable Integer id) {
        tareaservicio.deleteById(id);
    }
}
