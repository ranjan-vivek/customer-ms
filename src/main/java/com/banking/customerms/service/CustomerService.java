package com.banking.customerms.service;

import com.banking.customerms.entity.Customer;

public interface CustomerService {
    void addCustomer(Customer customer);
    Customer getCustomerById(int customerId);
}
