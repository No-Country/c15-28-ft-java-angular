package com.noCountry.CryptoCoin.repository;

import com.noCountry.CryptoCoin.domain.Moneda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonedaRepositoryJPA extends JpaRepository<Moneda, Long> {
}
