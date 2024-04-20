package com.banking.customerms.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="contact")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int contactId;
    private String phoneNo;
    private String email;
    //@JoinColumn is used to canfge the column name of reference
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
}
