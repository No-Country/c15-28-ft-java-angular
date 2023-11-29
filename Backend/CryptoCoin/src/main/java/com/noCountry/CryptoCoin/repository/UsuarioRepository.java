package com.noCountry.CryptoCoin.repository;

import com.noCountry.CryptoCoin.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
