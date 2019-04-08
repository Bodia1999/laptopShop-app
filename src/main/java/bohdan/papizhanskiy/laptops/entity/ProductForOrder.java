package bohdan.papizhanskiy.laptops.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class ProductForOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer count;

    @ManyToOne
    private Laptop laptop;

    @ManyToMany(mappedBy = "productForOrder")
    private List<Order> orders = new ArrayList<>();
    //        private Order order;
    @ManyToOne
    private Customer customer;

    private boolean removedToCart;


    private Double subtotal;

}

