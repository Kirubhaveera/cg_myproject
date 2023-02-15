package com.cg.SprintEyeClinic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.dto.Doctor;
import com.cg.repository.IDoctorRepository;
import com.cg.service.DoctorServiceImpl;

@SpringBootTest
class SprintEyeClinicApplicationTests {
	@InjectMocks
	DoctorServiceImpl service1;
	@Mock
	IDoctorRepository rep1;
	@Test
	void contextLoads() {
	}
@Test
void TestDoctor(){
	Doctor doctor=new Doctor(123,"anu","09:09", 98765,"anu@gmail.com", "anu123", "123ac","chennai" );
Mockito.when(rep1.findById(123)).thenReturn(Optional.of(doctor));
Doctor doctor1=service1.viewDoctor(123);
assertEquals(doctor.getDoctorName(),doctor1.getDoctorName());
}
@Test
void testViewAllDoctors() {
	Doctor doctor1=new Doctor(1,"neha","09:45", 99765,"neha@gmail.com", "neha123", "123neha","chennai" );
	Doctor doctor2=new Doctor(2,"anusha","11:45", 99745,"anusha@gmail.com", "anu123", "123anu","chennai" );
    List<Doctor> list=new ArrayList<Doctor>();
    list.add(doctor1);list.add(doctor2);
    Mockito.when(rep1.findAll()).thenReturn(list);
    List<Doctor> list2=service1.viewDoctorsList();
    assertEquals(list.size(), list2.size()); 
}

@Test
void testDeleteDoctorById() {
	Doctor d=new Doctor(1,"neha","09:45", 99765,"neha@gmail.com", "neha123", "123neha","chennai" );
	Mockito.when(rep1.findById(1)).thenReturn(Optional.of(d));
	service1.deleteDoctor(1);
}
}


