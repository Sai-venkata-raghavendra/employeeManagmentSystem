package com.infosys.project.infosysdemo.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.infosys.project.infosysdemo.dao.EmployeeEntity;

@DataJpaTest
public class EmployeeUnitTestRepository {

	@Autowired
	private EmployeeRepository employeeRepo;

	EmployeeEntity employeeEn = new EmployeeEntity();

	@BeforeEach
	public void init() {
		employeeEn.setId(1L);
		employeeEn.setDepartment("Software");
		employeeEn.setEmail("sai@gmail.com");
		employeeEn.setName("Raghavendra");
		employeeEn.setSalary(90000);
	}

	@Test
	@DisplayName("SaveEmployees")
	public void saveEmployees() {
		EmployeeEntity eout = employeeRepo.save(employeeEn);
		assertNotNull(eout);
		assertThat(eout.getId()).isNotEqualTo(null);

	}

	@Test
	@DisplayName("FindEmployeesData")
	public void findEmployees() {
		List<EmployeeEntity> eout = employeeRepo.findAll();
		assertNotNull(eout);
		assertEquals(1, eout.size());
	}
}
