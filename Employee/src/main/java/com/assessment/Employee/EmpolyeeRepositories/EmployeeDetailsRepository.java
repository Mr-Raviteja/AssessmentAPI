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

    public String CreateEmployee(EmployeeDetailsEntity employeeDetailsEntity) {
        session.save(employeeDetailsEntity);
        return "saved successfully";
    }

    public EmployeeDetailsEntity getEmployeeById(int id) {
        return session.find(EmployeeDetailsEntity.class, id);
    }

    public List<EmployeeDetailsEntity> getAllEmployees() {
        return session.createCriteria(EmployeeDetailsEntity.class).list();


    }

    public String updateEmployeeDetails(EmployeeDetailsEntity employeeDetailsEntity) {
        session.saveOrUpdate(employeeDetailsEntity);
        return "updated sucessfully";
    }

    public String deleteEmployeeById(int id) {
        EmployeeDetailsEntity employee = session.find(EmployeeDetailsEntity.class, id);
        session.delete(employee);
        return "deleted successfull";
    }


}
