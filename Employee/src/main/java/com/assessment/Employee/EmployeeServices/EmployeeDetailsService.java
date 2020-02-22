package com.assessment.Employee.EmployeeServices;


import com.assessment.Employee.EmpolyeeRepositories.IEmployeeDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeDetailsService {

    @Autowired
    IEmployeeDetailsRepository iEmployeeDetailsRepository;


}
