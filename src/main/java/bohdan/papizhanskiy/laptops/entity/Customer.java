package bohdan.papizhanskiy.laptops.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Type;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
//@ToString
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;
//    @Column(unique = true)
    private String surname;

    private String dateBirth;

    private String phoneNumber;

    @Column(unique = true)
    private String login;
    private String password;

    @Type(type = "text")
    private String address;

    @NotNull
    private Role role;



//    @ToString.Exclude
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "customer")

    private List<Order> orders = new ArrayList<>();


    @OneToMany(mappedBy = "customer")
    private List<ProductForOrder> productForOrders = new ArrayList<>();
//    @ToString.Exclude
//    @OneToOne(mappedBy = "customer")
//    private ShippingInfo shippingInfos;

//    @OneToOne(mappedBy = "customer")
//    private User user;

}
