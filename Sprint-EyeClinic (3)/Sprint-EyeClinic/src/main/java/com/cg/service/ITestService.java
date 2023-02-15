package com.cg.service;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cg.dto.Test;
import com.cg.exceptions.TestIdNotFoundException;

public interface ITestService {
	Test addTest(Test test);
	Test updateTest(Test test) throws TestIdNotFoundException;
	Test removeTest(int testId) throws TestIdNotFoundException;
	Test viewTest(int testId) throws TestIdNotFoundException;
	List<Test> viewAllTests();
}
