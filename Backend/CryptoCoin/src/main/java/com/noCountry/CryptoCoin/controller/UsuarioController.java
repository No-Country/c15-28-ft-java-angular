package com.noCountry.CryptoCoin.controller;

import com.noCountry.CryptoCoin.domain.Usuario;
import com.noCountry.CryptoCoin.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/usuario")
@AllArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping("/{buscarTodos}")
    public List<Usuario> getUsuarios() {
        return usuarioService.getAll();
    }
}
