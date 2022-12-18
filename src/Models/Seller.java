package Models;

import java.math.BigDecimal;
import java.util.List;
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


}
