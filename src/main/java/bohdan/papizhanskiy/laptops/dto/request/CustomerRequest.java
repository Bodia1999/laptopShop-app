package bohdan.papizhanskiy.laptops.dto.request;

import bohdan.papizhanskiy.laptops.dto.response.OrderResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CustomerRequest {

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @NotEmpty
    private String surname;

    @NotNull
    @NotEmpty
    private String dateBirth;
    @Type(type = "text")
    private String address;

    @NotNull
    @NotEmpty
    private String phoneNumber;



//    @NotNull
//    @NotEmpty
//    @Min(1)
    private List<OrderResponse> orders = new ArrayList<>();

//    private List<ShippingInfo> shippingInfos = new ArrayList<>();

    @Email
    private String login;

    @NotNull
    @NotEmpty
    @Min(6)
    @Max(20)
    private String password;
}
