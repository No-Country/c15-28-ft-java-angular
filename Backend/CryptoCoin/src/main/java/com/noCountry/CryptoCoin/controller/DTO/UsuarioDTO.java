package com.noCountry.CryptoCoin.controller.DTO;

import lombok.Data;

@Data
public class UsuarioDTO {

    private String nombre;

    private String email;

    private String password;

    private Double saldo;
}
