package com.noCountry.CryptoCoin.controller;

import com.noCountry.CryptoCoin.controller.DTO.UsuarioDTO;
import com.noCountry.CryptoCoin.domain.Usuario;
import com.noCountry.CryptoCoin.service.UsuarioService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static com.noCountry.CryptoCoin.service.UsuarioService.encriptarContrasenia;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/usuario")
@AllArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping("/buscarTodos")
    public List<Usuario> getUsuarios() {

        return usuarioService.getAll();
    }

    @PostMapping("/guardarUsuario")
    public ResponseEntity guardarUsuario(@RequestBody UsuarioDTO dto) throws NoSuchAlgorithmException {
        return ResponseEntity.ok(usuarioService.guardarUsuario(dto));
    }


    @PostMapping("/login")
    public ResponseEntity login(@RequestParam("email") String email, @RequestParam("password") String password) throws NoSuchAlgorithmException {
        Usuario usuarioBuscado = usuarioService.buscarUsuario(email);
        if (usuarioBuscado != null && usuarioBuscado.getPassword().equals(encriptarContrasenia(password))) {
            return ResponseEntity.ok(usuarioBuscado);
        } else {
            return ResponseEntity.badRequest().body("Usuario o contraseña incorrectos");
        }
    }
}
