import Aquivos.WriteObj;
import Models.Client;
import Models.Clothes;
import Models.Sale;
import Models.Seller;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class NewClient {
    public static int total;
    static Scanner sc = new Scanner(System.in);

    public static Client addClient() throws IOException {
        System.out.println("Nome do novo cliente: ");
        String name = sc.nextLine().toLowerCase();
        System.out.println("CPF do novo cliente: ");
        String CPF = sc.nextLine();
        var client =Client.builder().name(name.toLowerCase()).CPF(CPF).id(total++).build();
        WriteObj.salvarEmArquivo(client, Main.arquivoClient);
        return client;
    }

    public Double calculateBill(List<Sale> sales, Client client){
        return sales.stream().filter(sale -> sale.getClient().equals(client))
                .reduce(0d, (price, sale)-> price + sale.getClothes().getPrice(), Double::sum);
    }
}
