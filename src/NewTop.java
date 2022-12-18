import Aquivos.WriteObj;
import Models.Top;

import java.io.IOException;
import java.util.Scanner;

public class NewTop {
    public static int total;
    static Scanner sc = new Scanner(System.in);

    public static Top addTop() throws IOException {
        System.out.println("Tamanho da roupa: ");
        String size = sc.next();
        System.out.println("Gênero da roupa: ");
        String genre = sc.next();
        System.out.println("Preço da roupa: ");
        Double price = sc.nextDouble();
        System.out.println("Comprimento da manda: ");
        String sleeve = sc.next();
        var top = Top.builder().genre(genre).sleeve(sleeve).size(size).price(price).id(total++).build();
        WriteObj.salvarEmArquivo(top, Main.arquivoRoupas);
        return top;
    }
}
