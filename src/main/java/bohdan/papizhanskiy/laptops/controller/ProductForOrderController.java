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

    @PostMapping("/save")
    public ProductForOrderResponse save(@RequestBody ProductForOrderRequest productForOrderRequest) throws Exception {
        return productForOrderService.save(productForOrderRequest);
    }

    @DeleteMapping
    public void delete( @RequestParam Long id) throws WrongInputException {
        productForOrderService.delete(id);
    }

    @PutMapping
    public ProductForOrderResponse update(@RequestBody ProductForOrderRequest productForOrderRequest,@RequestParam Long id) throws Exception {
        return productForOrderService.update(productForOrderRequest, id);
    }

    @PostMapping("/findOne")
    public ProductForOrderResponse findOne(@RequestParam Long id) throws WrongInputException{
        return new ProductForOrderResponse(productForOrderService.findOne(id));
    }

    @PostMapping("/findAllByCustomerId")
    public List<ProductForOrderResponse> findAllByCustomerId(@RequestParam Long id){
        return productForOrderService.findAllByCustomerId(id);
    }
}
