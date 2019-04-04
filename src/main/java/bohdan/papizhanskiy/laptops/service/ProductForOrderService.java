package bohdan.papizhanskiy.laptops.service;

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

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductForOrderService {

    @Autowired
    private ProductForOrderRepository productForOrderRepository;

    @Autowired
    private LaptopService laptopService;

    @Autowired
    private CustomerService customerService;


    public ProductForOrderResponse save(ProductForOrderRequest productForOrderRequest) throws Exception {
        return new ProductForOrderResponse(productForOrderRequestToProductForOrder(productForOrderRequest, null));

    }

    public List<ProductForOrderResponse> findAll() {
        return productForOrderRepository.findAll().stream().map(ProductForOrderResponse::new).collect(Collectors.toList());
    }

    public ProductForOrderResponse update(ProductForOrderRequest productForOrderRequest , Long id) throws Exception {
        return new ProductForOrderResponse(productForOrderRequestToProductForOrder(productForOrderRequest, findOne(id)));
    }

    public void delete(Long id) throws WrongInputException {
        productForOrderRepository.delete(findOne(id));
    }

    private ProductForOrder productForOrderRequestToProductForOrder(ProductForOrderRequest productForOrderRequest, ProductForOrder productForOrder) throws WrongInputException {
        if (productForOrder == null) {
            productForOrder = new ProductForOrder();
        }

        productForOrder.setCount(productForOrderRequest.getCount());
        productForOrder.setCustomer(customerService.findOne(productForOrderRequest.getCustomerId()));
        productForOrder.setLaptop(laptopService.findOne(productForOrderRequest.getLaptopId()));
        productForOrder.setSubtotal(productForOrderRequest.getSubtotal());
        productForOrder.setRemovedToCart(productForOrderRequest.isRemovedToCart());
//        productForOrder = productForOrderRepository.save(productForOrder);
//        for (Long order : productForOrderRequest.getOrderId() ){
//            Order order1 = orderService.findOne(order);
//            productForOrder.getOrders().add(order1);
//        }
//        productForOrder.setLaptop(laptopService.findOne(productForOrderRequest.getLaptopId()));
        return productForOrderRepository.save(productForOrder);

    }
//    @Transactional
    public ProductForOrder findOne(Long id) throws WrongInputException {
        return productForOrderRepository.findById(id)
                .orElseThrow(() -> new WrongInputException("Product for order with id " + id + " not exists"));
    }

    public DataResponse<ProductForOrderResponse> findAll(PaginationRequest paginationRequest) {
        Page<ProductForOrder> all = productForOrderRepository.findAll(paginationRequest.mapToPageRequest());
        return new DataResponse<>(all.get().map(ProductForOrderResponse::new).collect(Collectors.toList()), all.getTotalPages(), all.getTotalElements());
    }

    public List<ProductForOrderResponse> findAllByCustomerId(Long id){
        return productForOrderRepository.findAllByCustomerId(id).stream().map(ProductForOrderResponse::new).collect(Collectors.toList());
    }

}
