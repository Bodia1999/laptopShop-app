package bohdan.papizhanskiy.laptops.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
public class NewProductForOrderRequest {

    private Long laptopId;
    private Integer count;
}
