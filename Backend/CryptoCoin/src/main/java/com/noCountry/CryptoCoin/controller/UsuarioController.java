package com.noCountry.CryptoCoin.controller;

import com.noCountry.CryptoCoin.domain.Usuario;
import com.noCountry.CryptoCoin.service.UsuarioService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.ExecutionException;

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
    public void guardarUsuario(String nombre, String email) throws ExecutionException, InterruptedException {
        usuarioService.guardarUsuario(nombre, email);
    }

}
