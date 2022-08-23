package com.company.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> findAllEmployee() {
        return departmentRepository.findAll();
    }

    public Department findEmployeeById(String id) {
        return departmentRepository.findById(id).orElse(null);
    }

    public Department addNewEmployee(Department department) {
        return departmentRepository.save(department);
    }

    public void deleteEmployeeById(String id) {
        departmentRepository.deleteById(id);
    }

    public Department updateEmployeeById(String id, Department department) {
        departmentRepository.findById(id).ifPresent(e -> department.setId(e.getId()));
        return departmentRepository.save(department);
    }

    public List<Department> findEmployeeByDepartmentId(String departmentId) {
        return departmentRepository.findByDepartmentId(departmentId);
    }

    public List<Department> findEmployeeByOrganizationId(String organizationId) {
        return departmentRepository.findByOrganizationId(organizationId);
    }
}