package com.assessment.Employee.EmployeeServices;


import com.assessment.Employee.EmpolyeeEntities.EmployeeDetailsEntity;
import com.assessment.Employee.EmpolyeeModels.EmployeeDetailsModel;
import com.assessment.Employee.EmpolyeeRepositories.IEmployeeDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeDetailsService {

    @Autowired
    IEmployeeDetailsRepository iEmployeeDetailsRepository;

    public Boolean createEmployee(EmployeeDetailsModel employeeDetailsModel) {
        EmployeeDetailsEntity empEntity = new EmployeeDetailsEntity();
        empEntity.setFirstName(employeeDetailsModel.getFirstName());

        iEmployeeDetailsRepository.CreateEmployee(empEntity);
        return true;
    }

    public List<EmployeeDetailsEntity> getAllEmployess() {
        List<EmployeeDetailsEntity> employeeDetailsEntityList = iEmployeeDetailsRepository.getAllEmployees();
        return employeeDetailsEntityList;
    }
}
