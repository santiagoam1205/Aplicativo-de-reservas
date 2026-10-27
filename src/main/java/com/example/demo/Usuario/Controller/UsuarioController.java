
package com.example.demo.Usuario.Controller;

import com.example.demo.Usuario.Usuario;
import com.example.demo.Usuario.Service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // Registrar un usuario
    @PostMapping
    public Usuario guardarUsuario(@RequestBody Usuario usuario) {
        return usuarioService.guardarUsuario(usuario);
    }

    // Listar todos los usuarios
    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }

    // Buscar usuario por ID
    @GetMapping("/{id}")
    public Usuario buscarUsuarioPorId(@PathVariable String id) {
        return usuarioService.buscarUsuarioPorId(id);
    }

    // Buscar usuarios por nombre
    @GetMapping("/buscar")
    public List<Usuario> buscarPorNombre(
            @RequestParam String nombre) {
        return usuarioService.buscarUsuariosPorNombre(nombre);
    }

    // Actualizar un usuario
    @PutMapping("/{id}")
    public Usuario actualizarUsuario(
            @PathVariable String id,
            @RequestBody Usuario usuario) {
        return usuarioService.actualizarUsuario(id, usuario);
    }

    // Eliminar un usuario
    @DeleteMapping("/{id}")
    public String eliminarUsuario(@PathVariable String id) {
        usuarioService.eliminarUsuario(id);
        return "Usuario eliminado correctamente";
    }
}
