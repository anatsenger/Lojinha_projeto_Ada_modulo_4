package Aquivos;

import Models.Clothes;
import Models.Person;
import Models.Seller;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WriteObj {
    public static  void salvarEmArquivo(Object obj, File arquivo) throws IOException {
        try (var out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(arquivo)))) {
            out.writeObject(obj);
            out.flush();
        }
    }

    private static void writeListObject(File arquivo, List objects) throws IOException {
        OutputStream os = null;
        try {
            os = new FileOutputStream(arquivo);
            ObjectOutputStream oos = new ObjectOutputStream(os);
            for (Object object : objects) {
                oos.writeObject(object);
            }
            oos.flush();
        } finally {
            if (os != null) {
                os.close();
            }
        }
    }


    public static <T> List lerArquivo(File arquivo) throws IOException, ClassNotFoundException {
        var list = new ArrayList<T>();
        try (var in = new FileInputStream(arquivo)) {
            while (true) {
                ObjectInputStream os = new ObjectInputStream(in);
                var objeto = os.readObject();
                list.add((T) objeto);
            }
        } catch (EOFException e) {
            System.out.printf("");
        }
        return list;
    }

    public static void deleteClothe(File arquivo, int id) throws IOException, ClassNotFoundException {
        List<Clothes> list;
        list = lerArquivo(arquivo);
        var newList= list.stream().filter(clothe -> clothe.getId() != id).toList();
        arquivo.delete();
        File arquivo2 = new File("Estoque.txt");
        writeListObject(arquivo2, newList);
        System.out.println("Roupa Vendida");
    }
}


//        try (var in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(arquivo)))) {
//            while (true) {
//                var objeto = in.readObject();
//                if (objeto instanceof Clothes c) clothes.add(c);
//            }
//        } catch (EOFException e) {
//            System.out.println("error:" + e.getMessage());
//        }
//        return clothes;


