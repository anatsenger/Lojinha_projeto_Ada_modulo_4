import Aquivos.WriteObj;
import Models.*;

import java.io.*;
import java.lang.Thread;
import java.io.File;

import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static List<Seller> sellersList = new ArrayList<>();
    public static List<Sale> saleList = new ArrayList<>();
    public static List<Clothes> clothesList = new ArrayList<>();
    public static List<Client> clientsList = new ArrayList<>();
    //private static String caminhoArquivoRoupas = "C:\\Users\\Senger\\oo1 - deva\\Lojinha\\src\\Aquivos\\";
    static boolean continuar;
    static File arquivoRoupas = new File("Estoque.txt");
    static File arquivoSeller = new File("Vendedores.txt");
    static File arquivoClient = new File("Clientes.txt");
    static File arquivoSale = new File("Sale.txt");

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        clothesList = WriteObj.lerArquivo(arquivoRoupas);
        sellersList = WriteObj.lerArquivo(arquivoSeller);
        clientsList = WriteObj.lerArquivo(arquivoClient);
        saleList = WriteObj.lerArquivo(arquivoSale);
        init();
        continuar = true;
        do{
            menu();
        } while (continuar);
        end();
    }

    public static void doSale() throws IOException, ClassNotFoundException {
        showClothes();
        System.out.println("Id da roupa vendida: ");
        var id = sc.nextInt();
        var clotheSale = clothesList.stream().filter(clothes -> clothes.getId() == id).findFirst().get();
        System.out.println("Nome do vendedor: ");
        var sellerSale = sellersList.stream().filter(seller -> seller.getName().equals(sc.next().toLowerCase())).findFirst().get();
        System.out.println("Nome do Cliente: ");
        var clientSale = clientsList.stream().filter(client -> client.getName().equals(sc.next().toLowerCase())).findFirst().get();
        makeSale(sellerSale, clotheSale, clientSale);
        WriteObj.deleteClothe(arquivoRoupas, id);
    }

    public static void showClothes(){
        System.out.println(clothesList.toString());
    }

    public static void makeSale(Seller seller, Clothes clothes, Client client) throws IOException {
        clothesList.remove(clothes);
        var sale= Sale.builder().clothes(clothes).client(client).seller(seller).dateSale(LocalDate.now()).build();
        saleList.add(sale);
        WriteObj.salvarEmArquivo(sale, arquivoSale);
    }

    public static void registerClothes() throws IOException {
        System.out.println("---------Cadastro de novas Roupas----------");
        System.out.println("Digite 1 p/ cadastrar um blusa ou camisa;\n" +
                "Digite 2 p/ cadastrar uma calça ou um shorts.");
        if (sc.nextInt()==1){
            clothesList.add(NewTop.addTop());
        } else if (sc.nextInt()==2) {
            clothesList.add(NewBottom.addBottom());
        } else {
            System.out.println("opção inválida, tente novamente!");
            registerClothes();
        }
    }

    public static void menu() throws IOException, ClassNotFoundException {
        System.out.println("------------------------Menu de opções--------------------------");
        System.out.println("1 - Registrar nova Venda;");
        System.out.println("2 - Registrar novo Cliente;");
        System.out.println("3 - Registrar novo Vendedor;");
        System.out.println("4 - Registrar novas Roupas;");
        System.out.println("6 - Finalizar sistema;");
        System.out.println("7 - Listar vendedores, clientes e roupas");
        System.out.println("Que operação deseja realizar?");
        switch (sc.nextInt()){
            case 1: doSale(); break;
            case 2: clientsList.add(NewClient.addClient()); break;
            case 3: sellersList.add(NewSeller.addSeller()); break;
            case 4: registerClothes(); break;
            case 6: continuar = false; break;
            case 7: listAll(); break;
            default: System.out.println("Opção inválida, tente novamente!");
                menu();
        }
    }

    public static void init(){
        System.out.println("----------------------------------------------------------------");
        System.out.println("----------------------Lojinha das Marias------------------------");
    }

    public static void listAll(){
        System.out.println(sellersList);
        System.out.println(clientsList);
        System.out.println(clothesList);
    }

    public static void end() throws InterruptedException{
        System.out.println("-------------------Finalizando o sistema------------------------");
        String comeco = "                            ";
        String[] carregando2 = comeco.split("");
        for (int i = 0; i < carregando2.length; i++) {
            Thread.sleep(100);
            carregando2[i] = carregando2[i].replace(" ", "=");
            System.out.printf("\r" + Arrays.toString(carregando2).replace(", ", ""));
        }
        System.out.println("");
        System.out.println("--------------------Sistema finalizado-------------------------");
    }


}