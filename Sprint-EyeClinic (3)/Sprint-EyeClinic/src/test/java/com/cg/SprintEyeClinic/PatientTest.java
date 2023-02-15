package com.cg.SprintEyeClinic;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.dto.Patient;
import com.cg.repository.IPatientRepository;
import com.cg.service.PatientServiceImpl;

@SpringBootTest
public class PatientTest {
	@InjectMocks
	PatientServiceImpl service;
	@Mock
	IPatientRepository rep;
	@Test
	void contextLoads() {
	}
	@Test
	void testPatient() {
		Patient p=new Patient(1,"abc",21,998765,"abc@gmail.com","pune","2000-12-12","abc123","1234ac");
		Mockito.when(rep.findById(1)).thenReturn(Optional.of(p));
		Patient patient=service.viewPatient(1);
		assertEquals(p.getPatientName(),patient.getPatientName());
		}
	@Test
	void testDeletePatientById() {
		Patient p=new Patient(1,"abc",21,998765,"abc@gmail.com","pune","2000-12-12","abc123","1234ac" );
		Mockito.when(rep.findById(1)).thenReturn(Optional.of(p));
		service.deletePatient(1);
	}
	@Test
	void testViewAllPatients() {
		Patient patient=new Patient(1,"neha","09:45", 99765,"neha@gmail.com", "neha123", "123neha","chennai" );
		Patient patient1=new Patient(2,"anusha","11:45", 99745,"anusha@gmail.com", "anu123", "123anu","chennai" );
	    List<Patient> list=new ArrayList<Patient>();
	    list.add(patient);list.add(patient1);
	    Mockito.when(rep.findAll()).thenReturn(list);
	    List<Patient> list2=service.viewPatientList();
	    assertEquals(list.size(), list2.size()); 
	}
}