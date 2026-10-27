
package com.example.demo.Reserva.Service;

import com.example.demo.Reserva.Reserva;
import com.example.demo.Reserva.ReservaRepository;
import com.example.demo.Usuario.Usuario;
import com.example.demo.Espacio.Espacio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    // Registrar una reserva
    public Reserva guardarReserva(Reserva reserva) {

        validarReserva(reserva);

        if (reservaRepository.existeConflicto(reserva)) {
            throw new RuntimeException(
                    "El espacio ya tiene una reserva en ese horario"
            );
        }

        return reservaRepository.save(reserva);
    }

    // Listar todas las reservas
    public List<Reserva> listarReservas() {
        return reservaRepository.findAll();
    }

    // Buscar reserva por ID
    public Reserva buscarReservaPorId(String id) {
        return reservaRepository.findById(id);
    }

    // Buscar reservas de un usuario
    public List<Reserva> buscarReservasPorUsuario(String usuarioId) {
        return reservaRepository.findByUsuarioId(usuarioId);
    }

    // Buscar reservas de un espacio
    public List<Reserva> buscarReservasPorEspacio(String espacioId) {
        return reservaRepository.findByEspacioId(espacioId);
    }

    // Actualizar una reserva
    public Reserva actualizarReserva(String id, Reserva reserva) {

        Reserva reservaExistente = reservaRepository.findById(id);

        if (reservaExistente == null) {
            throw new RuntimeException("No se encontró la reserva");
        }

        reserva.setId(id);

        validarReserva(reserva);

        if (reservaRepository.existeConflicto(reserva)) {
            throw new RuntimeException(
                    "El espacio ya tiene una reserva en ese horario"
            );
        }

        return reservaRepository.update(reserva);
    }

    // Cancelar una reserva
    public Reserva cancelarReserva(String id) {

        Reserva reserva = reservaRepository.findById(id);

        if (reserva == null) {
            throw new RuntimeException("No se encontró la reserva");
        }

        reserva.setEstado("CANCELADA");

        return reservaRepository.update(reserva);
    }

    // Eliminar una reserva
    public void eliminarReserva(String id) {

        Reserva reserva = reservaRepository.findById(id);

        if (reserva == null) {
            throw new RuntimeException("No se encontró la reserva");
        }

        reservaRepository.deleteById(id);
    }

    // Validar los datos de una reserva
    private void validarReserva(Reserva reserva) {

        if (reserva == null) {
            throw new RuntimeException("La reserva no puede estar vacía");
        }

        Usuario usuario = reserva.getUsuario();
        Espacio espacio = reserva.getEspacio();

        if (usuario == null || usuario.getId() == null) {
            throw new RuntimeException("Debe seleccionar un usuario");
        }

        if (espacio == null || espacio.getId() == null) {
            throw new RuntimeException("Debe seleccionar un espacio");
        }

        if (reserva.getFecha() == null) {
            throw new RuntimeException("La fecha es obligatoria");
        }

        if (reserva.getHoraInicio() == null ||
                reserva.getHoraFin() == null) {
            throw new RuntimeException("Las horas son obligatorias");
        }

        if (!reserva.getHoraInicio().isBefore(reserva.getHoraFin())) {
            throw new RuntimeException(
                    "La hora de inicio debe ser anterior a la hora de finalización"
            );
        }

        if (reserva.getEstado() == null ||
                reserva.getEstado().isBlank()) {
            reserva.setEstado("PENDIENTE");
        }
    }
}
