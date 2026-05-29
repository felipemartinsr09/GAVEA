package com.gavea.controlador;

import com.gavea.servico.LoginService;
import com.gavea.dominio.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public ResponseEntity<Usuario> login(@RequestBody Map<String, String> credenciais) {
        String email = credenciais.get("email");
        String senha = credenciais.get("senha");

        try {
            Usuario usuarioAutenticado = loginService.autenticar(email, senha);
            return ResponseEntity.ok(usuarioAutenticado);

        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(401).build();
        }
    }

    @PostMapping("/cadastro")
    public ResponseEntity<Usuario> cadastrar(@RequestBody Usuario novoUsuario) {
        try {
            Usuario usuarioSalvo = loginService.cadastrar(novoUsuario);
            return ResponseEntity.ok(usuarioSalvo);

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}