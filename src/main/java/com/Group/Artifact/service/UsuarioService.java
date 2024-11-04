package com.Group.Artifact.service;

import com.Group.Artifact.model.Usuario;
import com.Group.Artifact.repository.UsuarioRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepos usuarioRep;
    public Usuario getUsuById(int id) {
        return usuarioRep.findById(id).orElse(null);
    }
    public Usuario saveUsuario(Usuario usuario) {

        usuario.setPassword(encriptarSHA512((usuario.getPassword())));
        return usuarioRep.save(usuario);

    }
    private String encriptarSHA512(String password) {
        try{
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] bytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error al encriptar ",e);
        }
    }
}
