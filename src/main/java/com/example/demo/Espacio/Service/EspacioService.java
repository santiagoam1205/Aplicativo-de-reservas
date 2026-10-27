
package com.example.demo.Espacio.Service;

import com.example.demo.Espacio.Espacio;
import com.example.demo.Espacio.EspacioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspacioService {

    @Autowired
    private EspacioRepository espacioRepository;

    // Registrar un espacio
    public Espacio guardarEspacio(Espacio espacio) {

        if (espacio.getNombre() == null || espacio.getNombre().isBlank()) {
            throw new RuntimeException("El nombre del espacio es obligatorio");
        }

        if (espacio.getCapacidad() <= 0) {
            throw new RuntimeException("La capacidad debe ser mayor que cero");
        }

        return espacioRepository.save(espacio);
    }

    // Consultar todos los espacios
    public List<Espacio> listarEspacios() {
        return espacioRepository.findAll();
    }

    // Consultar un espacio por su ID
    public Espacio buscarEspacioPorId(String id) {
        return espacioRepository.findById(id);
    }

    // Buscar espacios por nombre
    public List<Espacio> buscarEspaciosPorNombre(String nombre) {
        return espacioRepository.findByNombreContaining(nombre);
    }

    // Consultar espacios disponibles
    public List<Espacio> listarEspaciosDisponibles() {
        return espacioRepository.findByDisponible(true);
    }

    // Actualizar un espacio
    public Espacio actualizarEspacio(String id, Espacio espacio) {

        Espacio espacioExistente = espacioRepository.findById(id);

        if (espacioExistente == null) {
            throw new RuntimeException("No se encontró el espacio");
        }

        if (espacio.getNombre() == null || espacio.getNombre().isBlank()) {
            throw new RuntimeException("El nombre del espacio es obligatorio");
        }

        if (espacio.getCapacidad() <= 0) {
            throw new RuntimeException("La capacidad debe ser mayor que cero");
        }

        espacio.setId(id);

        return espacioRepository.update(espacio);
    }

    // Eliminar un espacio
    public void eliminarEspacio(String id) {

        Espacio espacio = espacioRepository.findById(id);

        if (espacio == null) {
            throw new RuntimeException("No se encontró el espacio");
        }

        espacioRepository.deleteById(id);
    }
}

