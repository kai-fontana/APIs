package org.aplicacao.services;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiServices {

    DtoAddress dtoAddress = new DtoAddress();
    public DtoAddress getAddress(String cep) throws IOException, InterruptedException {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://viacep.com.br/ws/"+ cep +"/json/")).build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            ObjectMapper mapper = new ObjectMaper();
            dtoAddress = mapper.readValue(response.body(), DtoAddress.class);
        } catch (Exception e) {
        System.out.println(e.getMessage());
        }
        return dtoAddress;
    }
}
