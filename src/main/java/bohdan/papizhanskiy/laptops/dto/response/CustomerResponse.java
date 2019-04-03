package bohdan.papizhanskiy.laptops.dto.response;

import bohdan.papizhanskiy.laptops.entity.Customer;
import bohdan.papizhanskiy.laptops.entity.Order;
import bohdan.papizhanskiy.laptops.entity.ShippingInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class CustomerResponse {

    private Long id;

    private String name;

    private String surname;

    private String dateBirth;

//    private ShippingInfoResponse shippingInfoResponse;

    private List<OrderResponse> orderResponse = new ArrayList<>();

    private String password;

    private String login;

    @Type(type = "text")
    private String address;

    private String phoneNumber;


//    private List<OrderResponse> orders = new ArrayList<>();

//    private List<ShippingInfoResponse> shippingInfos = new ArrayList<>();

    public CustomerResponse(Customer customer) {
        id = customer.getId();
        name = customer.getName();
        surname = customer.getSurname();
        dateBirth = customer.getDateBirth();
        address = customer.getAddress();
        phoneNumber = customer.getPhoneNumber();
        login = customer.getLogin();
//        shippingInfoResponse = new ShippingInfoResponse(customer.getShippingInfos());
//        orderResponse = customer.getOrders().stream().map(OrderResponse::new).collect(Collectors.toList());
        password = customer.getPassword();


//        orders = customer.getOrders().stream().map(OrderResponse::new).collect(Collectors.toList());
//        shippingInfos = customer.getShippingInfos().stream().map(ShippingInfoResponse::new).collect(Collectors.toList());
    }
}
