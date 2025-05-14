import com.Exchange;
import com.Request;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.Menu;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import io.github.cdimascio.dotenv.Dotenv;

public class Main {
public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);

        //Verifying API
        String apiKey = Dotenv.load().get("EXCHANGE_API_KEY");
        System.out.println("API KEY: " + (apiKey != null ? "***" : "Não encontrada"));

        //Deserialization
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        Menu menu = new Menu();
        int option = 0;
        do {
                System.out.println(menu.getMainMenu());

                try {
                        option = sc.nextInt();
                } catch (InputMismatchException e) {
                        System.out.println("Por favor, use somente um número de 1 a 7");
                }

                if (option == 7) {
                        break;
                }

                System.out.println("Digite a quantia que deseja converter: ");
                while (!sc.hasNextInt()) {
                        System.out.println("Por favor, digite um número válido (1 a 7).");
                        sc.next();
                }
                int amount = sc.nextInt();
                try {
                        String result = menu.interactiveMenu(option, String.valueOf(amount));
                        Exchange requestExchange;
                    requestExchange = gson.fromJson(result, Exchange.class);
                    System.out.println("A conversão do valor " + amount + " " + requestExchange.base_code() + " para " + requestExchange.target_code() + " é igual a: " + requestExchange.conversion_result() + "\n\n");
                } catch (IOException e) {
                        System.out.println("Erro de conexão com a API, verifique a internet.");
                } catch (InterruptedException e) {
                        System.out.println("Operação interrompida de modo inesperado.");
                } catch (Exception e) {
                        System.out.println("Erro inesperado: " + e.getMessage());
                }
        } while(option != 7);
        System.out.println("Fim do programa.");
        sc.close();
 }
}
