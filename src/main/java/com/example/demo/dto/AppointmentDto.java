package com.example.demo.dto;

import lombok.Data;

import java.sql.Date;
@Data

public class AppointmentDto {
    private Long appointmentId;
    private Long patientId;
    private Long doctorId;
    private Date date;

    // Getters and setters
}