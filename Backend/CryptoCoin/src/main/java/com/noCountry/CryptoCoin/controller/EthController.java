package com.noCountry.CryptoCoin.controller;

import com.noCountry.CryptoCoin.service.EthService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
@RestController
@RequestMapping("/eth")
@AllArgsConstructor
public class EthController{

        private final EthService ethService;
        @GetMapping()
        public StringBuffer getEth() throws IOException {
            return ethService.getEth();
        }
}
