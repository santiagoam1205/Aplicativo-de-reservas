
package com.example.demo.Reserva;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class ReservaRepository {

    // Simulamos una base de datos con un Map
    private final Map<String, Reserva> baseDeDatos = new HashMap<>();

    // Guardar una reserva
    public Reserva save(Reserva reserva) {
        baseDeDatos.put(reserva.getId(), reserva);
        return reserva;
    }

    // Buscar una reserva por ID
    public Reserva findById(String id) {
        return baseDeDatos.get(id);
    }

    // Listar todas las reservas
    public List<Reserva> findAll() {
        return new ArrayList<>(baseDeDatos.values());
    }

    // Buscar reservas de un usuario
    public List<Reserva> findByUsuarioId(String usuarioId) {
        List<Reserva> resultados = new ArrayList<>();

        for (Reserva reserva : baseDeDatos.values()) {

            if (reserva.getUsuario() != null
                    && reserva.getUsuario().getId().equals(usuarioId)) {

                resultados.add(reserva);
            }
        }

        return resultados;
    }

    // Buscar reservas de un espacio
    public List<Reserva> findByEspacioId(String espacioId) {
        List<Reserva> resultados = new ArrayList<>();

        for (Reserva reserva : baseDeDatos.values()) {

            if (reserva.getEspacio() != null
                    && reserva.getEspacio().getId().equals(espacioId)) {

                resultados.add(reserva);
            }
        }

        return resultados;
    }

    // Verificar si existe una reserva en el mismo espacio,
    // fecha y horario que se superponga con otra reserva
    public boolean existeConflicto(Reserva nuevaReserva) {

        for (Reserva reservaExistente : baseDeDatos.values()) {

            // Ignorar la misma reserva cuando se está actualizando
            if (reservaExistente.getId().equals(nuevaReserva.getId())) {
                continue;
            }

            // Ignorar reservas canceladas
            if ("CANCELADA".equals(reservaExistente.getEstado())) {
                continue;
            }

            // Verificar que ambas reservas tengan espacio y fecha
            if (reservaExistente.getEspacio() == null
                    || nuevaReserva.getEspacio() == null
                    || reservaExistente.getFecha() == null
                    || nuevaReserva.getFecha() == null) {
                continue;
            }

            // Comparar espacio y fecha
            boolean mismoEspacio =
                    reservaExistente.getEspacio().getId()
                            .equals(nuevaReserva.getEspacio().getId());

            boolean mismaFecha =
                    reservaExistente.getFecha()
                            .equals(nuevaReserva.getFecha());

            // Comparar horarios
            boolean horariosSeSuperponen =
                    nuevaReserva.getHoraInicio()
                            .isBefore(reservaExistente.getHoraFin())
                            && nuevaReserva.getHoraFin()
                            .isAfter(reservaExistente.getHoraInicio());

            if (mismoEspacio && mismaFecha && horariosSeSuperponen) {
                return true;
            }
        }

        return false;
    }

    // Eliminar una reserva
    public void deleteById(String id) {
        baseDeDatos.remove(id);
    }

    // Actualizar una reserva
    public Reserva update(Reserva reserva) {

        if (baseDeDatos.containsKey(reserva.getId())) {
            baseDeDatos.put(reserva.getId(), reserva);
            return reserva;
        }

        return null;
    }
}

