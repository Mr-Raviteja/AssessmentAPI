package com.assessment.Employee.EmployeeContollers;

import com.assessment.Employee.EmployeeServices.EmployeeDetailsService;
import com.assessment.Employee.EmpolyeeEntities.EmployeeDetailsEntity;
import com.assessment.Employee.EmpolyeeModels.EmployeeDetailsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeDetailsController {

    @Autowired
    EmployeeDetailsService employeeDetailsService;

    @PostMapping("/createEmp")
    public Boolean createEmp(@RequestBody EmployeeDetailsModel employeeDetailsModel) {
        return employeeDetailsService.createEmployee(employeeDetailsModel);
    }

    @GetMapping("/employees")
    public List<EmployeeDetailsEntity> get() {
        return employeeDetailsService.getAllEmployess();
    }

}
