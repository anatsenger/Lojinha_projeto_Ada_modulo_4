import Aquivos.WriteObj;
import Models.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class NewSeller {
    static Scanner sc = new Scanner(System.in);
    public static int total;

    public static Seller addSeller() throws IOException {
        System.out.println("Nome do novo vendedor: ");
        String name = sc.next().toLowerCase();
        System.out.println("CPF do novo vendedor: ");
        String CPF = sc.next();
        var seller = Seller.builder().name(name.toLowerCase()).CPF(CPF).id(total++).build();
        WriteObj.salvarEmArquivo(seller, Main.arquivoSeller);
        return seller;
    }


//    public static void deletarSeller(File arquivo, List seller) throws IOException, ClassNotFoundException {
//        System.out.println(seller.toString());
//        System.out.println("Id do vendedor que deseja excluir: ");
//        int id = sc.nextInt();
//        WriteObj.deleteSeller(arquivo, id);
//    }

}
