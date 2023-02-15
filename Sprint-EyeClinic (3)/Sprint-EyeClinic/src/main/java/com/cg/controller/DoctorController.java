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
import com.cg.dto.Doctor;
import com.cg.dto.Test;
import com.cg.exceptions.DoctorIdNotFoundException;
import com.cg.service.IDoctorService;

@RestController
@RequestMapping("doctors/")
public class DoctorController {
	@Autowired
	private IDoctorService DoctorService;
    @PostMapping("addDoctor")
	public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor){
		return new ResponseEntity<Doctor>(DoctorService.addDoctor(doctor),HttpStatus.OK);
	}
    @PutMapping("updateDoctor")
	public ResponseEntity<Doctor> updateDoctor(@RequestBody Doctor doctor)throws DoctorIdNotFoundException{
		return new ResponseEntity<Doctor>(DoctorService.updateDoctor(doctor),HttpStatus.OK);
	}
    @DeleteMapping("deleteDoctorWithId/{doctorId}")
	public ResponseEntity<Doctor> deleteDoctor(@PathVariable("doctorId") int doctorId) throws DoctorIdNotFoundException{
		return new ResponseEntity<Doctor>(DoctorService.deleteDoctor(doctorId),HttpStatus.OK);
	}
    @GetMapping("viewDoctorWithId/{doctorId}")
	public ResponseEntity<Doctor> viewDoctor(@PathVariable("doctorId") int doctorId) throws DoctorIdNotFoundException{
		return new ResponseEntity<Doctor>(DoctorService.viewDoctor(doctorId),HttpStatus.OK);
	}
    @GetMapping("viewAllDoctors")
	public List<Doctor> viewDoctorsList() {
		return DoctorService.viewDoctorsList();
	}
    @GetMapping("viewAllAppointments")
	public List<Appointment> viewAppointments(){
		return DoctorService.viewAppointments();
	}
    @PutMapping("createTest/{doctorId}")
    public ResponseEntity<Test> createTest(@PathVariable("doctorId") int doctorId,@RequestBody Test test){
		return new ResponseEntity<Test>(DoctorService.createTest(doctorId,test),HttpStatus.OK);
	}
}
