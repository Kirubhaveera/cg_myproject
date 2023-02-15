package com.cg.dto;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
public class Patient{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int patientId;
	private String patientName;
	private int patientAge;
	private long patientMobile;
	private String patientEmail;
	@DateTimeFormat(style = "yyyy-MM-dd")
	private LocalDate patientDOB;
	private String patientUsername;
	private String patientPassword;
	private String patientAddress;

	@OneToOne(cascade=CascadeType.ALL)
//	@JsonIgnoreProperties("patient") 
	private Appointment appointment;
	
	@OneToOne(mappedBy="patient")
	@JsonIgnoreProperties("patient")
	private Report report;
	public Patient() {
		// TODO Auto-generated constructor stub
	}
	public Patient(int i, String string, int j, int k, String string2, String string3, String string4, String string5,
			String string6) {
		// TODO Auto-generated constructor stub
	}
	
	public Patient(int i, String string, String string2, int j, String string3, String string4, String string5,
			String string6) {
		// TODO Auto-generated constructor stub
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public int getPatientAge() {
		return patientAge;
	}
	public void setPatientAge(int patientAge) {
		this.patientAge = patientAge;
	}
	public long getPatientMobile() {
		return patientMobile;
	}
	public void setPatientMobile(long patientMobile) {
		this.patientMobile = patientMobile;
	}
	public String getPatientEmail() {
		return patientEmail;
	}

	public void setPatientEmail(String patientEmail) {
		this.patientEmail = patientEmail;
	}

	public LocalDate getPatientDOB() {
		return patientDOB;
	}
	public void setPatientDOB(LocalDate patientDOB) {
		this.patientDOB = patientDOB;
	}
	public String getPatientUsername() {
		return patientUsername;
	}
	public void setPatientUsername(String patientUsername) {
		this.patientUsername = patientUsername;
	}
	public String getPatientPassword() {
		return patientPassword;
	}
	public void setPatientPassword(String patientPassword) {
		this.patientPassword = patientPassword;
	}
	public String getPatientAddress() {
		return patientAddress;
	}
	public void setPatientAddress(String patientAddress) {
		this.patientAddress = patientAddress;
	}
	public Appointment getAppointment() {
		return appointment;
	}
	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}
	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", patientName=" + patientName + ", patientAge=" + patientAge
				+ ", patientMobile=" + patientMobile + ", patientEmail=" + patientEmail + ", patientDOB=" + patientDOB
				+ ", patientUsername=" + patientUsername + ", patientPassword=" + patientPassword + ", patientAddress="
				+ patientAddress + ", appointment=" + appointment + ", report=" + report + "]";
	}
	public Report getReport() {
		return report;
	}
	public void setReport(Report report) {
		this.report = report;
	}
		
	
}
