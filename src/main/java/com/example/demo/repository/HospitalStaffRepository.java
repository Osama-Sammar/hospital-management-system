package com.example.demo.repository;

import com.example.demo.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.HospitalStaff;

public interface HospitalStaffRepository extends JpaRepository<HospitalStaff, Long> {

}
