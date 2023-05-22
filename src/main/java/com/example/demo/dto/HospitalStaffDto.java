package com.example.demo.dto;

import lombok.Data;

@Data
public class HospitalStaffDto {
    private Long hospitalStaffId;
    private Long hospitalId;
    private String name;
    private String address;
    private int phoneNum;

    // Getters and setters
}