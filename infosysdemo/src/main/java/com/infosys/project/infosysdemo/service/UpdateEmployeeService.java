package com.infosys.project.infosysdemo.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.project.infosysdemo.dao.EmployeeEntity;
import com.infosys.project.infosysdemo.repository.EmployeeRepository;
import com.infosys.project.infosysdemo.vo.EmployeeOutputVO;
import com.infosys.project.infosysdemo.vo.UpdateEmployeeInputVO;

@Service
public class UpdateEmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public EmployeeOutputVO updateAllDetails(Long id, UpdateEmployeeInputVO employeeInputVO) throws Exception {
		EmployeeEntity employeeEntity = new EmployeeEntity();
		EmployeeOutputVO employeeOutputVO = new EmployeeOutputVO();
		UUID uuid = UUID.randomUUID();
		Optional<EmployeeEntity> employeeEntityFindId = employeeRepository.findById(id);
		if (employeeEntityFindId != null) {

			employeeEntity.setId(id);
			employeeEntity.setDepartment(employeeInputVO.getDepartment());
			employeeEntity.setEmail(employeeInputVO.getEmail());
			employeeEntity.setName(employeeInputVO.getName());
			employeeEntity.setSalary(employeeInputVO.getSalary());

			EmployeeEntity employeeEntit = employeeRepository.save(employeeEntity);

			employeeOutputVO.setTransactionId(uuid.toString());
			employeeOutputVO.setId(employeeEntit.getId());
			employeeOutputVO.setName(employeeEntit.getName());
			employeeOutputVO.setDepartment(employeeEntit.getDepartment());
			employeeOutputVO.setEmail(employeeEntit.getEmail());
			employeeOutputVO.setSalary(employeeEntit.getSalary());

			return employeeOutputVO;
		} else {
			throw new Exception();
		}

	}

	public String deleteEmployeeByID(Long id) throws Exception {
		try {
			employeeRepository.deleteById(id);
			return "Employee Deleted Succesfully";
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

}
