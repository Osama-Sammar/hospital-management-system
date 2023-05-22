package com.example.demo.service;
import com.example.demo.dto.AppointmentDto;

import java.util.List;
public interface AppointmentService {
    AppointmentDto createAppointment(AppointmentDto appointmentDto);

    List<AppointmentDto> getAllAppointments();

    AppointmentDto getAppointmentById(Long id);

    AppointmentDto updateAppointment(AppointmentDto appointmentDto, Long id);

    void deleteAppointmentById(Long id);
}
