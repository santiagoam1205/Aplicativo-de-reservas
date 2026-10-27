
package com.example.demo.Reserva;

import com.example.demo.Usuario.Usuario;
import com.example.demo.Espacio.Espacio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public class Reserva {

    private String id;
    private Usuario usuario;
    private Espacio espacio;
    private LocalDate fecha;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private String estado;

    public Reserva() {
        this.id = UUID.randomUUID().toString();
    }

    public Reserva(Usuario usuario, Espacio espacio,
                   LocalDate fecha, LocalTime horaInicio,
                   LocalTime horaFin) {

        this.id = UUID.randomUUID().toString();
        this.usuario = usuario;
        this.espacio = espacio;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.estado = "PENDIENTE";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Espacio getEspacio() {
        return espacio;
    }

    public void setEspacio(Espacio espacio) {
        this.espacio = espacio;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}

