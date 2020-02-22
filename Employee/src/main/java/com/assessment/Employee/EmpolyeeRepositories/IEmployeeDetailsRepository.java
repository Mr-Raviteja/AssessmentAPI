package com.assessment.Employee.EmpolyeeRepositories;

import com.assessment.Employee.EmpolyeeEntities.EmployeeDetailsEntity;

import java.util.List;

public interface IEmployeeDetailsRepository {

    String CreateEmployee(EmployeeDetailsEntity employeeDetailsEntity);

    EmployeeDetailsEntity getEmployeeById(int id);

    List<EmployeeDetailsEntity> getAllEmployees();

    String updateEmployeeDetails(EmployeeDetailsEntity employeeDetailsEntity);

    String deleteEmployeeById(int id);
}
