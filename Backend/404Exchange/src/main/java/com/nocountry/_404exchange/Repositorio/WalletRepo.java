package com.nocountry._404exchange.Repositorio;

import com.nocountry._404exchange.Modelos.Usuario;
import com.nocountry._404exchange.Modelos.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
public interface WalletRepo extends JpaRepository<Wallet, Long> {

}