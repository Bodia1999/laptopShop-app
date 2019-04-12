package bohdan.papizhanskiy.laptops.service;

import bohdan.papizhanskiy.laptops.dto.request.CustomerRequest;
import bohdan.papizhanskiy.laptops.dto.request.PaginationRequest;
import bohdan.papizhanskiy.laptops.dto.response.CustomerResponse;
import bohdan.papizhanskiy.laptops.dto.response.DataResponse;
import bohdan.papizhanskiy.laptops.dto.response.MakeResponse;
import bohdan.papizhanskiy.laptops.entity.Customer;
import bohdan.papizhanskiy.laptops.entity.Make;
import bohdan.papizhanskiy.laptops.entity.Role;
import bohdan.papizhanskiy.laptops.exception.WrongInputDataException;
import bohdan.papizhanskiy.laptops.exception.WrongInputException;
import bohdan.papizhanskiy.laptops.repository.CustomerRepository;
import bohdan.papizhanskiy.laptops.security.tokenUtils.TokenTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;



    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokenTool tokenTool;


//    public CustomerResponse save(CustomerRequest customerRequest) throws WrongInputException {
//
//        return new CustomerResponse(customerRequestToCustomer(null, customerRequest));
//
//    }

    public CustomerResponse update(CustomerRequest customerRequest, Long id) throws WrongInputException {
        return new CustomerResponse(customerRequestToCustomer(findOne(id), customerRequest));
    }

    private Customer customerRequestToCustomer(Customer customer, CustomerRequest request) throws WrongInputException {
        if (customer == null) {
            customer = new Customer();
        }
        customer.setName(request.getName());
        customer.setSurname(request.getSurname());
        customer.setDateBirth(request.getDateBirth());
        customer.setAddress(request.getAddress());
        customer.setPhoneNumber(request.getPhoneNumber());

//        customer.setUser(userService.findOneByEmail(customerRequest.getUserRequest().getLogin()));
//        customer.setUser(userService.findOneByLogin(customerRequest.getLogin()));


        return customerRepository.save(customer);
    }


    public List<CustomerResponse> findAll() {
        return customerRepository.findAll().stream().map(CustomerResponse::new).collect(Collectors.toList());
    }

    public Customer findOne(Long id) throws WrongInputException {
        return customerRepository.findById(id).orElseThrow(() -> new WrongInputException("Customer with " + id + " not exists"));
    }

    public void delete(Long id) throws WrongInputException {
        customerRepository.delete(findOne(id));
    }


    public CustomerResponse save(CustomerRequest request) throws Exception {
        if (customerRepository.findByLoginEquals(request.getLogin()).isPresent()) {
            throw new Exception("Credentials are busy. Please, try one more time " +
                    "with other login");
        }
        Customer customer = new Customer();
        customer.setLogin(request.getLogin());
        customer.setPassword(passwordEncoder.encode(request.getPassword()));
        customer.setName(request.getName());
        customer.setSurname(request.getSurname());
        customer.setDateBirth(request.getDateBirth());
        customer.setAddress(request.getAddress());
        customer.setPhoneNumber(request.getPhoneNumber());

        customer.setRole(Role.USER);

        customer = customerRepository.saveAndFlush(customer);
        Customer saving = customerRepository.save(customer);
        Long id = saving.getId();
        @NotNull Role role = saving.getRole();
        String password = tokenTool.createToken(customer.getLogin(), customer.getRole().name());


        return settingData(id,password,role);

    }

    private CustomerResponse settingData(Long id, String password ,Role role){
        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setId(id);
        customerResponse.setPassword(password);
        customerResponse.setRole(role);
        return customerResponse;
    }
    public CustomerResponse findOneByRequest(CustomerRequest request) throws WrongInputDataException {
        Customer customer = customerRepository.findByLoginEquals(request.getLogin()).orElseThrow(() -> new WrongInputDataException("User with login " + request.getLogin() + " not exists"));

        if (passwordEncoder.matches(request.getPassword(), customer.getPassword())) {
            Long id = customer.getId();
            String token = tokenTool.createToken(customer.getLogin(), customer.getRole().name());
            @NotNull Role role = customer.getRole();
            return settingData(id,token, role);
        }

        throw new IllegalArgumentException("Wrong login or password");
    }



}
