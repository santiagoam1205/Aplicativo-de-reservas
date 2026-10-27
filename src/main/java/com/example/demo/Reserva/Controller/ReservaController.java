
package com.example.demo.Reserva.Controller;

import com.example.demo.Reserva.Reserva;
import com.example.demo.Reserva.Service.ReservaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservas")
@CrossOrigin(origins = "*")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    // Registrar una reserva
    @PostMapping
    public Reserva guardarReserva(@RequestBody Reserva reserva) {
        return reservaService.guardarReserva(reserva);
    }

    // Listar todas las reservas
    @GetMapping
    public List<Reserva> listarReservas() {
        return reservaService.listarReservas();
    }

    // Buscar reserva por ID
    @GetMapping("/{id}")
    public Reserva buscarReservaPorId(@PathVariable String id) {
        return reservaService.buscarReservaPorId(id);
    }

    // Buscar reservas de un usuario
    @GetMapping("/usuario/{usuarioId}")
    public List<Reserva> buscarPorUsuario(
            @PathVariable String usuarioId) {
        return reservaService.buscarReservasPorUsuario(usuarioId);
    }

    // Buscar reservas de un espacio
    @GetMapping("/espacio/{espacioId}")
    public List<Reserva> buscarPorEspacio(
            @PathVariable String espacioId) {
        return reservaService.buscarReservasPorEspacio(espacioId);
    }

    // Actualizar una reserva
    @PutMapping("/{id}")
    public Reserva actualizarReserva(
            @PathVariable String id,
            @RequestBody Reserva reserva) {
        return reservaService.actualizarReserva(id, reserva);
    }

    // Cancelar una reserva
    @PutMapping("/{id}/cancelar")
    public Reserva cancelarReserva(@PathVariable String id) {
        return reservaService.cancelarReserva(id);
    }

    // Eliminar una reserva
    @DeleteMapping("/{id}")
    public String eliminarReserva(@PathVariable String id) {
        reservaService.eliminarReserva(id);
        return "Reserva eliminada correctamente";
    }
}

