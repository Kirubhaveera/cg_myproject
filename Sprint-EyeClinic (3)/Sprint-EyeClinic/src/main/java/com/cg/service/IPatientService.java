package com.cg.service;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cg.dto.Appointment;
import com.cg.dto.Patient;
import com.cg.dto.Report;
import com.cg.exceptions.AppointmentIdNotFoundException;
import com.cg.exceptions.PatientIdFoundNotException;

public interface IPatientService {
	Patient addPatient(Patient patient);
	Patient updatePatient(Patient patient);
	Patient deletePatient(int patientId) throws PatientIdFoundNotException;
	List<Patient> viewPatientList();
	Patient viewPatient(int patientId) throws PatientIdFoundNotException;
	Appointment bookAppointment(Appointment appointment);
	Appointment viewAppointmentDetails(int appointmentid)throws AppointmentIdNotFoundException;
	 Report viewReport(int patientId)throws PatientIdFoundNotException;

}