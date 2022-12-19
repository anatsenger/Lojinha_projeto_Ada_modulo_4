package Models;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
public class Seller extends Person{
    private List<Clothes> sales;
    private BigDecimal salary;

    public Seller(String name, String CPF, int id) {
        super(name, CPF);
    }


    public List<Clothes> getSales() {
        return sales;
    }

    public void setSales(List<Clothes> sales) {
        this.sales = sales;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public static int getId(List<Seller> list){
        try {
            var id = list.stream().max(Comparator.comparingInt(i -> i.getId())).get().getId();
            return ++id;
        }catch (NoSuchElementException g){
            return 0;
        }
    }

    @Override
    public String toString() {
        return "{Vendedor: " + super.toString();
    }
}
