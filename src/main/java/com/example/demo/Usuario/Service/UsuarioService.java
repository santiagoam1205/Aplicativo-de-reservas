
package com.example.demo.Usuario.Service;

import com.example.demo.Usuario.Usuario;
import com.example.demo.Usuario.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Registrar un usuario
    public Usuario guardarUsuario(Usuario usuario) {

        if (usuario.getNombre() == null || usuario.getNombre().isBlank()) {
            throw new RuntimeException("El nombre es obligatorio");
        }

        if (usuario.getEmail() == null || usuario.getEmail().isBlank()) {
            throw new RuntimeException("El correo electrónico es obligatorio");
        }

        if (usuario.getEdad() <= 0) {
            throw new RuntimeException("La edad debe ser mayor que cero");
        }

        return usuarioRepository.save(usuario);
    }

    // Listar todos los usuarios
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    // Buscar usuario por ID
    public Usuario buscarUsuarioPorId(String id) {
        return usuarioRepository.findById(id);
    }

    // Buscar usuarios por nombre
    public List<Usuario> buscarUsuariosPorNombre(String nombre) {
        return usuarioRepository.findByNombreContaining(nombre);
    }

    // Actualizar un usuario
    public Usuario actualizarUsuario(String id, Usuario usuario) {

        Usuario usuarioExistente = usuarioRepository.findById(id);

        if (usuarioExistente == null) {
            throw new RuntimeException("No se encontró el usuario");
        }

        if (usuario.getNombre() == null || usuario.getNombre().isBlank()) {
            throw new RuntimeException("El nombre es obligatorio");
        }

        if (usuario.getEmail() == null || usuario.getEmail().isBlank()) {
            throw new RuntimeException("El correo electrónico es obligatorio");
        }

        if (usuario.getEdad() <= 0) {
            throw new RuntimeException("La edad debe ser mayor que cero");
        }

        usuario.setId(id);

        return usuarioRepository.update(usuario);
    }

    // Eliminar un usuario
    public void eliminarUsuario(String id) {

        Usuario usuario = usuarioRepository.findById(id);

        if (usuario == null) {
            throw new RuntimeException("No se encontró el usuario");
        }

        usuarioRepository.deleteById(id);
    }
}
