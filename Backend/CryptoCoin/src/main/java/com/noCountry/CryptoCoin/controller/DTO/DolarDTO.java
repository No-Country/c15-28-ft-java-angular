package com.noCountry.CryptoCoin.controller.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DolarDTO {

    private Double compra;
    private Double venta;
    private Date fechaActualizacion;

}
