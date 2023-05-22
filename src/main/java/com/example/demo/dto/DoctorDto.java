
package com.example.demo.dto;

import lombok.Data;

@Data
public class DoctorDto {
    private Long doctor_id;
    private String doctorName;
    private String specialty;
    private int phoneNum;
    private int hospitalId;

}
