package com.cg.service;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cg.dto.Appointment;
import com.cg.dto.Doctor;
import com.cg.dto.Test;
import com.cg.exceptions.DoctorIdNotFoundException;
import com.cg.repository.IDoctorRepository;
import com.cg.repository.ITestRepository;
@Component
@Transactional

@Service

public class DoctorServiceImpl implements IDoctorService{
	@Autowired
	private IDoctorRepository docRepo;
	@Autowired
	private ITestRepository testRepo;
	@Override
	public Doctor addDoctor(Doctor doctor) {
		return docRepo.saveAndFlush(doctor);
	}

	@Override
	public Doctor updateDoctor(Doctor doctors)  throws DoctorIdNotFoundException{
		Doctor doctor =docRepo.findById(doctors.getDoctorId()).orElseThrow(()->new DoctorIdNotFoundException("Invalid Doctor for the Id: "+ doctors.getDoctorId()));
		doctor.setDoctorName(doctor.getDoctorName());
		doctor.setDoctorMobile(doctor.getDoctorMobile());
		doctor.setDoctorEmail(doctor.getDoctorEmail());
		doctor.setDoctorConsultationTime(doctor.getDoctorConsultationTime());
		doctor.setDoctorUsername(doctor.getDoctorUsername());
		doctor.setDoctorPassword(doctor.getDoctorPassword());
		doctor.setDoctorAddress(doctor.getDoctorAddress());
//		doctor.setTest(doctor.getTest());
		return docRepo.saveAndFlush(doctors);
	}
	@Override
	public Doctor deleteDoctor(int doctorId) throws DoctorIdNotFoundException{
		Doctor d =docRepo.findById(doctorId).orElseThrow(()->new DoctorIdNotFoundException("Invalid Doctor for the Id: "+ doctorId));
		docRepo.deleteById(doctorId);
		return d;
	}
	@Override
	public Doctor viewDoctor(int doctorId)  throws DoctorIdNotFoundException{
		Doctor d =docRepo.findById(doctorId).orElseThrow(()->new DoctorIdNotFoundException("Invalid Doctor for the Id: "+ doctorId));
		return d;
	}

	@Override
	public List<Doctor> viewDoctorsList() {
		return docRepo.findAll();
	}
	@Override
	public List<Appointment> viewAppointments() {
		List<Doctor> listDoc=docRepo.findAll();
		List<Appointment> list=new ArrayList<Appointment>();
		for(Doctor d:listDoc) {
			for(Appointment a:d.getAppointment()) {
				list.add(a);
			}
		}
		return list;
	}
	@Override
	public Test createTest(int doctorId, Test test) {
		Doctor d=docRepo.findById(doctorId).get();
		if(d!=null) {
			
			test.setDoctor(d);
			test=testRepo.save(test);
			
		}
		return test;
		
	}
	
}
