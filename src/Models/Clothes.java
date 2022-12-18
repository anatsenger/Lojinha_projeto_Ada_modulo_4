package Models;


import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@SuperBuilder
public class Clothes implements Serializable {
    private static int total;
    private int id;
    private String size;
    private String genre;
    private Double price;

    public Clothes(String size, String genre, Double price) {
        total++;
        this.id = total;
        this.size = size;
        this.genre = genre;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Clothes{" + "id = "+ id +
                "size ='" + size +
                ", genre='" + genre +
                ", price=" + price +
                '}';
    }

    public int getId() {
        return id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
