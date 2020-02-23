package com.assessment.Employee.services;


import com.assessment.Employee.entities.EmployeeDetailsEntity;
import com.assessment.Employee.repositories.IEmployeeDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeDetailsService {

    @Autowired
    IEmployeeDetailsRepository iEmployeeDetailsRepository;

    public EmployeeDetailsEntity createOrUpdateEmployee(EmployeeDetailsEntity employeeDetailsEntity, Long empId) {

        if (null != empId) {
            iEmployeeDetailsRepository.saveOrupdateEmployeeDetails(employeeDetailsEntity);
            return employeeDetailsEntity;
        } else {
            iEmployeeDetailsRepository.saveOrupdateEmployeeDetails(employeeDetailsEntity);
            return employeeDetailsEntity;
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
