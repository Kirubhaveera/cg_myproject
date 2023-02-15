package com.cg.service;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cg.dto.Appointment;
import com.cg.dto.Patient;
import com.cg.dto.Report;
import com.cg.exceptions.AppointmentIdNotFoundException;
import com.cg.exceptions.PatientIdFoundNotException;
import com.cg.repository.IPatientRepository;
@Component
@Transactional
public class PatientServiceImpl implements IPatientService{
	@Autowired
	private IPatientRepository patientRepo;
	@Override
	public Patient addPatient(Patient patient) {
		return patientRepo.saveAndFlush(patient);
	}
	@Override
	public Patient updatePatient(Patient patients) throws PatientIdFoundNotException {
		Patient patient= patientRepo.findById(patients.getPatientId()).orElseThrow(()->new PatientIdFoundNotException("No Patient Found with id: "+patients.getPatientId()));
		patient.setPatientName(patient.getPatientName());
		patient.setPatientAge(patient.getPatientAge());
		patient.setPatientMobile(patient.getPatientMobile());
		patient.setPatientEmail(patient.getPatientEmail());
		patient.setPatientDOB(patient.getPatientDOB());
		patient.setPatientUsername(patient.getPatientUsername());
		patient.setPatientPassword(patient.getPatientPassword());
		patient.setPatientAddress(patient.getPatientAddress());
		patient.setAppointment(patient.getAppointment());
		return patientRepo.saveAndFlush(patients);
	}

	@Override
	public Patient deletePatient(int patientId) throws PatientIdFoundNotException{
		Patient p= patientRepo.findById(patientId).orElseThrow(()->new PatientIdFoundNotException("No Patient Found with id: "+patientId));
		patientRepo.deleteById(patientId);
		return p;
	}

	@Override
	public List<Patient> viewPatientList() {
		return patientRepo.findAll();
	}

	@Override
	public Patient viewPatient(int patientId) throws PatientIdFoundNotException{
		Patient p= patientRepo.findById(patientId).orElseThrow(()->new PatientIdFoundNotException("No Patient Found with id: "+patientId));
		return p;
	}
	@Override
	public Appointment bookAppointment(Appointment appointment) {
		List<Patient> patient=patientRepo.findAll();
		for(Patient p:patient) {
			if(p.getAppointment()==null) {
				p.setAppointment(appointment);
				patientRepo.saveAndFlush(p);
				return appointment;
			}
		}
		return null;
	}
	@Override
	public Appointment viewAppointmentDetails(int appointmentId) throws AppointmentIdNotFoundException {
		List<Patient> patient=patientRepo.findAll();
		for(Patient p:patient) {
			if(p.getAppointment().getAppointmentId()==appointmentId) {
				return p.getAppointment();
			}
		}
		throw new AppointmentIdNotFoundException("Appointmet not found for the id: "+appointmentId);
	}
	@Override
	public Report viewReport(int patientId) throws PatientIdFoundNotException {
		
		Patient p= patientRepo.findById(patientId).orElseThrow(()->new PatientIdFoundNotException("No Patient Found with id: "+patientId));
		return p.getReport();
	}

}
