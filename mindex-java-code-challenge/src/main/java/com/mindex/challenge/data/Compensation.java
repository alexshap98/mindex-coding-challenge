package com.mindex.challenge.data;
import com.mindex.challenge.data.Employee;

public class Compensation{

    private Employee employee;
    private String employeeId;
    private int salary;
    private String effectiveDate;
    public Compensation(){
        this.employee = null;
    }

    public Employee getEmployee(){
        return this.employee;
    }

    public void setEmployee(Employee employee){
        this.employee = employee;
    }


    public String getEmployeeId(){
        return this.employeeId;
    }

    public void setEmployeeId(String employeeId){
        this.employeeId = employeeId;
    }

    public int getSalary(){
        return this.salary;
    }

    public void setSalary(int salary){
        this.salary = salary;
    }

    public String getEffectiveDate(){
        return this.effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate){
        this.effectiveDate = effectiveDate;
    }
}