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

        return (EmployeeDetailsEntity) session.createCriteria(EmployeeDetailsEntity.class)
                .add(Restrictions.eq("empId", empId)).setMaxResults(1).uniqueResult();
    }

    public List<EmployeeDetailsEntity> getAllEmployees() {
        return session.createCriteria(EmployeeDetailsEntity.class).list();
    }

    public void saveOrupdateEmployeeDetails(EmployeeDetailsEntity employeeDetailsEntity) {
        session.saveOrUpdate(employeeDetailsEntity);
    }

    public void deleteEmployeeById(EmployeeDetailsEntity employeeDetailsEntity) {
        session.remove(employeeDetailsEntity);
        session.flush();
    }


}
