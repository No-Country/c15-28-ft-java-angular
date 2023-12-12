package com.noCountry.CryptoCoin.controller;

import com.noCountry.CryptoCoin.controller.DTO.UsuarioDTO;
import com.noCountry.CryptoCoin.domain.Usuario;
import com.noCountry.CryptoCoin.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("/id")
    public Optional<Usuario> getUsuarios(@RequestParam Long id) {
        return usuarioService.buscarPorId(id);
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
