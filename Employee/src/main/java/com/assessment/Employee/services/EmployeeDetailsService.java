package com.assessment.Employee.services;


import com.assessment.Employee.entities.EmployeeDetailsEntity;
import com.assessment.Employee.repositories.IEmployeeDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class EmployeeDetailsService {

    @Autowired
    IEmployeeDetailsRepository iEmployeeDetailsRepository;

    public EmployeeDetailsEntity createOrUpdateEmployee(EmployeeDetailsEntity employeeDetailsEntity, Long empId) {

        if (null == empId) {
            iEmployeeDetailsRepository.saveOrupdateEmployeeDetails(employeeDetailsEntity);
            return employeeDetailsEntity;
        } else {
            EmployeeDetailsEntity employeeDetailsEntity1 = iEmployeeDetailsRepository.getEmployeeById(empId);

            employeeDetailsEntity1.setFirstName(employeeDetailsEntity.getFirstName());
            employeeDetailsEntity1.setLastName(employeeDetailsEntity.getLastName());
            employeeDetailsEntity1.setMobile(employeeDetailsEntity.getMobile());
            employeeDetailsEntity1.setEmailAddress(employeeDetailsEntity.getEmailAddress());
            employeeDetailsEntity1.setCity(employeeDetailsEntity.getCity());
            employeeDetailsEntity1.setCountry(employeeDetailsEntity.getCountry());
            employeeDetailsEntity1.setPostCode(employeeDetailsEntity.getPostCode());
            iEmployeeDetailsRepository.saveOrupdateEmployeeDetails(employeeDetailsEntity1);

            return iEmployeeDetailsRepository.getEmployeeById(employeeDetailsEntity1.getEmpId());
        }
    }


    public EmployeeDetailsEntity getEmployeeDetailsById(Long empId) throws Exception {

        EmployeeDetailsEntity employeeDetailsEntity = iEmployeeDetailsRepository.getEmployeeById(empId);
        return employeeDetailsEntity;
    }

    public void deleteEmployeebyId(Long empId) {
        EmployeeDetailsEntity employeeDetailsEntity = iEmployeeDetailsRepository.getEmployeeById(empId);
        iEmployeeDetailsRepository.deleteEmployeeById(employeeDetailsEntity);
    }

    public List<EmployeeDetailsEntity> getAllEmployess() {
        List<EmployeeDetailsEntity> employeeDetailsEntityList = iEmployeeDetailsRepository.getAllEmployees();
        if (employeeDetailsEntityList.size() > 0) {
            return employeeDetailsEntityList;
        } else {
            return new ArrayList<EmployeeDetailsEntity>();
        }
    }
}
