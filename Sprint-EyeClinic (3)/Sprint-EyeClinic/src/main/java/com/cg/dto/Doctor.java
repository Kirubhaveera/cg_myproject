package com.cg.dto;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Doctor implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int doctorId;
	private String doctorName;
	private LocalTime doctorConsultationTime;
	private long doctorMobile;
	private String doctorEmail;
	private String doctorUsername;
	private String doctorPassword;
	private String doctorAddress;
	
	@OneToMany(mappedBy="doctor",cascade=CascadeType.ALL)
	@JsonIgnoreProperties("doctor")
	private List<Appointment> appointment=new ArrayList<>();
	//@JsonManagedReference
//	@ManyToOne(mappedBy="doctor",cascade=CascadeType.ALL)
//	@JsonIgnoreProperties("doctor")	
//	private List<Test> test;

	
	public Doctor() {
		// TODO Auto-generated constructor stub
	}
	
	
		public Doctor(int doctorId, String doctorName, LocalTime doctorConsultationTime, long doctorMobile,
			String doctorEmail, String doctorUsername, String doctorPassword, String doctorAddress,
			List<Appointment> appointment) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.doctorConsultationTime = doctorConsultationTime;
		this.doctorMobile = doctorMobile;
		this.doctorEmail = doctorEmail;
		this.doctorUsername = doctorUsername;
		this.doctorPassword = doctorPassword;
		this.doctorAddress = doctorAddress;
		this.appointment = appointment;
		//this.test = test;
	}


		public Doctor(int i, String string, String string2, int j, String string3, String string4, String string5) {
			// TODO Auto-generated constructor stub
		}


//		public List<Test> getTest() {
//		return test;
//	}
//
//
//	public void setTest(List<Test> test) {
//		this.test = test;
//	}


		public Doctor(int i, String string, String string2, int j, String string3, String string4, String string5,
				String string6) {
			// TODO Auto-generated constructor stub
		}


		public int getDoctorId() {
		return doctorId;
	}


	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}


	public String getDoctorName() {
		return doctorName;
	}


	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}


	public LocalTime getDoctorConsultationTime() {
		return doctorConsultationTime;
	}


	public void setDoctorConsultationTime(LocalTime doctorConsultationTime) {
		this.doctorConsultationTime = doctorConsultationTime;
	}


	public long getDoctorMobile() {
		return doctorMobile;
	}


	public void setDoctorMobile(long doctorMobile) {
		this.doctorMobile = doctorMobile;
	}


	public String getDoctorEmail() {
		return doctorEmail;
	}


	public void setDoctorEmail(String doctorEmail) {
		this.doctorEmail = doctorEmail;
	}


	public String getDoctorUsername() {
		return doctorUsername;
	}


	public void setDoctorUsername(String doctorUsername) {
		this.doctorUsername = doctorUsername;
	}


	public String getDoctorPassword() {
		return doctorPassword;
	}


	public void setDoctorPassword(String doctorPassword) {
		this.doctorPassword = doctorPassword;
	}


	public String getDoctorAddress() {
		return doctorAddress;
	}


	public void setDoctorAddress(String doctorAddress) {
		this.doctorAddress = doctorAddress;
	}

	public List<Appointment> getAppointment() {
		return appointment;
	}


	public void setAppointment(List<Appointment> appointment) {
		this.appointment = appointment;
	}


	

//		@Override
//	public String toString() {
//		return "Doctor [doctorId=" + doctorId + ", doctorName=" + doctorName + ", doctorConsultationTime="
//				+ doctorConsultationTime + ", doctorMobile=" + doctorMobile + ", doctorEmail=" + doctorEmail
//				+ ", doctorUsername=" + doctorUsername + ", doctorPassword=" + doctorPassword + ", doctorAddress="
//				+ doctorAddress + ", test=" + test + "]";
//	}
		

	
	
}
