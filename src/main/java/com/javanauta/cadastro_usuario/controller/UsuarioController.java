package com.javanauta.cadastro_usuario.controller;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.javanauta.cadastro_usuario.business.UsuarioService;
import com.javanauta.cadastro_usuario.infraestructure.entities.Usuario;

@RestController
@RequestMapping("/usuarios") 
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Void> SalvarUsuario(@RequestBody Usuario usuario){
        usuarioService.SalvarUsuario(usuario);
        return ResponseEntity.ok().build();
    }

    // NOVO MÉTODO para busca por email
@GetMapping("/email") // Mapeia para GET //email?email=x
public ResponseEntity<Usuario> BuscarUsuarioPorEmail(@RequestParam String email){ // Método em camelCase
    return ResponseEntity.ok(usuarioService.BuscarUsuarioPorEmail(email));
}

// NOVO MÉTODO para buscar todos
@GetMapping
public ResponseEntity<List<Usuario>> buscarTodos() {
    // Retorna 200 OK com uma lista (pode ser vazia)
    return ResponseEntity.ok(usuarioService.BuscarTodos());
}

    @DeleteMapping("/email")
    public ResponseEntity<Void> DeletarUsuarioPorEmail(@RequestParam String email){
        usuarioService.DeletarUsuarioPorEmail(email);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> AtualizarUsuarioPorId(@RequestParam Integer id,
                                                      @RequestBody Usuario usuario){
        usuarioService.AtualizarUsuarioPorId(id, usuario);
        return ResponseEntity.ok().build();
    }

    public UsuarioService getUsuarioService() {
        return usuarioService;
    }
}