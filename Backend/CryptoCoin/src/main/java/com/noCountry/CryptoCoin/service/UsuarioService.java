package com.noCountry.CryptoCoin.service;

import com.noCountry.CryptoCoin.domain.Usuario;
import com.noCountry.CryptoCoin.repository.UsuarioRepositoryJPA;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class UsuarioService {

    private final UsuarioRepositoryJPA usuarioRepositoryJPA;

    public void guardarUsuario(Usuario usuario) {
        if (usuario.getNombre() == null || usuario.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacio");
        } else {
            usuarioRepositoryJPA.save(usuario);
        }
    }

    public List<Usuario> getAll() {
        return usuarioRepositoryJPA.findAll();
    }
}
