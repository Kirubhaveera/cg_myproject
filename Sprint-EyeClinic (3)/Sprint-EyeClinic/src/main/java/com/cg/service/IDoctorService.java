package com.cg.service;
import java.util.List;

import com.cg.dto.Appointment;
import com.cg.dto.Doctor;
import com.cg.dto.Test;
import com.cg.exceptions.DoctorIdNotFoundException;

public interface IDoctorService {
	Doctor addDoctor(Doctor doctor);
	Doctor updateDoctor(Doctor doctor) throws DoctorIdNotFoundException;
	Doctor deleteDoctor(int doctorId) throws DoctorIdNotFoundException;
	Doctor viewDoctor(int doctorId) throws DoctorIdNotFoundException;
	List<Doctor> viewDoctorsList();
    List<Appointment> viewAppointments();
	Test createTest(int doctorId, Test test);
}
