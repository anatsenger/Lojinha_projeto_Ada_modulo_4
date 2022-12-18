package Models;

import java.util.List;
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
}
