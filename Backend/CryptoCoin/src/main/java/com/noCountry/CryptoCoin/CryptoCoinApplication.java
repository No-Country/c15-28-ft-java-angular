package com.noCountry.CryptoCoin;

import com.noCountry.CryptoCoin.common.Conexion;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CryptoCoinApplication {

	public static void main(String[] args) {
		SpringApplication.run(CryptoCoinApplication.class, args);
		Conexion.conectarFirebase();
	}

}
