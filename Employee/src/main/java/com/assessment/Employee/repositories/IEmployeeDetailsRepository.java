package com.assessment.Employee.repositories;

import com.assessment.Employee.entities.EmployeeDetailsEntity;

import java.util.List;

public interface IEmployeeDetailsRepository {


    EmployeeDetailsEntity getEmployeeById(Long id);

    List<EmployeeDetailsEntity> getAllEmployees();

    void saveOrupdateEmployeeDetails(EmployeeDetailsEntity employeeDetailsEntity);

    void deleteEmployeeById(EmployeeDetailsEntity employeeDetailsEntity);
}
