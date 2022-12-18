package Models;
import lombok.Builder;
import lombok.Getter;


public class Manager extends Person{
    private String login = "admin";
    private String password = "admin";

    protected Manager(PersonBuilder<?, ?> b) {
        super(b);
    }

    public Manager(String name, String CPF) {
        super(name, CPF);
    }

    @Override
    public String toString() {
        return "Gerente: " + super.toString();
    }
}
