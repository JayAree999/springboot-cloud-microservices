package com.company.demo.organization;

import com.company.demo.department.Department;
import com.company.demo.employee.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface OrganizationRepository extends MongoRepository<Organization, String> {

}