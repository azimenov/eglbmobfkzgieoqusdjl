package com.example.eglbmobfkzgieoqusdjl.customer.controller;

import com.example.eglbmobfkzgieoqusdjl.customer.dto.CustomerRequest;
import com.example.eglbmobfkzgieoqusdjl.customer.dto.CustomerResponse;
import com.example.eglbmobfkzgieoqusdjl.customer.model.Customer;
import com.example.eglbmobfkzgieoqusdjl.customer.service.CustomerService;
import com.example.eglbmobfkzgieoqusdjl.filter.Filter;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
@AllArgsConstructor
public class CustomerController {
    @PostConstruct
    public void init(){
        customerService.createCustomer(new CustomerRequest("margulan", "+77077146503", "+77077146503", 2005));
        customerService.createCustomer(new CustomerRequest("margulan", "+77077146503", "+77077146503", 2005));
        customerService.createCustomer(new CustomerRequest("margulan", "+77077146503", "+77077146503", 2005));
        customerService.createCustomer(new CustomerRequest("margulan", "+77077146503", "+77077146503", 2005));
    }
    private final CustomerService customerService;

    @GetMapping("/greet")
    public String greeting(){
        return "hello greetgo";
    }

    @PostMapping("/createCustomer")
    public ResponseEntity<CustomerResponse> createCustomer(@RequestBody CustomerRequest customerRequest) {
        return customerService.createCustomer(customerRequest);
    }

    @DeleteMapping("/deleteCustomerById/{customerId}")
    public ResponseEntity<CustomerResponse> deleteCustomer(@PathVariable int customerId) {
        return customerService.deleteById(customerId);
    }

    @GetMapping("/getCustomerById/{id}")
    public ResponseEntity<CustomerResponse> getCustomer(@PathVariable int id) {
        return customerService.getById(id);
    }

    @PatchMapping("/updateCustomer/{customerId}")
    public ResponseEntity<CustomerResponse> updateCustomer(@RequestBody CustomerRequest customerRequest, @PathVariable String customerId) {
        return customerService.updateCustomer(customerRequest, customerId);
    }

    @GetMapping("/getCustomersWithFilter")
    public List<Customer> getCustomersWithFilter(@RequestBody Filter filter){
        return customerService.getCustomersWithFilter(filter);
    }
}
