package com.example.eglbmobfkzgieoqusdjl.customer.service;

import com.example.eglbmobfkzgieoqusdjl.customer.dto.CustomerRequest;
import com.example.eglbmobfkzgieoqusdjl.customer.dto.CustomerResponse;
import com.example.eglbmobfkzgieoqusdjl.customer.model.Customer;
import com.example.eglbmobfkzgieoqusdjl.customer.repository.CustomerRepository;
import com.example.eglbmobfkzgieoqusdjl.filter.Filter;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public ResponseEntity<CustomerResponse> createCustomer(CustomerRequest customerRequest) {
        Customer customer = Customer.builder()
                .username(customerRequest.getUsername())
                .firstPhoneNumber(customerRequest.getFirstPhoneNumber())
                .secondPhoneNumber(customerRequest.getSecondPhoneNumber())
                .year(customerRequest.getYear())
                .createdAt(LocalDateTime.now())
                .build();
        CustomerResponse customerResponse = CustomerResponse.builder()
                .username(customerRequest.getUsername())
                .firstPhoneNumber(customerRequest.getFirstPhoneNumber())
                .secondPhoneNumber(customerRequest.getSecondPhoneNumber())
                .year(customerRequest.getYear())
                .build();
        customerRepository.save(customer);

        return new ResponseEntity<>(customerResponse, HttpStatus.CREATED);
    }

    public ResponseEntity<CustomerResponse> deleteById(int id) {
        Optional<Customer> customer = customerRepository.findById(id);
        customerRepository.deleteById(id);
        return customer.map(value -> ResponseEntity.status(HttpStatus.OK).body(CustomerResponse.builder()
                .username(value.getUsername())
                .firstPhoneNumber(value.getFirstPhoneNumber())
                .secondPhoneNumber(value.getSecondPhoneNumber())
                .year(value.getYear())
                .build())).orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<CustomerResponse> getById(int id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.map(value -> ResponseEntity.status(HttpStatus.OK).body(CustomerResponse.builder()
                .username(value.getUsername())
                .firstPhoneNumber(value.getFirstPhoneNumber())
                .secondPhoneNumber(value.getSecondPhoneNumber())
                .year(value.getYear())
                .build())).orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<CustomerResponse> updateCustomer(CustomerRequest customerRequest, String customerId) {
        Integer.parseInt(customerId);
        if (customerRepository.existsById(Integer.valueOf(customerId))) {
            Customer existingCustomer = customerRepository.getById(Integer.valueOf(customerId));

            copy(customerRequest, existingCustomer);

            Customer savedCustomer = customerRepository.save(existingCustomer);

            return ResponseEntity.ok(CustomerResponse.builder()
                    .username(savedCustomer.getUsername())
                    .year(savedCustomer.getYear())
                    .firstPhoneNumber(savedCustomer.getFirstPhoneNumber())
                    .secondPhoneNumber(savedCustomer.getSecondPhoneNumber())
                    .build());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    private void copy(CustomerRequest customerRequest, Customer customer) {
        if (customerRequest.getUsername() != null) {
            customer.setUsername(customerRequest.getUsername());
        }
        if (customerRequest.getFirstPhoneNumber() != null) {
            customer.setFirstPhoneNumber(customerRequest.getFirstPhoneNumber());
        }
        if (customerRequest.getSecondPhoneNumber() != null) {
            customer.setSecondPhoneNumber(customerRequest.getSecondPhoneNumber());
        }
        if (customerRequest.getYear() != 0) {
            customer.setYear(customerRequest.getYear());
        }
    }

    public List<Customer> getCustomersWithFilter(Filter filter) {
        return customerRepository.findWithLimitAndOffset(filter.getOffset(), filter.getLimit());
    }
}
