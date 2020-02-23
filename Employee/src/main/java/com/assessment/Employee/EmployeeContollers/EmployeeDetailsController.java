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

    @RequestMapping(value = "/saveEmp", method = RequestMethod.POST)
    public ResponseEntity<EmployeeDetailsEntity> createOrUpdateEmp(@RequestBody EmployeeDetailsEntity employeeDetailsEntity) {
        EmployeeDetailsEntity emp = employeeDetailsService.createOrUpdateEmployee(employeeDetailsEntity, null);
        return new ResponseEntity<EmployeeDetailsEntity>(emp, new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(value = "/updateEmp/{empId}", method = RequestMethod.PUT)
    public ResponseEntity<EmployeeDetailsEntity> updateEmployee(@RequestBody EmployeeDetailsEntity employeeDetailsEntity, @PathVariable Long empId) {
        EmployeeDetailsEntity emp = employeeDetailsService.createOrUpdateEmployee(employeeDetailsEntity, empId);
        return new ResponseEntity<EmployeeDetailsEntity>(emp, new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(value = "/getEmp/{empId}", method = RequestMethod.GET)
    public EmployeeDetailsEntity getEmployeeById(@PathVariable Long empId)
            throws Exception {
        EmployeeDetailsEntity employeeDetailsEntity = employeeDetailsService.getEmployeeDetailsById(empId);
        if (null == employeeDetailsEntity)
            throw new Exception("Could not find employee with Id " + employeeDetailsEntity.getEmpId());
        return employeeDetailsEntity;
    }

    @RequestMapping(value = "/deleteEmp/{empId}", method = RequestMethod.DELETE)
    public String deleteEmployee(@PathVariable Long empId) throws Exception {
        EmployeeDetailsEntity employeeDetailsEntity = employeeDetailsService.getEmployeeDetailsById(empId);
        if (null == employeeDetailsEntity)
            throw new Exception("Could not find employee with Id " + employeeDetailsEntity.getEmpId());

        employeeDetailsService.deleteEmployeebyId(empId);
        return "deleted Successfull";
    }

    @RequestMapping(value = "/getAllEmp", method = RequestMethod.GET)
    public ResponseEntity<List<EmployeeDetailsEntity>> getAllEmployees() {
        List<EmployeeDetailsEntity> empList = employeeDetailsService.getAllEmployess();
        return new ResponseEntity<List<EmployeeDetailsEntity>>(empList, new HttpHeaders(), HttpStatus.OK);
    }

}
