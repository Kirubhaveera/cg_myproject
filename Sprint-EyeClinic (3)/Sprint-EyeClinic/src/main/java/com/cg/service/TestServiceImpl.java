package com.cg.service;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cg.dto.Doctor;
import com.cg.dto.Test;
import com.cg.exceptions.TestIdNotFoundException;
import com.cg.repository.IDoctorRepository;
import com.cg.repository.ITestRepository;

@Component
@Transactional
public class TestServiceImpl implements ITestService{
	@Autowired
	private ITestRepository testRepo;
	@Override
	public Test addTest(Test test) {
		return testRepo.saveAndFlush(test);
	}
	@Override
	public Test updateTest(Test tests) throws TestIdNotFoundException{
		Test test= testRepo.findById(tests.getTestId()).orElseThrow(()->new TestIdNotFoundException("Test not found for the Id: "+ tests.getTestId()));
		test.setTestName(test.getTestName());		
		test.setTestType(test.getTestType());
		test.setTestDescription(test.getTestDescription());
		test.setTestCost(test.getTestCost());
		return testRepo.saveAndFlush(tests);
	}
	@Override
	public Test removeTest(int testId) throws TestIdNotFoundException {
		Test test= testRepo.findById(testId).orElseThrow(()->new TestIdNotFoundException("Test not found for the Id: "+ testId));
		testRepo.deleteById(testId);
		return test;
	}
	@Override
	public Test viewTest(int testId) throws TestIdNotFoundException {
		Test Test = testRepo.findById(testId).orElseThrow(()->new TestIdNotFoundException("Test not found for the Id: "+ testId));
		return Test;
	}
	@Override
	public List<Test> viewAllTests() {
		return testRepo.findAll();
	}

	}
	

