package com.infosys.project.infosysdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.project.infosysdemo.dao.EmployeeEntity;
import com.infosys.project.infosysdemo.exception.EmployeeNotFoundException;
import com.infosys.project.infosysdemo.service.EmployeeService;
import com.infosys.project.infosysdemo.vo.EmployeeInputVO;
import com.infosys.project.infosysdemo.vo.EmployeeOutputVO;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/saveData", method = RequestMethod.POST)
	public ResponseEntity<EmployeeOutputVO> saveEmpDetails(@RequestBody EmployeeInputVO employeeInputVO) {
		EmployeeOutputVO employeeOutputVO = employeeService.saveEmployeeDetails(employeeInputVO);
		return new ResponseEntity<EmployeeOutputVO>(employeeOutputVO, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/getAlldetails", method = RequestMethod.GET)
	public ResponseEntity<List<EmployeeEntity>> getAllDetails() throws EmployeeNotFoundException {
		List<EmployeeEntity> employeeEntity = employeeService.getAllDetails();
		return new ResponseEntity<List<EmployeeEntity>>(employeeEntity, HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "/getDetailsById", method = RequestMethod.GET)
	public ResponseEntity<EmployeeOutputVO> getDetailsById(@RequestParam(value = "id") Long id) throws EmployeeNotFoundException {
		EmployeeOutputVO employeeOutputVO = employeeService.getDetailsById(id);
		return new ResponseEntity<EmployeeOutputVO>(employeeOutputVO, HttpStatus.ACCEPTED);
	}
	
	
}
