package com.Group.Artifact.controller;

import com.Group.Artifact.model.Usuario;
import com.Group.Artifact.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioServ;

    @GetMapping("/{id}")
    public Usuario getUsuarioById(@PathVariable int id) {
        return usuarioServ.getUsuById(id);
    }

    @PostMapping
    public ResponseEntity<Usuario> saveUsuario(@RequestBody Usuario usuario) {
        Usuario usuarioSave = usuarioServ.saveUsuario(usuario);
        return new ResponseEntity<>(usuarioSave, HttpStatus.CREATED);
    }
}
