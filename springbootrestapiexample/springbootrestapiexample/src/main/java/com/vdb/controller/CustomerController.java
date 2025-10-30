package com.vdb.controller;

import com.vdb.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("/customers")
@Slf4j
public class CustomerController {

    List<Customer> customerList = Stream.of(new Customer(1, "Sachin", 29309.93),
            new Customer(2, "Vivek", 332309.93),
            new Customer(3, "Ganesh", 769309.93),
            new Customer(4, "Ganu", 549309.93)
    ).toList();


    @GetMapping("/findAll")
    public ResponseEntity<List<Customer>> findAll() {
        return ResponseEntity.ok(customerList);
    }

    @GetMapping("/sortbyname")
    public ResponseEntity<List<Customer>> sortByName() {
        return ResponseEntity.ok(customerList.stream().sorted(Comparator.comparing(Customer::getCustName)).toList());
    }

    @GetMapping("/findbyname")
    public ResponseEntity<List<Customer>> findByName(@RequestParam(defaultValue = "Sachin", required = false) String custName) {
        return ResponseEntity.ok(customerList.stream().filter(cust -> cust.getCustName().equals(custName)).toList());
    }

}
