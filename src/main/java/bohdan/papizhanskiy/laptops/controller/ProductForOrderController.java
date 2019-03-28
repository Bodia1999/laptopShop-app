package bohdan.papizhanskiy.laptops.controller;

import bohdan.papizhanskiy.laptops.dto.request.NewProductForOrderRequest;
import bohdan.papizhanskiy.laptops.dto.request.ProductForOrderRequest;
import bohdan.papizhanskiy.laptops.dto.response.ProductForOrderResponse;
import bohdan.papizhanskiy.laptops.exception.WrongInputException;
import bohdan.papizhanskiy.laptops.service.ProductForOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/productForOrder")
public class ProductForOrderController {

    @Autowired
    private ProductForOrderService productForOrderService;

    @GetMapping
    public List<ProductForOrderResponse> findAll() {
        return productForOrderService.findAll();
    }

    @PostMapping
    public ProductForOrderResponse save(NewProductForOrderRequest newProductForOrderRequest) throws Exception {
        return productForOrderService.save(newProductForOrderRequest);
    }

    @DeleteMapping
    public void delete(Long id) throws WrongInputException {
        productForOrderService.delete(id);
    }

    @PutMapping("/{id}")
    public ProductForOrderResponse update(@RequestBody NewProductForOrderRequest newProductForOrderRequest,@PathVariable Long id) throws Exception {
        return productForOrderService.update(newProductForOrderRequest, id);
    }

    @PostMapping("/findOne")
    public ProductForOrderResponse findOne(@RequestParam Long id) throws WrongInputException{
        return new ProductForOrderResponse(productForOrderService.findOne(id));
    }
}
