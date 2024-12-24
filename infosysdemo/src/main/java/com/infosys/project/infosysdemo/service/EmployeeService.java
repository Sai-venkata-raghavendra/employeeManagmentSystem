package com.infosys.project.infosysdemo.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.project.infosysdemo.dao.EmployeeEntity;
import com.infosys.project.infosysdemo.exception.EmployeeNotFoundException;
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
		if (eoutEntity != null) {
			if (eoutEntity.getId() != null) {
				employeeOutputVO.setId(eoutEntity.getId());
			}
			if (uuid != null) {
				employeeOutputVO.setTransactionId(uuid.toString());
			}
			if (eoutEntity.getName() != null) {
				employeeOutputVO.setName(eoutEntity.getName());
			}
			if (eoutEntity.getDepartment() != null) {
				employeeOutputVO.setDepartment(eoutEntity.getDepartment());
			}
			if (eoutEntity.getEmail() != null) {
				employeeOutputVO.setEmail(eoutEntity.getEmail());
			}
			employeeOutputVO.setSalary(eoutEntity.getSalary());
		}
		return employeeOutputVO;
	}

	public List<EmployeeEntity> getAllDetails() throws EmployeeNotFoundException {
		List<EmployeeEntity> empEntity = employeeRepository.findAll();
		return empEntity;
	}

	public EmployeeOutputVO getDetailsById(Long id) throws EmployeeNotFoundException {

		UUID uuid = UUID.randomUUID();
		EmployeeEntity eoutEntity = employeeRepository.findById(id).get();
		if (eoutEntity != null) {
			if (eoutEntity.getId() != null) {
				employeeOutputVO.setId(eoutEntity.getId());
			}
			if (uuid != null) {
				employeeOutputVO.setTransactionId(uuid.toString());
			}
			if (eoutEntity.getName() != null) {
				employeeOutputVO.setName(eoutEntity.getName());
			}
			if (eoutEntity.getDepartment() != null) {
				employeeOutputVO.setDepartment(eoutEntity.getDepartment());
			}
			if (eoutEntity.getEmail() != null) {
				employeeOutputVO.setEmail(eoutEntity.getEmail());
			}
			employeeOutputVO.setSalary(eoutEntity.getSalary());
			return employeeOutputVO;
		} else {
			throw new EmployeeNotFoundException("Employee Id is not present in Database");
		}
	}

}
