package com;
import java.io.IOException;

public class Menu {
    private String mainMenu = """
            ********************************************************
            Bem-vindo ao conversor de moedas!
            Por favor, escolha uma das opções abaixo para começar!
            ********************************************************
            1 - Euro >>> Dólar
            2 - Dólar >>> Euro
            3 - Real >>> Euro
            4 - Real >>> Dólar
            5 - Dólar >>> Real
            6 - Euro >>> Real
            7 - Sair
            *******************************************************
            """;
    private Request request = new Request();

    public String interactiveMenu(int option, String amount) throws IOException, InterruptedException {
        String response = "";
        switch(option) {
            case 1:
                response = request.getRequestPair("EUR", "USD", amount);
                break;
            case 2:
                response = request.getRequestPair("USD", "EUR", amount);
                break;
            case 3:
                response = request.getRequestPair("BRL", "EUR", amount);
                break;
            case 4:
                response = request.getRequestPair("BRL", "USD", amount);
                break;
            case 5:
                response = request.getRequestPair("USD", "BRL", amount);
            case 6:
                response = request.getRequestPair("EUR", "BRL", amount);
                break;
            case 7:
                return "sair";
        }
        return response;
    }
    public String getMainMenu() {
        return mainMenu;
    }
}
