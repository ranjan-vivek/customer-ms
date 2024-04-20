package com.banking.customerms.repository;

import com.banking.customerms.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact ,Integer> {
}
