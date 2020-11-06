package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.EmployeeService;

import com.mindex.challenge.service.ReportingStructureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;
import java.util.List;

import java.io.*;

@Service
public class ReportingStructureServiceImpl implements ReportingStructureService {

    private static final Logger LOG = LoggerFactory.getLogger(ReportingStructureServiceImpl.class);

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public ReportingStructure read(String id) {
        LOG.debug("Creating reportingStructure with id [{}]", id);
        System.out.print("creating reporting structure with id [{}]");
        Employee employee = employeeRepository.findByEmployeeId(id);
        
    
        if (employee == null) {
            throw new RuntimeException("Invalid employeeId: " + id);
        }

        
        ReportingStructure reportingStructure = new ReportingStructure();

        reportingStructure.setEmployee(employee);
        int numRep = calcNumberOfReports(employee);
        reportingStructure.setNumberOfReports(numRep);
        return reportingStructure;
    }

    public int calcNumberOfReports(Employee employee){
        LOG.debug("Calculating Number of Reports for [{}]", employee.getFirstName());

        int retVal=0;
        List<Employee> directReports = employee.getDirectReports();

        if (directReports == null){
            return retVal;
        }

        retVal += directReports.size();
        LOG.debug("[{}] has [{}] direct reports", employee.getFirstName(),retVal);

        for(Employee report: directReports){
            //direct reports are Employee objects, but all values except employeeID are null
            report = employeeRepository.findByEmployeeId(report.getEmployeeId());
            
            if (report != null){
                retVal += calcNumberOfReports(report);
            }
        }
        return retVal;
    }
}
