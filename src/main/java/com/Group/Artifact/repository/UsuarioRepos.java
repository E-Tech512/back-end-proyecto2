package com.Group.Artifact.repository;

import com.Group.Artifact.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepos extends JpaRepository<Usuario, Integer> {

}
