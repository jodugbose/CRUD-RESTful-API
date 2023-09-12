package com.interswitch.databasefinal.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String fullName;
    @Column(nullable = false)
    private String phoneNumber;
    @Column(nullable = false)
    private String dateJoined;

    public Customer(Long id, String fullName, String phoneNumber, String dateJoined) {
        this.id = id;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.dateJoined = dateJoined;
    }
}
