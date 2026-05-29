package com.gavea.servico;

import com.gavea.dominio.Usuario;
import com.gavea.repositorio.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoginService {

    private final UsuarioRepository usuarioRepository;

    public LoginService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario autenticar(String email, String senha) {
        Usuario usuario = usuarioRepository.findByEmailUsuario(email);

        if (usuario == null || !usuario.getSenhaUsuario().equals(senha)) {
            throw new IllegalArgumentException("Email ou senha incorretos.");
        }

        return usuario;
    }

    @Transactional
    public Usuario cadastrar(Usuario novoUsuario) {
        Usuario existente = usuarioRepository.findByEmailUsuario(novoUsuario.getEmailUsuario());
        if (existente != null) {
            throw new IllegalArgumentException("Este email já está cadastrado.");
        }

        return usuarioRepository.save(novoUsuario);
    }
}