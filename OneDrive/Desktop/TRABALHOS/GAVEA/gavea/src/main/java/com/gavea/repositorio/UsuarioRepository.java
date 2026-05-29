package com.gavea.repositorio;

import com.gavea.dominio.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {


    Usuario findByEmailUsuario(String email);
}