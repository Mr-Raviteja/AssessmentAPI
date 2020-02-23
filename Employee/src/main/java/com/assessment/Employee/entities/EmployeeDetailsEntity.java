package com.assessment.Employee.entities;

import javax.persistence.*;

@Entity
@Table(name = "employeedetails")
public class EmployeeDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
    @Column(name = "EmpId")
    private Long empId;
    @Column(name = "FirstName")
    private String firstName;
    @Column(name = "LastName")
    private String lastName;
    @Column(name = "Mobile")
    private String mobile;
    @Column(name = "Email")
    private String emailAddress;
    @Column(name = "PostCode")
    private String postCode;
    @Column(name = "City")
    private String city;
    @Column(name = "Country")
    private String country;

    public EmployeeDetailsEntity() {
    }

    public EmployeeDetailsEntity(Long empId, String firstName, String lastName, String mobile, String emailAddress, String postCode, String city, String country) {
        this.empId = empId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobile = mobile;
        this.emailAddress = emailAddress;
        this.postCode = postCode;
        this.city = city;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "EmployeeDetailsEntity{" +
                "id=" + id +
                ", empId=" + empId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", postCode='" + postCode + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
