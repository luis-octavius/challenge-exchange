package com;
import java.io.IOException;
import java.util.Map;

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
    private final Map<Integer, String[]> currencyPairs = Map.of(
            1, new String[] {"EUR", "USD"},
            2, new String[] {"USD", "EUR"},
            3, new String[] {"BRL", "EUR"},
            4, new String[] {"BRL", "USD"},
            5, new String[] {"USD", "BRL"},
            6, new String[] {"EUR", "BRL"}
    );
    private Request request = new Request();

    public String interactiveMenu(int option, String amount) throws IOException, InterruptedException {
        if (option == 7) return "sair";
        String[] pairs = currencyPairs.get(option);
        return request.getRequestPair(pairs[0], pairs[1], amount);
    }

    public String getMainMenu() {
        return mainMenu;
    }
}
