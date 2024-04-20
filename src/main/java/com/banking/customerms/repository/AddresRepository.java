package com.banking.customerms.repository;

import com.banking.customerms.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddresRepository extends JpaRepository<Address,Integer> {
}
