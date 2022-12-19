package Models;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.Scanner;

@SuperBuilder
@Getter
@Setter
public class Person implements Serializable {

    static Scanner sc = new Scanner(System.in);
    private String name;
    private String CPF;
    private static int total;
    private int id;

    public Person(String name, String CPF) {
        this.name = name;
        this.CPF = CPF;
        total++;
        this.id = total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public static int getTotal() {
        return total;
    }

    public static void setTotal(int total) {
        Person.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static String validaCPF(String tipo){
        //111.111.111-11;
        System.out.println("CPF do novo " + tipo + ":");
        String CPF = sc.nextLine();
        var cpfSplit = CPF.split("");
        System.out.println(cpfSplit[3] + cpfSplit[7] + cpfSplit[11]);
        if(cpfSplit.length == 14 || cpfSplit[3].equals(".") || cpfSplit[7].equals(".") || cpfSplit[11].equals("-")){
            System.out.println("Cpf válido");
            return CPF;
        } else {
            System.out.println("cpf inválido");
            validaCPF(tipo);
        }
        return null;
    }


    @Override
    public String toString() {
        return "Nome: " + name +
                ", CPF: " + CPF +
                ", id: " + id + "}";
    }
}
