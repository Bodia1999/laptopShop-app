package bohdan.papizhanskiy.laptops.dto.response;

import bohdan.papizhanskiy.laptops.entity.Customer;
import bohdan.papizhanskiy.laptops.entity.Order;
import bohdan.papizhanskiy.laptops.entity.ProductForOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse {

    private Long id;

    private Double subtotal;

    private String orderTime;

//    private List<String> laptopName = new ArrayList<>();



    private List<ProductForOrderResponse> productForOrder = new ArrayList<>();

    public OrderResponse(Order order){
        id = order.getId();
        subtotal = order.getSubtotal();
        orderTime = order.getOrderTime();
        productForOrder = order.getProductForOrder().stream().map(ProductForOrderResponse::new).collect(Collectors.toList());

    }
}
