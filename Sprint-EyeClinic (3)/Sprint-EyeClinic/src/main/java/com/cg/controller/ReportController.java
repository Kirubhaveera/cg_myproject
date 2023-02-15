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

import com.cg.dto.Report;
import com.cg.dto.Spectacles;
import com.cg.service.IReportService;
@RestController
@RequestMapping("reports/")
public class ReportController {
	@Autowired
	private IReportService ReportService;
	@PostMapping("addReport/{patientId}")
	public ResponseEntity<Report> addReport(@RequestBody Report report, @PathVariable int patientId){
		return new ResponseEntity<Report>(ReportService.addReport(report,patientId),HttpStatus.OK);
	}
    @PutMapping("updateReport")
	public ResponseEntity<Report> updateReport(@RequestBody Report report){
		return new ResponseEntity<Report>(ReportService.updateReport(report),HttpStatus.OK);
	}
	@DeleteMapping("deleteReportWithId/{reportId}")
	public ResponseEntity<Report> removeReport(@PathVariable("reportId") int reportId){
		return new ResponseEntity<Report>(ReportService.removeReport(reportId),HttpStatus.OK);
	}
	@GetMapping("viewReport/{reportId}/{patientId}")
	public ResponseEntity<Report> viewReport(@PathVariable("reportId") int reportId,@PathVariable("patientId") int patientId){
		return new ResponseEntity<Report>(ReportService.viewReport(reportId,patientId),HttpStatus.OK);
	}
	@GetMapping("viewReportsWithDate/{date}")
	public List<Report> viewAllReport(@PathVariable("date") String date){
		LocalDate localDate = LocalDate.parse(date,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		return ReportService.viewAllReport(localDate);
	}
	@GetMapping("viewSpectacles")
	public List<Spectacles> viewSpetacles(){
		return ReportService.viewSpetacles();
	}
}
