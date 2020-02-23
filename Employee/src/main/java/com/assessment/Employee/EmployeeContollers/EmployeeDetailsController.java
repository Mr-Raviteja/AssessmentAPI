package com.assessment.Employee.EmployeeContollers;

import com.assessment.Employee.EmployeeServices.EmployeeDetailsService;
import com.assessment.Employee.EmpolyeeEntities.EmployeeDetailsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeDetailsController {

    @Autowired
    EmployeeDetailsService employeeDetailsService;

    @PostMapping("/saveEmp")
    public ResponseEntity<EmployeeDetailsEntity> createOrUpdateEmp(@RequestBody EmployeeDetailsEntity employeeDetailsEntity) {
        EmployeeDetailsEntity emp = employeeDetailsService.createOrUpdateEmployee(employeeDetailsEntity);
        return new ResponseEntity<EmployeeDetailsEntity>(emp, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/getAllEmp")
    public ResponseEntity<List<EmployeeDetailsEntity>> getAllEmployees() {
        List<EmployeeDetailsEntity> empList = employeeDetailsService.getAllEmployess();
        return new ResponseEntity<List<EmployeeDetailsEntity>>(empList, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{empId}")
    public ResponseEntity<EmployeeDetailsEntity> getEmployeeById(@PathVariable("empId") Long empId)
            throws Exception {
        EmployeeDetailsEntity entity = employeeDetailsService.getEmployeeDetailsById(empId);

        return new ResponseEntity<EmployeeDetailsEntity>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/empId")
    public HttpStatus deleteEmployee(@PathVariable("empId") Long empId) throws Exception {
        boolean result = employeeDetailsService.deleteEmployeebyId(empId);
        return HttpStatus.FORBIDDEN;
    }

}
