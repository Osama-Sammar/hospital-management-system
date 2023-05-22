package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table
public class HospitalStaff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hospitalStaffId;
    private Long hospitalId;
    private String name;
    private String address;
    private int phoneNum;

    // Getters and setters
}
