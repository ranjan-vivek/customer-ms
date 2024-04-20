package com.banking.customerms.controller;

import com.banking.customerms.entity.ApiResponse;
import com.banking.customerms.entity.Customer;
import com.banking.customerms.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static java.util.Objects.nonNull;

@RestController
@RequestMapping("/presentation/v1/customer-ms")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    public ResponseEntity<ApiResponse> createCustomer(@RequestBody Customer customer) {
        ApiResponse apiResponse = new ApiResponse();
        try{
            customerService.addCustomer(customer);
            apiResponse.setCode(200);
            apiResponse.setResponseCode("Success");
            apiResponse.setMessage("Customer data saved successfully");
            return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
        } catch (Exception e){
            apiResponse.setCode(500);
            apiResponse.setResponseCode("Failed");
            apiResponse.setMessage("Error saving Customer data  ");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiResponse);
        }
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<ApiResponse<Customer>> fetchCustomerDetails(@PathVariable int customerId) {
        ApiResponse<Customer> apiResponse = new ApiResponse();
        try{
            Customer customerResponse = customerService.getCustomerById(customerId);
            if (nonNull(customerResponse)) {
                apiResponse.setCode(200);
                apiResponse.setResponseCode("Success");
                apiResponse.setMessage("Customer data retrived");
                apiResponse.setData(customerResponse);
                return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
            } else {
                apiResponse.setCode(404);
                apiResponse.setResponseCode("Not Found");
                apiResponse.setMessage("Customer data with id:"+ customerId+ "not found");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponse);
            }

        } catch (Exception e){
            apiResponse.setCode(500);
            apiResponse.setResponseCode("Failed");
            apiResponse.setMessage("Error saving Customer data  ");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiResponse);
        }
    }
}
