package com.noCountry.CryptoCoin.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Moneda")
@Data
public class Moneda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "moneda", nullable = false)
    private TipoDeMoneda moneda;
    @Column(name = "cantidad", nullable = false)
    private String cantidad;
    @Column(name = "precio", nullable = false)
    private Double precio;

}
