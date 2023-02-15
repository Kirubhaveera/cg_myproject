package com.cg.controller;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import com.cg.exceptions.AppointmentIdNotFoundException;
import com.cg.exceptions.InvalidAppointmentException;
import com.cg.service.IAppointmentService;
@RestController
@RequestMapping("appointments/")
public class AppointmentController {
	@Autowired
	private IAppointmentService appointmentService;
	@PostMapping("bookAppointment")
	public ResponseEntity<Appointment> bookAppointment(@RequestBody Appointment appointment){
		return new ResponseEntity<Appointment>(appointmentService.bookAppointment(appointment),HttpStatus.OK);
	}
	@PutMapping("updateAppointment")
	public ResponseEntity<Appointment> updateAppointment(@RequestBody Appointment appointment) throws InvalidAppointmentException{
		return new ResponseEntity<Appointment>(appointmentService.updateAppointment(appointment),HttpStatus.OK);
	}
	@DeleteMapping("cancelAppointment/{appointmentId}")
	public ResponseEntity<Appointment> cancelAppointment(@PathVariable("appointmentId") int appointmentId) throws AppointmentIdNotFoundException{
		return new ResponseEntity<Appointment>(appointmentService.cancelAppointment(appointmentId),HttpStatus.OK);
	}
	@GetMapping("viewAppointmentWithId/{appointmentId}")
	public ResponseEntity<Appointment> viewAppointment(@PathVariable("appointmentId") int appointmentId) throws AppointmentIdNotFoundException{
		return new ResponseEntity<Appointment>(appointmentService.viewAppointment(appointmentId),HttpStatus.OK);
	}
	@GetMapping("viewAllAppointments")
	public List<Appointment> viewAllAppointments() {
		return appointmentService.viewAllAppointments();
	}
	@GetMapping("viewAppointmentWithDate/{date}")
	public List<Appointment> viewAppointments(@PathVariable("date") CharSequence date) {
		LocalDate localDate = LocalDate.parse(date,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		return appointmentService.viewAppointments(localDate);
	}
	@PostMapping("bookAppointment/{doctorId}/{patientId}")
	public Appointment bookAppointment(@RequestBody Appointment appt,@PathVariable int doctorId,@PathVariable int patientId){
		return appointmentService.bookAppointment(appt,doctorId,patientId);
	}

}

