package com.noCountry.CryptoCoin.service;

import com.noCountry.CryptoCoin.controller.DTO.DolarDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class DolarService {
    public DolarDTO getDolarBlue() {
        String url = "https://dolarapi.com/v1/dolares/blue";
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, DolarDTO.class);
    }
}
