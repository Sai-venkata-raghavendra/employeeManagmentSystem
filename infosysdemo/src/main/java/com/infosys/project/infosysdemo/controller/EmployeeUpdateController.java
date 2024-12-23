package com.infosys.project.infosysdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.project.infosysdemo.service.UpdateEmployeeService;
import com.infosys.project.infosysdemo.vo.EmployeeOutputVO;
import com.infosys.project.infosysdemo.vo.UpdateEmployeeInputVO;

@RestController
@RequestMapping("/employeeUpdate")
public class EmployeeUpdateController {

	@Autowired
	private UpdateEmployeeService updateEmployeeService;

	@RequestMapping(value = "/empdetails", method = RequestMethod.PUT)
	public ResponseEntity<EmployeeOutputVO> updateDetails(@RequestParam(value = "id") Long id,
			@RequestBody UpdateEmployeeInputVO employeeInputVO) throws Exception {

		EmployeeOutputVO employeeOutputVO = updateEmployeeService.updateAllDetails(id, employeeInputVO);
		return new ResponseEntity<EmployeeOutputVO>(employeeOutputVO, HttpStatus.ACCEPTED);

	}

	@RequestMapping(value = "/deletEmployee", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteEmployee(@RequestParam(value = "id") Long id) throws Exception {
		String message = updateEmployeeService.deleteEmployeeByID(id);
		return new ResponseEntity<String>(message, HttpStatus.ACCEPTED);
	}
}
