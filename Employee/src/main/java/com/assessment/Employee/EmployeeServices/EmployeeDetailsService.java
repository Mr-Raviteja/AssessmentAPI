package com.assessment.Employee.EmployeeServices;


import com.assessment.Employee.EmpolyeeEntities.EmployeeDetailsEntity;
import com.assessment.Employee.EmpolyeeRepositories.IEmployeeDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class EmployeeDetailsService {

    @Autowired
    IEmployeeDetailsRepository iEmployeeDetailsRepository;

    public EmployeeDetailsEntity createOrUpdateEmployee(EmployeeDetailsEntity employeeDetailsEntity) {
        EmployeeDetailsEntity empEntity = iEmployeeDetailsRepository.getEmployeeById(employeeDetailsEntity.getEmpId());
        if (null != empEntity) {
            EmployeeDetailsEntity employeeDetailsEntity1 = new EmployeeDetailsEntity();
            employeeDetailsEntity1.setFirstName(employeeDetailsEntity.getFirstName());
            employeeDetailsEntity1.setLastName(employeeDetailsEntity.getLastName());
            employeeDetailsEntity1.setMobile(employeeDetailsEntity.getMobile());
            employeeDetailsEntity1.setEmailAddress(employeeDetailsEntity.getEmailAddress());
            employeeDetailsEntity1.setCity(employeeDetailsEntity.getCity());
            employeeDetailsEntity1.setCountry(employeeDetailsEntity.getCountry());
            employeeDetailsEntity1.setPostCode(employeeDetailsEntity.getPostCode());

            iEmployeeDetailsRepository.saveOrupdateEmployeeDetails(employeeDetailsEntity1);
            return empEntity;
        } else {
            iEmployeeDetailsRepository.saveOrupdateEmployeeDetails(employeeDetailsEntity);
            return empEntity;
        }
    }

    public List<EmployeeDetailsEntity> getAllEmployess() {
        List<EmployeeDetailsEntity> employeeDetailsEntityList = iEmployeeDetailsRepository.getAllEmployees();
        if (employeeDetailsEntityList.size() > 0) {
            return employeeDetailsEntityList;
        } else {
            return new ArrayList<EmployeeDetailsEntity>();
        }
    }

    public EmployeeDetailsEntity getEmployeeDetailsById(Long empId) throws Exception {

        EmployeeDetailsEntity employeeDetailsEntity = iEmployeeDetailsRepository.getEmployeeById(empId);
        return employeeDetailsEntity;
    }

    public Boolean deleteEmployeebyId(Long empId) {
        iEmployeeDetailsRepository.deleteEmployeeById(empId);
        return true;
    }

}
