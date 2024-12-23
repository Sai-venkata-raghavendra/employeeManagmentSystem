package com.infosys.project.infosysdemo.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.infosys.project.infosysdemo.service.EmployeeService;
import com.infosys.project.infosysdemo.vo.EmployeeInputVO;
import com.infosys.project.infosysdemo.vo.EmployeeOutputVO;

@WebMvcTest(EmployeeController.class)
public class EmployeeUnitTestController {

	@MockBean
	private EmployeeService employeeService;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	public void createEmployee() throws Exception {
		EmployeeInputVO employeeInputVO = new EmployeeInputVO();
		employeeInputVO.setDepartment("Software");
		employeeInputVO.setEmail("abc@gmaik.com");
		employeeInputVO.setName("abc");
		employeeInputVO.setSalary(90000);
		EmployeeOutputVO employeeOutputVO = new EmployeeOutputVO();
		employeeOutputVO.setDepartment(employeeInputVO.getDepartment());
		employeeOutputVO.setEmail(employeeInputVO.getEmail());
		employeeOutputVO.setId(1L);
		employeeOutputVO.setName(employeeInputVO.getName());
		employeeOutputVO.setSalary(90000);
		employeeOutputVO.setTransactionId("55fca1ef-4533-464f-9df2-5db3390db1a8");
		when(employeeService.saveEmployeeDetails(employeeInputVO)).thenReturn(employeeOutputVO);
		mockMvc.perform((post("/employees/saveData").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(employeeOutputVO))));
	}

	@Test
	public void getEmployee() throws Exception {
		EmployeeInputVO employeeInputVO = new EmployeeInputVO();
		employeeInputVO.setDepartment("Software");
		employeeInputVO.setEmail("abc@gmaik.com");
		employeeInputVO.setName("abc");
		employeeInputVO.setSalary(90000);
		EmployeeOutputVO employeeOutputVO = new EmployeeOutputVO();
		employeeOutputVO.setDepartment(employeeInputVO.getDepartment());
		employeeOutputVO.setEmail(employeeInputVO.getEmail());
		employeeOutputVO.setId(1L);
		employeeOutputVO.setName(employeeInputVO.getName());
		employeeOutputVO.setSalary(90000);
		employeeOutputVO.setTransactionId("55fca1ef-4533-464f-9df2-5db3390db1a8");
		when(employeeService.getDetailsById(2L)).thenReturn(employeeOutputVO);
		mockMvc.perform((get("/employees/getDetailsById", 2L).contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(employeeOutputVO))));
	}

	@Test
	public void getAllEmployee() throws Exception {
		EmployeeInputVO employeeInputVO = new EmployeeInputVO();
		employeeInputVO.setDepartment("Software");
		employeeInputVO.setEmail("abc@gmaik.com");
		employeeInputVO.setName("abc");
		employeeInputVO.setSalary(90000);
		List<EmployeeOutputVO> employeeOutputVO = new ArrayList<EmployeeOutputVO>();
		for (EmployeeOutputVO emps : employeeOutputVO) {
			emps.setDepartment(employeeInputVO.getDepartment());
			emps.setEmail(employeeInputVO.getEmail());
			emps.setId(1L);
			emps.setName(employeeInputVO.getName());
			emps.setSalary(90000);
			emps.setTransactionId("55fca1ef-4533-464f-9df2-5db3390db1a8");
		}

		when(employeeService.getDetailsById(2L)).thenReturn((EmployeeOutputVO) employeeOutputVO);
		mockMvc.perform((get("/employees/getAlldetails").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(employeeOutputVO))));
	}
}
