package bohdan.papizhanskiy.laptops.dto.response;

import bohdan.papizhanskiy.laptops.entity.ProductForOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductForOrderResponse {
    private Long id;

    private Integer count;

    private LaptopResponse laptop;


    private CustomerResponse customerResponse;

    private Double subtotal;

    private boolean removedToCart;

    public ProductForOrderResponse(ProductForOrder productForOrder){
        id = productForOrder.getId();
        count = productForOrder.getCount();
        laptop = new LaptopResponse(productForOrder.getLaptop());
        customerResponse = new CustomerResponse(productForOrder.getCustomer());
        subtotal = productForOrder.getSubtotal();
        removedToCart = productForOrder.isRemovedToCart();
    }
}
