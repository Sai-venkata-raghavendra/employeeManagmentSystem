package com.infosys.project.infosysdemo.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.project.infosysdemo.dao.EmployeeEntity;
import com.infosys.project.infosysdemo.exception.EmployeeNotFoundException;
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
			EmployeeEntity eoutEntity = employeeRepository.save(employeeEntity);
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
		} else {
			throw new EmployeeNotFoundException("Employee Id is not Present in DataBase Please provide a valid Id");
		}

	}

	public String deleteEmployeeByID(Long id) throws EmployeeNotFoundException {
		employeeRepository.deleteById(id);
		return "Employee Deleted Succesfully";
	}

}
