package com.example.demo.repository;

import com.example.demo.entity.Appointment;
import com.example.demo.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository  extends JpaRepository<Appointment, Long>{
}
