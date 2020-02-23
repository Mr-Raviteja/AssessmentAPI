package com.assessment.Employee.EmpolyeeRepositories;

import com.assessment.Employee.EmpolyeeEntities.EmployeeDetailsEntity;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDetailsRepository implements IEmployeeDetailsRepository {


    @Autowired
    Session session;


    public EmployeeDetailsEntity getEmployeeById(Long empId) {
        //return session.find(EmployeeDetailsEntity.class,"EmpId", empId);
        return (EmployeeDetailsEntity) session.createCriteria(EmployeeDetailsEntity.class)
                .add(Restrictions.eq("EmpId", empId)).setMaxResults(1);

    }

    public List<EmployeeDetailsEntity> getAllEmployees() {
        return session.createCriteria(EmployeeDetailsEntity.class).list();
    }

    public void saveOrupdateEmployeeDetails(EmployeeDetailsEntity employeeDetailsEntity) {
        session.saveOrUpdate(employeeDetailsEntity);
    }

    public void deleteEmployeeById(Long empId) {
        EmployeeDetailsEntity employee = session.find(EmployeeDetailsEntity.class, empId);
        session.delete(employee);
        session.flush();
    }


}
