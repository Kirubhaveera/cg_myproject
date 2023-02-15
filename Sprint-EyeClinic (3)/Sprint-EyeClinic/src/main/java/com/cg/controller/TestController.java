package com.cg.controller;
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

import com.cg.dto.Test;
import com.cg.exceptions.TestIdNotFoundException;
import com.cg.service.ITestService;

@RestController
@RequestMapping("tests/")
public class TestController {
	@Autowired
	 private ITestService TestService;
    @PostMapping("addTest")
	public ResponseEntity<Test> addTest(@RequestBody Test test){
		return new ResponseEntity<Test>(TestService.addTest(test),HttpStatus.OK);
	}
    @PutMapping("updateTest")
	public ResponseEntity<Test> updateTest(@RequestBody Test test) throws TestIdNotFoundException{
   	return new ResponseEntity<Test>(TestService.updateTest(test),HttpStatus.OK);
	}
    @DeleteMapping("deleteTest/{testId}")
	public ResponseEntity<Test> removeTest(@PathVariable("testId") int testId) throws TestIdNotFoundException{
		return new ResponseEntity<Test>(TestService.removeTest(testId),HttpStatus.OK);
	}
    @GetMapping("viewTestWithId/{testId}")
	public ResponseEntity<Test> viewTest(@PathVariable("testId") int testId) throws TestIdNotFoundException{
		return new ResponseEntity<Test>(TestService.viewTest(testId),HttpStatus.OK);
	}	 
    @GetMapping("viewAllTests")
	public List<Test> viewAllTests(){
		return TestService.viewAllTests();
		
	}
    
}
