package org.aplicacao;

import org.aplicacao.services.ApiServices;
import org.aplicacao.services.DtoAddress;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        ApiServices apiServices = new ApiServices();
        Scanner scan = new Scanner(System.in);

        System.out.println("Bem-vindo ao sistema de consulta por CEP");
        System.out.println("Insira o CEP que deseja consultar: ");
        String userCEP = scan.nextLine();

        try {
            DtoAddress dtoAddress = apiServices.getAddress(userCEP);
            System.out.println(dtoAddress.getLogradouro() + "\n" + dtoAddress.getBairro() + "\n" + dtoAddress.getLocalidade());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
    }
}