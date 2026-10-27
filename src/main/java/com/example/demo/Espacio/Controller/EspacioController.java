
package com.example.demo.Espacio.Controller;

import com.example.demo.Espacio.Espacio;
import com.example.demo.Espacio.Service.EspacioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/espacios")
@CrossOrigin(origins = "*")
public class EspacioController {

    @Autowired
    private EspacioService espacioService;

    // Registrar un espacio
    @PostMapping
    public Espacio guardarEspacio(@RequestBody Espacio espacio) {
        return espacioService.guardarEspacio(espacio);
    }

    // Listar todos los espacios
    @GetMapping
    public List<Espacio> listarEspacios() {
        return espacioService.listarEspacios();
    }

    // Buscar un espacio por ID
    @GetMapping("/{id}")
    public Espacio buscarEspacioPorId(@PathVariable String id) {
        return espacioService.buscarEspacioPorId(id);
    }

    // Buscar espacios por nombre
    @GetMapping("/buscar")
    public List<Espacio> buscarPorNombre(
            @RequestParam String nombre) {
        return espacioService.buscarEspaciosPorNombre(nombre);
    }

    // Listar espacios disponibles
    @GetMapping("/disponibles")
    public List<Espacio> listarDisponibles() {
        return espacioService.listarEspaciosDisponibles();
    }

    // Actualizar un espacio
    @PutMapping("/{id}")
    public Espacio actualizarEspacio(
            @PathVariable String id,
            @RequestBody Espacio espacio) {
        return espacioService.actualizarEspacio(id, espacio);
    }

    // Eliminar un espacio
    @DeleteMapping("/{id}")
    public String eliminarEspacio(@PathVariable String id) {
        espacioService.eliminarEspacio(id);
        return "Espacio eliminado correctamente";
    }
}
