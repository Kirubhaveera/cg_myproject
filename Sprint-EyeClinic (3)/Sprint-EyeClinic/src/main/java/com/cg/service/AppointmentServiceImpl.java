package com.cg.service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.dto.Appointment;
import com.cg.dto.Doctor;
import com.cg.dto.Patient;
import com.cg.exceptions.AppointmentIdNotFoundException;
import com.cg.exceptions.InvalidAppointmentException;
import com.cg.repository.IAppointmentRepository;
import com.cg.repository.IDoctorRepository;
import com.cg.repository.IPatientRepository;
@Component
@Transactional
public class AppointmentServiceImpl implements IAppointmentService{
	@Autowired
	private IAppointmentRepository appRepo;
	@Autowired
	private IDoctorRepository docRepo;
	@Autowired
	private IPatientRepository patRepo;
	@Override
	public Appointment bookAppointment(Appointment appointment) {
		return appRepo.saveAndFlush(appointment);
	}
	@Override
	public Appointment updateAppointment(Appointment appointments)throws InvalidAppointmentException{
		Appointment appointment = appRepo.findById(appointments.getAppointmentId()).orElseThrow(()->new InvalidAppointmentException("Invalid appointment for this Id: "+ appointments.getAppointmentId()));
		appointment.setConsultationFee(appointment.getConsultationFee());
		appointment.setDateOfAppointment(appointment.getDateOfAppointment());
		appointment.setDoctor(appointment.getDoctor());
		appointment.setPatient(appointment.getPatient());
		appointment.setTimeOfAppointment(appointment.getTimeOfAppointment());
		return appRepo.saveAndFlush(appointments);
	}
	@Override
	public Appointment cancelAppointment(int appointmentId) throws AppointmentIdNotFoundException {
		Appointment appointment1 = appRepo.findById(appointmentId).orElseThrow(()->new AppointmentIdNotFoundException("Appointment not fount for the Id: "+ appointmentId));
		appRepo.deleteById(appointmentId);
		return appointment1;
	}
	@Override
	public Appointment viewAppointment(int appointmentId) throws AppointmentIdNotFoundException {
		return appRepo.findById(appointmentId).orElseThrow(()->new AppointmentIdNotFoundException("Appointment not fount for the Id: "+ appointmentId));
		
	}
	@Override
	public List<Appointment> viewAllAppointments() {
		return appRepo.findAll();
	}
	@Override
	public List<Appointment> viewAppointments(LocalDate date){
		List<Appointment> appointment = appRepo.findAll();
		List<Appointment> list = new ArrayList<Appointment>();
		for(Appointment app:appointment) {
			if(app.getDateOfAppointment().isEqual(date)) {
				list.add(app);
			}
		}
		return list;
	}
	@Override
	public Appointment bookAppointment(Appointment appointment, int DoctorId, int patientId) {
		Doctor doctor=docRepo.findById(DoctorId).get();
		Patient patient=patRepo.findById(patientId).get();
		appointment.setDoctor(doctor);
		appointment.setPatient(patient);
		appRepo.save(appointment);
		return appointment;
	}	
	

	
}
