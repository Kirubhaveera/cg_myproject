package com.cg.SprintEyeClinic;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import com.cg.dto.Report;
import com.cg.repository.IReportRepository;
import com.cg.service.ReportServiceImpl;

@SpringBootTest
public class ReportTest {
	@InjectMocks
	ReportServiceImpl service;
	@Mock
	IReportRepository rep;
	@Test
	void contextLoads() {
	}
	@Test
	void TestReport() {
		Report report=new Report(1,2,"2000-09-17","normal","abc","cba");
		Mockito.when(rep.findById(1)).thenReturn(Optional.of(report));
		Report report1=service.viewReport(1, 2);
		assertEquals(report.getDescriptionOfReport(),report1.getDescriptionOfReport());
		}
	@Test
	void TestRemoveReport() {
		Report r=new Report(1,2,"2000-09-17","normal","abc","cba");
		Mockito.when(rep.findById(1)).thenReturn(Optional.of(r));
		service.removeReport(1);
	}
	}

