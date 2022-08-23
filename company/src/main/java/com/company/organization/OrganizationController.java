package com.company.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/organizations")
public class OrganizationController {
    @Autowired
    private OrganizationService organizationService;

    @GetMapping
    public List<Organization> findAllEmployee() {
        return organizationService.findAllEmployee();
    }

    @GetMapping("/{id}")
    public Organization findEmployee(@PathVariable String id) {
        return organizationService.findEmployeeById(id);
    }

    @PostMapping
    public Organization addEmployee(@RequestBody Organization employee) {
        return organizationService.addNewEmployee(employee);
    }

    @PutMapping("/{id}")
    public Organization editEmployee(@PathVariable String id, @RequestBody Organization employee) {
        return organizationService.updateEmployeeById(id, employee);
    }

    @DeleteMapping
    public void deleteEmployee(@PathVariable String id) {
        organizationService.deleteEmployeeById(id);
    }




}