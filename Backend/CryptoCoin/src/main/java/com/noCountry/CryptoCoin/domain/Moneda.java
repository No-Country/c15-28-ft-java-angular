package com.noCountry.CryptoCoin.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "moneda")
@Data
public class Moneda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private TipoDeMoneda tipoDeMoneda;
    private Double cantidad;
    private Double precio;
    private String fecha;
}
