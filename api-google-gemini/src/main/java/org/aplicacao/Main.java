package org.aplicacao;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // The client gets the API key from the environment variable `GEMINI_API_KEY`.
        Client client = Client.builder().apiKey("AIzaSyBfWe-WTEXVR36vnY9Upi0PfQIpJtCyniA").build();
        Scanner scan = new Scanner(System.in);


        System.out.println("""
            1- Pesquisar
            2- Sair
            """);
        int userOption = scan.nextInt();

        do {
            switch (userOption) {
                case 1:
                    System.out.println("Insira a sua pesquisa no Google Gemini: ");
                    String userEnter = scan.nextLine();

                    GenerateContentResponse response =
                            client.models.generateContent(
                                    "gemini-2.5-flash",
                                    userEnter,
                                    null);

                    System.out.println(response.text());
                    break;
                case 2:
                    System.out.println("Saindo...");
                    return;
            }
        } while (true);


    }
}