package com.nocountry._404exchange.Modelos;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;

    @Entity
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @FieldDefaults(level = AccessLevel.PRIVATE) //Hace que todas las variables sean privadas
    @Table(name = "wallet")
    public class Wallet {
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        long id;

        @Column(name= "monto_dolares", nullable = false)
        @Positive
        BigDecimal montoDolares = BigDecimal.ZERO;

        @Positive
        @Column(name = "cantidad_btc", nullable = false)
        BigDecimal cantidadBTC = BigDecimal.ZERO;

        @Positive
        @Column(name = "cantidad_eth", nullable = false)
        BigDecimal cantidadETH = BigDecimal.ZERO;

        @Column(name = "fecha_hora_compra_venta")
        LocalDateTime fechaHoraCompraVenta;

        @Column(name = "historial_compra_venta")
        String historialCompraVenta;

    }