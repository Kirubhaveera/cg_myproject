package com.cg.dto;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Appointment{
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int appointmentId;
	@DateTimeFormat(style = "yyyy-MM-dd")
	private LocalDate dateOfAppointment;
	@DateTimeFormat(style = "HH:mm")
	private String timeOfAppointment;
	private double consultationFee;
	
	@ManyToOne
	@JoinColumn(name = "doctorId", referencedColumnName = "doctorId")
	private Doctor doctor;
	
	@OneToOne(mappedBy = "appointment")
//	@JsonIgnoreProperties("appointment")
	@JoinColumn(name = "patientId", referencedColumnName = "patientId")
	private Patient patient;
	public Appointment() {
		// TODO Auto-generated constructor stub
	}
	public Appointment(int i, String string, String string2, int j) {
		// TODO Auto-generated constructor stub
	}

	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

	public LocalDate getDateOfAppointment() {
		return dateOfAppointment;
	}

	public void setDateOfAppointment(LocalDate dateOfAppointment) {
		this.dateOfAppointment = dateOfAppointment;
	}

	public String getTimeOfAppointment() {
		return timeOfAppointment;
	}

	public void setTimeOfAppointment(String timeOfAppointment) {
		this.timeOfAppointment = timeOfAppointment;
	}

	public double getConsultationFee() {
		return consultationFee;
	}

	public void setConsultationFee(double consultationFee) {
		this.consultationFee = consultationFee;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", dateOfAppointment=" + dateOfAppointment
				+ ", timeOfAppointment=" + timeOfAppointment + ", consultationFee=" + consultationFee + ", doctor="
				+ doctor + ", patient=" + patient + "]";
	}

	public int getAppointmentId() {
		return appointmentId;
	}


}