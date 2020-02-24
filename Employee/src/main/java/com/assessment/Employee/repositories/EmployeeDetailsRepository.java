package com.assessment.Employee.repositories;

import com.assessment.Employee.entities.EmployeeDetailsEntity;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class EmployeeDetailsRepository implements IEmployeeDetailsRepository {


    @Autowired
    Session session;


    public EmployeeDetailsEntity getEmployeeById(Long empId) {

        return (EmployeeDetailsEntity) session.createCriteria(EmployeeDetailsEntity.class)
                .add(Restrictions.eq("empId", empId)).setMaxResults(1).uniqueResult();
    }

    public List<EmployeeDetailsEntity> getAllEmployees() {
        return session.createCriteria(EmployeeDetailsEntity.class).list();
    }

    public void saveOrupdateEmployeeDetails(EmployeeDetailsEntity employeeDetailsEntity) {
        session.save(employeeDetailsEntity);
        session.flush();
    }

    public void deleteEmployeeById(EmployeeDetailsEntity employeeDetailsEntity) {
        session.remove(employeeDetailsEntity);
        session.flush();
    }


}
