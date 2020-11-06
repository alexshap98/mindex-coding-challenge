package com.mindex.challenge.data;
import java.util.List;
public class ReportingStructure{
    private Employee employee;
    private int numberOfReports;

    public ReportingStructure(){

    }
    public ReportingStructure(Employee employee){
        this.employee = employee;
        numberOfReports = calcNumberOfReports(employee);
    }

    public Employee getEmployee(){
        return employee;
    }

    public void setEmployee(Employee employee){
        this.employee = employee;
    }

    public int getNumberOfReports(){
        return numberOfReports;
    }

    public void setNumberOfReports(int numberOfReports){
        this.numberOfReports = numberOfReports;
    }

    public int calcNumberOfReports(Employee employee){
        int retVal=0;
        List<Employee> directReports = employee.getDirectReports();
        retVal += directReports.size();
        for(Employee report: directReports){
            retVal += calcNumberOfReports(report);
        }
        return retVal;
    }
}
