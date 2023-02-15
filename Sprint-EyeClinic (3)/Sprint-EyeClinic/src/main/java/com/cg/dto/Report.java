package com.cg.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Report implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reportId;
	@DateTimeFormat(style = "yyyy-MM-dd")
	private LocalDate dateOfReport;
	private String descriptionOfReport;
	private String visualAcuity;
	private String visualAcuityForNear;
	private String visualAcuityForDistance;
//	@JsonBackReference
	 @OneToOne(cascade=CascadeType.ALL)
	 @JoinColumn(name = "patient_id",referencedColumnName = "patientId")
	 private Patient patient; 
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "typeOfTest", referencedColumnName = "testType")
	private Test test;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="spectacles_id",referencedColumnName = "spectaclesId")
	private Spectacles spectacles;
	public Report() {
		// TODO Auto-generated constructor stub
	}
	public Report(int i, int j, String string, String string2, String string3, String string4) {
		// TODO Auto-generated constructor stub
	}

	public void setReportId(int reportId) {
		this.reportId = reportId;
	}

	public LocalDate getDateOfReport() {
		return dateOfReport;
	}

	public void setDateOfReport(LocalDate dateOfReport) {
		this.dateOfReport = dateOfReport;
	}

	public String getDescriptionOfReport() {
		return descriptionOfReport;
	}

	public void setDescriptionOfReport(String descriptionOfReport) {
		this.descriptionOfReport = descriptionOfReport;
	}

	public String getVisualAcuity() {
		return visualAcuity;
	}

	public void setVisualAcuity(String visualAcuity) {
		this.visualAcuity = visualAcuity;
	}

	public String getVisualAcuityForNear() {
		return visualAcuityForNear;
	}

	public void setVisualAcuityForNear(String visualAcuityForNear) {
		this.visualAcuityForNear = visualAcuityForNear;
	}

	public String getVisualAcuityForDistance() {
		return visualAcuityForDistance;
	}

	public void setVisualAcuityForDistance(String visualAcuityForDistance) {
		this.visualAcuityForDistance = visualAcuityForDistance;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public Spectacles getSpectacles() {
		return spectacles;
	}

	public void setSpectacles(Spectacles spectacles) {
		this.spectacles = spectacles;
	}
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public int getReportId() {
		return reportId;
	}

		

	}
