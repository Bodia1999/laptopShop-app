package bohdan.papizhanskiy.laptops.dto.response;

import bohdan.papizhanskiy.laptops.entity.Customer;
import bohdan.papizhanskiy.laptops.entity.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
public class CustomerResponse {

    private Long id;

    private String name;

    private String surname;

    private String dateBirth;

    private List<OrderResponse> orderResponse = new ArrayList<>();

    private String password;

    private String login;

    @Type(type = "text")
    private String address;

    private String phoneNumber;

    private Role role;



    public CustomerResponse(Customer customer) {
        id = customer.getId();
        name = customer.getName();
        surname = customer.getSurname();
        dateBirth = customer.getDateBirth();
        address = customer.getAddress();
        phoneNumber = customer.getPhoneNumber();
        login = customer.getLogin();
        password = customer.getPassword();
        role = customer.getRole();

    }

}
