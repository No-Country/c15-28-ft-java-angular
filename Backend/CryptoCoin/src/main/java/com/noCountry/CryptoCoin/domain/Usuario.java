package com.noCountry.CryptoCoin.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuario")
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre", nullable = false, length = 15)
    private String nombre;
    @Column(name = "email", unique = true, nullable = false)
    private String email;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "saldo", nullable = false)
    private Double saldo;
}
