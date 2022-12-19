import Aquivos.WriteObj;
import Models.*;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class NewClient {
    static Scanner sc = new Scanner(System.in);

    public static Client addClient() throws IOException {
        System.out.println("Nome do novo cliente: ");
        String name = sc.nextLine().toLowerCase();
        String CPF = Person.validaCPF("Cliente");
        var client =Client.builder().name(name.toLowerCase()).CPF(CPF).id(Client.getId(Main.clientsList)).build();
        WriteObj.salvarEmArquivo(client, Main.arquivoClient);
        return client;
    }

    public Double calculateBill(List<Sale> sales, Client client){
        return sales.stream().filter(sale -> sale.getClient().equals(client))
                .reduce(0d, (price, sale)-> price + sale.getClothes().getPrice(), Double::sum);
    }
}
