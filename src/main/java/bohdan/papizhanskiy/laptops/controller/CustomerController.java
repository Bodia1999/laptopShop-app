package bohdan.papizhanskiy.laptops.controller;

import bohdan.papizhanskiy.laptops.dto.request.CustomerRequest;
import bohdan.papizhanskiy.laptops.dto.request.PaginationRequest;
import bohdan.papizhanskiy.laptops.dto.response.CustomerResponse;
import bohdan.papizhanskiy.laptops.dto.response.DataResponse;
import bohdan.papizhanskiy.laptops.entity.Customer;
import bohdan.papizhanskiy.laptops.exception.WrongInputDataException;
import bohdan.papizhanskiy.laptops.exception.WrongInputException;
import bohdan.papizhanskiy.laptops.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@CrossOrigin

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customer")
//    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public List<CustomerResponse> findAll() {
        return customerService.findAll();
    }

//    @PostMapping("/customer")
//    public CustomerResponse save(@RequestBody CustomerRequest customerRequest) throws Exception {
//        return customerService.save(customerRequest);
//    }

    @DeleteMapping("/customer")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public void delete(@Valid @RequestParam Long id) throws WrongInputException {
        customerService.delete(id);
    }

    @PutMapping("/customer")
    public CustomerResponse update(@RequestBody CustomerRequest customerRequest, @RequestParam Long id) throws WrongInputException {
        return customerService.update(customerRequest, id);
    }

    @PostMapping("/customer/findOne")

    public CustomerResponse findOne(@RequestParam Long id) throws WrongInputException{
        return new CustomerResponse(customerService.findOne(id));
    }

//    @PostMapping("/page")
//    public DataResponse<CustomerResponse> findAll(@RequestBody PaginationRequest paginationRequest){
//        return customerService.findAll(paginationRequest);
//    }

    @PostMapping("/public/register")
    public CustomerResponse saveUser(@RequestBody CustomerRequest customerRequest) throws Exception {
        return customerService.save(customerRequest);
    }

    @PostMapping("/public/login")
    public CustomerResponse login(@RequestBody CustomerRequest customerRequest) throws Exception {
        return customerService.findOneByRequest(customerRequest);
    }
}
