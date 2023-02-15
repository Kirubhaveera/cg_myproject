package com.cg.service;
import java.time.LocalDate;
import java.util.List;

import com.cg.dto.Report;
import com.cg.dto.Spectacles;
import com.cg.exceptions.PatientIdFoundNotException;
import com.cg.exceptions.ReportIdNotFoundException;

public interface IReportService {
	Report addReport(Report report,int patientId);
	Report updateReport(Report report) throws ReportIdNotFoundException;
	Report removeReport(int reportId) throws ReportIdNotFoundException;
	Report viewReport(int reportId, int patientId) throws ReportIdNotFoundException,PatientIdFoundNotException;
	List<Report> viewAllReport(LocalDate date);
	List<Spectacles> viewSpetacles();
	//Report addReportByPatientId();

	
}
