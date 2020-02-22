package com.assessment.Employee.EmployeeContollers;

import com.assessment.Employee.EmployeeServices.EmployeeDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EmployeeDetailsController {

    @Autowired
    EmployeeDetailsService employeeDetailsService;


}
