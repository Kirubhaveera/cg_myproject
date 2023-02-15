package com.cg.dto;
import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
public class Test implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int testId;
	private String testName;
	private String testType;
	private String testDescription;
	private double testCost;
	
//	@OneToOne(mappedBy = "test")
//	 private Spectacles spectacles;

    @ManyToOne(cascade=CascadeType.ALL)
   @JoinColumn(name="doctorId")
    private Doctor doctor;
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;	}
	public int getTestId() {
		return testId;
	}
	public void setTestId(int testId) {
		this.testId = testId;
	}
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	public String getTestType() {
		return testType;
	}
	public void setTestType(String testType) {
		this.testType = testType;
	}
	public String getTestDescription() {
		return testDescription;
	}
	public void setTestDescription(String testDescription) {
		this.testDescription = testDescription;
	}
	public double getTestCost() {
		return testCost;
	}
	public void setTestCost(double testCost) {
		this.testCost = testCost;
	}
	
//	public Spectacles getSpectacles() {
//		return spectacles;
//	}
//	public void setSpectacles(Spectacles spectacles) {
//		this.spectacles = spectacles;
//	}
	//overriding toString Method
	@Override
	public String toString() {
		return "Test [testId=" + testId + ", testName=" + testName + ", testType=" + testType + ", testDescription="
				+ testDescription + ", testCost=" + testCost + "]";
	}
	
	
}
