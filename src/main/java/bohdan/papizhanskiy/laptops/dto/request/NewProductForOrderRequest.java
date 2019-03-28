package bohdan.papizhanskiy.laptops.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewProductForOrderRequest {

    private Long laptopId;
    private Integer count;
}
