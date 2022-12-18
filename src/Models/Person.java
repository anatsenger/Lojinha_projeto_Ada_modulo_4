package Models;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@SuperBuilder
@Getter
@Setter
public class Person implements Serializable {
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", CPF='" + CPF + '\'' +
                ", id=" + id +
                '}';
    }
}
