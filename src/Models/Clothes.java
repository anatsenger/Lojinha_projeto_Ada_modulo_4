package Models;


import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

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
        return "{Roupa: " + "id: "+ id +
                ", Tamanho: " + size +
                ", gênero: " + genre +
                ", preço: " + price;
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

    public static int getId(List<Clothes> list){
        try {
            var id = list.stream().max(Comparator.comparingInt(i -> i.getId())).get().getId();
            return ++id;
        }catch (NoSuchElementException g){
            return 0;
        }
    }
}
