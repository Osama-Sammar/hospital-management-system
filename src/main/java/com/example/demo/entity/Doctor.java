//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table
public class Doctor {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long doctor_id;
    private String doctorName;
    private String specialty;
    private int phoneNum;
    private int hospitalId;

}
