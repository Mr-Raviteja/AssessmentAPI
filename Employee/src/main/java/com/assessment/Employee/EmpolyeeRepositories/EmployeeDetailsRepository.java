package com.assessment.Employee.EmpolyeeRepositories;

import com.assessment.Employee.EmpolyeeEntities.EmployeeDetailsEntity;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDetailsRepository implements IEmployeeDetailsRepository {


    @Autowired
    Session session;


    public EmployeeDetailsEntity getEmployeeById(Long empId) {
        return session.find(EmployeeDetailsEntity.class, empId);
    }

    public List<EmployeeDetailsEntity> getAllEmployees() {
        return session.createCriteria(EmployeeDetailsEntity.class).list();


    }

    public Boolean saveOrupdateEmployeeDetails(EmployeeDetailsEntity employeeDetailsEntity) {
        session.saveOrUpdate(employeeDetailsEntity);
        return true;
    }

    public Boolean deleteEmployeeById(Long empId) {
        EmployeeDetailsEntity employee = session.find(EmployeeDetailsEntity.class, empId);
        session.delete(employee);
        return true;
    }


}
