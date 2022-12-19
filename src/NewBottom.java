import Aquivos.WriteObj;
import Models.Bottom;
import Models.Clothes;

import java.io.IOException;
import java.util.Scanner;

public class NewBottom {
    public static int total;
    static Scanner sc = new Scanner(System.in);

    public static Bottom addBottom() throws IOException {
        System.out.println("Tamanho da roupa: ");
        String size = sc.next();
        System.out.println("Gênero da roupa: ");
        String genre = sc.next();
        System.out.println("Preço da roupa: ");
        Double price = sc.nextDouble();
        System.out.println("Comprimento da roupa: ");
        String length = sc.next();
        var bottom = Bottom.builder().size(size).length(length).genre(genre).price(price).id(Clothes.getId(Main.clothesList)).build();
        WriteObj.salvarEmArquivo(bottom, Main.arquivoRoupas);
        return bottom;
    }



}
