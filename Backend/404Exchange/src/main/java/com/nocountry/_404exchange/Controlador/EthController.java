package com.nocountry._404exchange.Controlador;

import com.nocountry._404exchange.Service.EthService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
/**
 * hacer pruebas con postman GET http://localhost:8080/ETH
 * Obtiene el precio del ETH/USDT actual
 */
@RestController
@RequestMapping(value = "/ETH")
@AllArgsConstructor
public class EthController {

    //@Autowired
    private final EthService ethService;

    @GetMapping()
    public StringBuffer getEth() throws IOException {
        return ethService.getEth();
    }

}