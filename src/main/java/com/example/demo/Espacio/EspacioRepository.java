
package com.example.demo.Espacio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class EspacioRepository {

    // Simulamos una base de datos con un Map
    private final Map<String, Espacio> baseDeDatos = new HashMap<>();

    // Guardar un espacio
    public Espacio save(Espacio espacio) {
        baseDeDatos.put(espacio.getId(), espacio);
        return espacio;
    }

    // Buscar un espacio por ID
    public Espacio findById(String id) {
        return baseDeDatos.get(id);
    }

    // Listar todos los espacios
    public List<Espacio> findAll() {
        return new ArrayList<>(baseDeDatos.values());
    }

    // Buscar espacios por nombre
    public List<Espacio> findByNombreContaining(String nombre) {
        List<Espacio> resultados = new ArrayList<>();

        for (Espacio espacio : baseDeDatos.values()) {

            if (espacio.getNombre() != null
                    && espacio.getNombre().toLowerCase()
                    .contains(nombre.toLowerCase())) {

                resultados.add(espacio);
            }
        }

        return resultados;
    }

    // Listar espacios disponibles
    public List<Espacio> findByDisponible(boolean disponible) {
        List<Espacio> resultados = new ArrayList<>();

        for (Espacio espacio : baseDeDatos.values()) {

            if (espacio.isDisponible() == disponible) {
                resultados.add(espacio);
            }
        }

        return resultados;
    }

    // Eliminar un espacio
    public void deleteById(String id) {
        baseDeDatos.remove(id);
    }

    // Actualizar un espacio
    public Espacio update(Espacio espacio) {

        if (baseDeDatos.containsKey(espacio.getId())) {
            baseDeDatos.put(espacio.getId(), espacio);
            return espacio;
        }

        return null;
    }
}
