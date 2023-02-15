package com.cg.service;
import java.time.LocalDate;
import java.util.List;

import com.cg.dto.Appointment;
import com.cg.exceptions.AppointmentIdNotFoundException;
import com.cg.exceptions.InvalidAppointmentException;

public interface IAppointmentService{
	Appointment bookAppointment(Appointment appointment);
	Appointment updateAppointment(Appointment appointment)throws InvalidAppointmentException;
	Appointment cancelAppointment(int appointmentId)throws AppointmentIdNotFoundException;
	Appointment viewAppointment(int appointmentId)throws AppointmentIdNotFoundException;
	List<Appointment> viewAllAppointments();
	List<Appointment> viewAppointments(LocalDate date);
	public Appointment bookAppointment(Appointment appointment,int DoctorId,int patientId);
}