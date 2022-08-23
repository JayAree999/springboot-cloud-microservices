package com.company.demo.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public List<Department> findAllEmployee() {
        return departmentService.findAllEmployee();
    }

    @GetMapping("/{id}")
    public Department findEmployee(@PathVariable String id) {
        return departmentService.findEmployeeById(id);
    }

    @PostMapping
    public Department addEmployee(@RequestBody Department department) {
        return departmentService.addNewEmployee(department);
    }

    @PutMapping("/{id}")
    public Department editEmployee(@PathVariable String id, @RequestBody Department department) {
        return departmentService.updateEmployeeById(id, department);
    }

    @DeleteMapping
    public void deleteEmployee(@PathVariable String id) {
        departmentService.deleteEmployeeById(id);
    }

    @GetMapping("/department/{departmentId}")
    public List<Department> findEmployeeByDepartmentId(@PathVariable String departmentId) {
        return departmentService.findEmployeeByDepartmentId(departmentId);
    }

    @GetMapping("/organization/{organizationId}")
    public List<Department> findEmployeeByOrganizationId(@PathVariable String organizationId) {
        return departmentService.findEmployeeByOrganizationId(organizationId);
    }
}