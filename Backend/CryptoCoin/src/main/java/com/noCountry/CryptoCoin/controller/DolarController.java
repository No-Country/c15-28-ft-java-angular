package com.noCountry.CryptoCoin.controller;

import com.noCountry.CryptoCoin.controller.DTO.DolarDTO;
import com.noCountry.CryptoCoin.service.DolarService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@RestController
@RequestMapping("/dolar")
@AllArgsConstructor
public class DolarController {

    private final DolarService dolarService;
    @GetMapping("/blue")
    public DolarDTO getDolarBlue(){
        return dolarService.getDolarBlue();
    }
}
