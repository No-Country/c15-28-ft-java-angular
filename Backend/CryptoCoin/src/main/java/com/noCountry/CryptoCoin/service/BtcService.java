package com.noCountry.CryptoCoin.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@Service
@AllArgsConstructor
public class BtcService {
    private final String API_KEY = "E4DB478D-BA01-403A-973A-7CF46EDA6812";
    public StringBuffer getBtc() throws IOException {
        URL url = new URL("https://rest.coinapi.io/v1/exchangerate/BTC/USD");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestProperty("X-CoinAPI-Key", API_KEY);

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }

        in.close();
        conn.disconnect();

        return content;
    }
}
