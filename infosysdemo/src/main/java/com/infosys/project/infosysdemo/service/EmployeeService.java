package com.infosys.project.infosysdemo.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.project.infosysdemo.dao.EmployeeEntity;
import com.infosys.project.infosysdemo.repository.EmployeeRepository;
import com.infosys.project.infosysdemo.vo.EmployeeInputVO;
import com.infosys.project.infosysdemo.vo.EmployeeOutputVO;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	EmployeeOutputVO employeeOutputVO = new EmployeeOutputVO();

	public EmployeeOutputVO saveEmployeeDetails(EmployeeInputVO employeeInputVO) {
		EmployeeEntity employeeEntity = new EmployeeEntity();
		employeeEntity.setDepartment(employeeInputVO.getDepartment());
		employeeEntity.setEmail(employeeInputVO.getEmail());
		employeeEntity.setName(employeeInputVO.getName());
		employeeEntity.setSalary(employeeInputVO.getSalary());
		EmployeeEntity eoutEntity = employeeRepository.save(employeeEntity);
		UUID uuid = UUID.randomUUID();
		employeeOutputVO.setTransactionId(uuid.toString());
		employeeOutputVO.setId(eoutEntity.getId());
		employeeOutputVO.setName(eoutEntity.getName());
		employeeOutputVO.setDepartment(eoutEntity.getDepartment());
		employeeOutputVO.setEmail(eoutEntity.getEmail());
		employeeOutputVO.setSalary(eoutEntity.getSalary());
		return employeeOutputVO;
	}

	public List<EmployeeEntity> getAllDetails() {
		List<EmployeeEntity> empEntity = employeeRepository.findAll();
		try {
			return empEntity;
		} catch (Exception e) {
			throw new NullPointerException("As employee data base id empty" + e.getMessage());
		}

	}

	public EmployeeOutputVO getDetailsById(Long id) {

		UUID uuid = UUID.randomUUID();
		EmployeeEntity eoutEntity = employeeRepository.findById(id).get();
		employeeOutputVO.setId(eoutEntity.getId());
		employeeOutputVO.setTransactionId(uuid.toString());
		employeeOutputVO.setName(eoutEntity.getName());
		employeeOutputVO.setDepartment(eoutEntity.getDepartment());
		employeeOutputVO.setEmail(eoutEntity.getEmail());
		employeeOutputVO.setSalary(eoutEntity.getSalary());
		return employeeOutputVO;
	}

}
