package com.company.demo.department;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DepartmentRepository extends MongoRepository<Department, String> {
    List<Department> findByDepartmentId(String departmentId);
    List<Department> findByOrganizationId(String organizationId);
}