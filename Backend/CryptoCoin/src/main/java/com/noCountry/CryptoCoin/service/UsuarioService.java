package com.noCountry.CryptoCoin.service;

import com.noCountry.CryptoCoin.domain.Usuario;
import com.noCountry.CryptoCoin.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public List<Usuario> getAll() {
        return usuarioRepository.findAll();
    }
}
