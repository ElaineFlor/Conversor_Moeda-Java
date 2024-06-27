import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URI;
import java.net.URL;
import java.net.HttpURLConnection;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;


public class ConversorDeMoedas {
    public static Moeda checarAPI(String currencyBaseCode,
                                  String convertedCurrencyCode, Scanner scan){
        String chaveAPI = "6c4576c7bab5cbea81f5323d";
        String urlSite = "https://v6.exchangerate-api.com/v6/" + chaveAPI + "/latest/" + currencyBaseCode;


        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest requerer = HttpRequest.newBuilder()
                    .uri(URI.create(urlSite))
                    .build();

            HttpResponse<String> response = client
                    .send(requerer, HttpResponse.BodyHandlers.ofString());

            URL url = new URL(urlSite);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();

            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
            JsonObject jsonobj = root.getAsJsonObject();

            JsonObject conversionRates = jsonobj.getAsJsonObject("conversion_rates");

            if ( !conversionRates.has(convertedCurrencyCode)) {
                System.out.println("Moeda Inválida.");
                return null;
            }

            System.out.println("Quanto de " + currencyBaseCode + " você deseja converter para " + convertedCurrencyCode + "? ");

            double valorConverter = scan.nextDouble();
            double valorConvertido = valorConverter * conversionRates.get(convertedCurrencyCode).getAsDouble();

            return new Moeda (currencyBaseCode, convertedCurrencyCode, valorConverter, valorConvertido);

        } catch (Exception e) {
            throw new RuntimeException("Ocorreu um erro! Não consegui conectar com o servidor.");
        }


    }

}
