package com.nocountry._404exchange.Controlador;

import com.nocountry._404exchange.Service.BtcService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;

/**
 * hacer pruebas con postman GET http://localhost:8080/BTC
 * Obtiene el precio del BTC/USDT actual
 */
@RestController
@RequestMapping(value = "/BTC")
@AllArgsConstructor
public class BtcController {

    //@Autowired
    private final BtcService btcService;

    @GetMapping()
    public StringBuffer getBtc() throws IOException {
        return btcService.getBtc();
    }

}
