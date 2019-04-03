package bohdan.papizhanskiy.laptops.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

public class ProductForOrderRequest {
//    @NotNull
//    @NotEmpty
//    @Min(1)
    private Integer count;
//    @NotNull
//    @NotEmpty
//    @Min(1)
    private Long laptopId;

    private Long customerId;

    private Double subtotal;
//    private Long[] orderId;
}
