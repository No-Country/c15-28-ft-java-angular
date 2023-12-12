package com.noCountry.CryptoCoin.controller.DTO;

import com.noCountry.CryptoCoin.domain.Moneda;
import com.noCountry.CryptoCoin.domain.TipoDeMoneda;
import lombok.Data;

@Data
public class MonedaDTO extends Moneda {

    private TipoDeMoneda tipoDeMoneda;
    private Double cantidad;
    private Double precio;
}
