package Models;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
public class Bottom extends Clothes implements Serializable {
    private String length;

    public Bottom(String size, String genre, Double price, String length) {
        super(size, genre, price);
        this.length = length;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return super.toString() + "Models.Bottom{" +
                "length='" + length + '\'' +
                '}';
    }
}
