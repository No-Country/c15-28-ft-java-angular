package com.noCountry.CryptoCoin.repository;

import com.noCountry.CryptoCoin.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepositoryJPA extends JpaRepository<Usuario, Long> {
    Usuario findByEmail(String email);

}
