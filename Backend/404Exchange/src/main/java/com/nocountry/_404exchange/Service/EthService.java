package com.nocountry._404exchange.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
@AllArgsConstructor
public class EthService {

    public StringBuffer getEth() throws IOException {
        URL binanceUrl = new URL("https://api.binance.com/api/v3/ticker/price?symbol=ETHUSDT");
        HttpURLConnection connection = (HttpURLConnection) binanceUrl.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();

        // Abrir un BufferedReader que lea el flujo de datos
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(binanceUrl.openStream()));

        // Leer línea por línea y construir un StringBuffer
        StringBuffer informationString = new StringBuffer();
        String inputLine;
        while ((inputLine = bufferedReader.readLine()) != null) {
            informationString.append(inputLine);
        }
        bufferedReader.close();

        connection.disconnect();

        return informationString;
    }
}
