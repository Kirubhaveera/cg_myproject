package com.cg.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dto.Appointment;
import com.cg.dto.Patient;
import com.cg.dto.Report;
import com.cg.dto.Test;
import com.cg.exceptions.AppointmentIdNotFoundException;
import com.cg.exceptions.PatientIdFoundNotException;
import com.cg.service.IPatientService;

@RestController
@RequestMapping("patients/")
public class PatientController {
	@Autowired
	private IPatientService PatientService;
	@PostMapping("addPatient")
	public ResponseEntity<Patient> addPatient(@RequestBody Patient patient){
		return new ResponseEntity<Patient>(PatientService.addPatient(patient),HttpStatus.OK);
	}
	@GetMapping("viewAllPatients")
	public List<Patient> viewPatientList() {
		return PatientService.viewPatientList();
	}
	@GetMapping("viewPatientWithId/{patientId}")
	public ResponseEntity<Patient> viewPatient(@PathVariable("patientId") int patientId) throws PatientIdFoundNotException{
		return new ResponseEntity<Patient>(PatientService.viewPatient(patientId),HttpStatus.OK);
	}
	@PutMapping("updatePatient")
	public ResponseEntity<Patient> updatePatient(@RequestBody Patient patient){
		return new ResponseEntity<Patient>(PatientService.updatePatient(patient),HttpStatus.OK);
	}
	@DeleteMapping("deletePatientWithId/{patientId}")
	public ResponseEntity<Patient> deletePatient(@PathVariable("patientId") int patientId) throws PatientIdFoundNotException{
		return new ResponseEntity<Patient>(PatientService.deletePatient(patientId),HttpStatus.OK);
	}
	@PutMapping("bookAppointment")
	public ResponseEntity<Appointment> bookAppointment(@RequestBody Appointment appointment){
		return new ResponseEntity<Appointment>(PatientService.bookAppointment(appointment),HttpStatus.OK);
	}
	@GetMapping("viewAppointment/{appointmentId}")
	public ResponseEntity<Appointment> viewAppointmentDetails(@PathVariable("appointmentId") int appointmentId) throws AppointmentIdNotFoundException{
		return new ResponseEntity<Appointment>(PatientService.viewAppointmentDetails(appointmentId),HttpStatus.OK);
	}
	
	
} 
