package Models;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@SuperBuilder
@Getter
@Setter
public class Top extends Clothes implements Serializable {
    private String sleeve;

    public Top(String size, String genre, Double price, String sleeve) {
        super(size, genre, price);
        this.sleeve = sleeve;
    }


    @Override
    public String toString() {
        return super.toString() + ", Tipo: Top" +
                ", Tipo da manga: " + sleeve +"}";
    }
}
