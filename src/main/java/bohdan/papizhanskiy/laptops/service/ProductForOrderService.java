package bohdan.papizhanskiy.laptops.service;

import bohdan.papizhanskiy.laptops.dto.request.NewProductForOrderRequest;
import bohdan.papizhanskiy.laptops.dto.request.PaginationRequest;
import bohdan.papizhanskiy.laptops.dto.request.ProductForOrderRequest;
import bohdan.papizhanskiy.laptops.dto.response.DataResponse;
import bohdan.papizhanskiy.laptops.dto.response.ProductForOrderResponse;
import bohdan.papizhanskiy.laptops.entity.ProductForOrder;
import bohdan.papizhanskiy.laptops.exception.WrongInputException;
import bohdan.papizhanskiy.laptops.repository.ProductForOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductForOrderService {

    @Autowired
    private ProductForOrderRepository productForOrderRepository;

    @Autowired
    private LaptopService laptopService;


    public ProductForOrderResponse save(NewProductForOrderRequest newProductForOrderRequest) throws Exception {
        return new ProductForOrderResponse(productForOrderRequestToProductForOrder(newProductForOrderRequest, null));

    }

    public List<ProductForOrderResponse> findAll() {
        return productForOrderRepository.findAll().stream().map(ProductForOrderResponse::new).collect(Collectors.toList());
    }

    public ProductForOrderResponse update(NewProductForOrderRequest newProductForOrderRequest, Long id) throws Exception {
        return new ProductForOrderResponse(productForOrderRequestToProductForOrder(newProductForOrderRequest, findOne(id)));
    }

    public void delete(Long id) throws WrongInputException {
        productForOrderRepository.delete(findOne(id));
    }

    private ProductForOrder productForOrderRequestToProductForOrder(NewProductForOrderRequest newProductForOrderRequest, ProductForOrder productForOrder) throws Exception {
        if (productForOrder == null) {
            productForOrder = new ProductForOrder();
        }
        productForOrder.setCount(3);
        productForOrder.setLaptop(laptopService.findOne(1L));
//        productForOrder = productForOrderRepository.save(productForOrder);
//        for (Long order : productForOrderRequest.getOrderId() ){
//            Order order1 = orderService.findOne(order);
//            productForOrder.getOrders().add(order1);
//        }
//        productForOrder.setLaptop(laptopService.findOne(productForOrderRequest.getLaptopId()));
        return productForOrderRepository.save(productForOrder);

    }
    @Transactional
    public ProductForOrder findOne(Long id) throws WrongInputException {
        return productForOrderRepository.findById(id)
                .orElseThrow(() -> new WrongInputException("Product for order with id " + id + " not exists"));
    }

    public DataResponse<ProductForOrderResponse> findAll(PaginationRequest paginationRequest) {
        Page<ProductForOrder> all = productForOrderRepository.findAll(paginationRequest.mapToPageRequest());
        return new DataResponse<>(all.get().map(ProductForOrderResponse::new).collect(Collectors.toList()), all.getTotalPages(), all.getTotalElements());
    }
}
