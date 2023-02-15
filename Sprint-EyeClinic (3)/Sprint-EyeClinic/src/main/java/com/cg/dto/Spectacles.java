package com.cg.dto;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Spectacles{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int spectaclesId;
	private String spectaclesNumber;
	private String spectaclesModel;
	private String spectaclesDescription;
	private double spectaclesCost;
//	
//	 @OneToOne
//	 @JoinColumn(name = "test_id")
//	 private Test test;
//	
	
	
	
//public Test getTest() {
//		return test;
//	}
//	public void setTest(Test test) {
//		this.test = test;
//	}
	//	@JsonManagedReference
//	@OneToOne(mappedBy = "report_id" ,cascade=CascadeType.ALL)
//	private Report report;
//	
//	public Report getReport() {
//		return report;
//	}
//	public void setReport(Report report) {
//		this.report = report;
//	}
	public int getSpectaclesId() {
		return spectaclesId;
	}
	public void setSpectaclesId(int spectaclesId) {
		this.spectaclesId = spectaclesId;
	}
	public String getSpectaclesModel() {
		return spectaclesModel;
	}
	public void setSpectaclesModel(String spectaclesModel) {
		this.spectaclesModel = spectaclesModel;
	}
	public String getSpectaclesDescription() {
		return spectaclesDescription;
	}
	public void setSpectaclesDescription(String spectaclesDescription) {
		this.spectaclesDescription = spectaclesDescription;
	}
	public double getSpectaclesCost() {
		return spectaclesCost;
	}
	public void setSpectaclesCost(double spectaclesCost) {
		this.spectaclesCost = spectaclesCost;
	}
	
	public String getSpectaclesNumber() {
		return spectaclesNumber;
	}
	public void setSpectaclesNumber(String spectaclesNumber) {
		this.spectaclesNumber = spectaclesNumber;
	}
	//overriding toString Method
	@Override
	public String toString() {
		return "Spectacles [spectaclesId=" + spectaclesId + ", spectaclesModel=" + spectaclesModel
				+ ", spectaclesDescription=" + spectaclesDescription + ", spectaclesCost=" + spectaclesCost + "]";
	}
	
}
