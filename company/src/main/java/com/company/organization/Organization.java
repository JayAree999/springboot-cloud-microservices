package com.company.organization;

import com.company.department.Department;
import com.company.employee.Employee;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Organization {
    @Id
    private String id;
    private String name;
    private String address;
    private List<Department> departments;
    private List<Employee> employees;
}