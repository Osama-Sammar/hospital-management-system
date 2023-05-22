package com.example.demo.service.impl;

import com.example.demo.dto.AppointmentDto;
import com.example.demo.entity.Appointment;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.AppointmentRepository;
import com.example.demo.service.AppointmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository appointmentRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public AppointmentDto createAppointment(AppointmentDto appointmentDto) {
        Appointment appointment = this.mapToEntity(appointmentDto);
        Appointment newAppointment = this.appointmentRepository.save(appointment);
        return this.mapToDTO(newAppointment);
    }

    public List<AppointmentDto> getAllAppointments() {
        List<Appointment> appointments = this.appointmentRepository.findAll();
        return appointments.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public AppointmentDto getAppointmentById(Long id) {
        Appointment appointment = this.appointmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment", "id", id));
        return this.mapToDTO(appointment);
    }

    public AppointmentDto updateAppointment(AppointmentDto appointmentDto, Long id) {
        Appointment appointment = this.appointmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment", "id", id));
        Appointment updatedAppointment = this.mapToEntity(appointmentDto);
        updatedAppointment.setAppointmentId(appointment.getAppointmentId());
        Appointment savedAppointment = this.appointmentRepository.save(updatedAppointment);
        return this.mapToDTO(savedAppointment);
    }

    public void deleteAppointmentById(Long id) {
        Appointment appointment = this.appointmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment", "id", id));
        this.appointmentRepository.delete(appointment);
    }

    private AppointmentDto mapToDTO(Appointment appointment) {
        AppointmentDto appointmentDto = new AppointmentDto();
        appointmentDto.setAppointmentId(appointment.getAppointmentId());
        appointmentDto.setPatientId(appointment.getPatientId());
        appointmentDto.setDoctorId(appointment.getDoctorId());
        appointmentDto.setDate(appointment.getDate());
        return appointmentDto;
    }

    private Appointment mapToEntity(AppointmentDto appointmentDto) {
        Appointment appointment = new Appointment();
        appointment.setAppointmentId(appointmentDto.getAppointmentId());
        appointment.setPatientId(appointmentDto.getPatientId());
        appointment.setDoctorId(appointmentDto.getDoctorId());
        appointment.setDate(appointmentDto.getDate());
        return appointment;
    }
}
