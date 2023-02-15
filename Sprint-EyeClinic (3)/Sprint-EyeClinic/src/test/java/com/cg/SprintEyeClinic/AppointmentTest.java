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

import com.cg.dto.Appointment;
import com.cg.repository.IAppointmentRepository;
import com.cg.service.AppointmentServiceImpl;

@SpringBootTest
public class AppointmentTest {
	@InjectMocks
	AppointmentServiceImpl service;
	@Mock
	IAppointmentRepository rep;
	@Test
	void contextLoads() {
	}
	@Test
	void testAppointment() {
		Appointment apt=new Appointment(1,"2022-03-03","07:09",400);
	    Mockito.when(rep.findById(1)).thenReturn(Optional.of(apt));
	    Appointment appointment=service.viewAppointment(1);
	    assertEquals(apt.getDateOfAppointment(), appointment.getDateOfAppointment());
	}
	@Test
	void testViewAllAppointments() {
		Appointment appointment=new Appointment(1,"2022-03-03","07:09",400);
		Appointment appointment1=new Appointment(2,"2022-04-03","07:30",500);
		List<Appointment>list=new ArrayList<Appointment>();
	    list.add(appointment1);list.add(appointment);
	    Mockito.when(rep.findAll()).thenReturn(list);
	    List<Appointment> list2=service.viewAllAppointments();
	    assertEquals(list.size(), list2.size()); 
	}
	@Test
	void testDeleteAppointmentById() {
		Appointment apt=new Appointment(1,"2022-03-03","07:09",400);
		Mockito.when(rep.findById(1)).thenReturn(Optional.of(apt));
		service.cancelAppointment(1);
	}
}
