package com.cg.service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.dto.Patient;
import com.cg.dto.Report;
import com.cg.dto.Spectacles;
import com.cg.exceptions.PatientIdFoundNotException;
import com.cg.exceptions.ReportIdNotFoundException;
import com.cg.repository.IPatientRepository;
import com.cg.repository.IReportRepository;
@Service
public class ReportServiceImpl implements IReportService{
	@Autowired
	private IReportRepository reportRepo;
	@Autowired
	private IPatientRepository patientRepo;
	@Override
	public Report addReport(Report report, int patientId) {
		Patient patient=patientRepo.findById(patientId).get();
		report.setPatient(patient);
		reportRepo.save(report);
		return report;
	}
	@Override
	public Report updateReport(Report reports) throws ReportIdNotFoundException  {
		Report report=reportRepo.findById(reports.getReportId()).orElseThrow(()->new ReportIdNotFoundException("Invalid Report for this Id: "+reports.getReportId()));
		report.setDateOfReport(report.getDateOfReport());
		report.setDescriptionOfReport(report.getDescriptionOfReport());
		report.setVisualAcuity(report.getVisualAcuity());
		report.setVisualAcuityForNear(report.getVisualAcuityForNear());
		report.setVisualAcuityForDistance(report.getVisualAcuityForDistance());
		return reportRepo.saveAndFlush(reports);
	}

	@Override
	public Report removeReport(int reportId) throws ReportIdNotFoundException {
		Report r=reportRepo.findById(reportId).orElseThrow(()->new ReportIdNotFoundException("Invalid Report for this Id: "+reportId));
		reportRepo.deleteById(reportId);
		return r;
	}

	@Override
	public Report viewReport(int reportId, int patientId) throws ReportIdNotFoundException, PatientIdFoundNotException {
		Report r=reportRepo.findById(reportId).orElseThrow(()->new ReportIdNotFoundException("Invalid Report for this Id: "+reportId));
		if(r.getPatient().getPatientId()==patientId) {
			return r;
		}
		throw new PatientIdFoundNotException("No Patient Found with id: "+patientId);
	}

	@Override
	public List<Report> viewAllReport(LocalDate date) {
		List<Report> listRep=reportRepo.findAll();
		List<Report> list=new ArrayList<Report>();
		for(Report r:listRep) {
			if(r.getDateOfReport().isEqual(date)) {
				list.add(r);
			}
		}
		return list;
	}
	@Override
	public List<Spectacles> viewSpetacles() {
		List<Report> listRep=reportRepo.findAll();
		List<Spectacles> list=new ArrayList<Spectacles>();
		for(Report r:listRep) {
			if(r.getSpectacles()!=null) {
				list.add(r.getSpectacles());
			}
		}
		return list;
	}

	
}
