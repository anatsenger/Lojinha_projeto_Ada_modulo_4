package Models;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
public class Client extends Person{
    private List<Clothes> shopping;

    public Client(String name, String CPF, List<Clothes> shopping) {
        super(name, CPF);
        this.shopping = shopping;
    }
    public static int getId(List<Client> list){
        try {
            var id = list.stream().max(Comparator.comparingInt(i -> i.getId())).get().getId();
            return ++id;
        }catch (NoSuchElementException g){
            return 0;
        }
    }

    @Override
    public String toString() {
        return "{Cliente: " + super.toString();
    }
}
