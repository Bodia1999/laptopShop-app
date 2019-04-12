package bohdan.papizhanskiy.laptops.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter

public class ProductForOrderRequest {
    @NotNull
    @NotEmpty
    @Min(1)
    private Integer count;
    @NotNull
    @NotEmpty
    @Min(1)
    private Long laptopId;
    @NotNull
    @NotEmpty
    @Min(1)
    private Long customerId;
    @NotNull
    @NotEmpty
    @Min(1)
    private Double subtotal;

    private boolean removedToCart;
//    private Long[] orderId;
}
