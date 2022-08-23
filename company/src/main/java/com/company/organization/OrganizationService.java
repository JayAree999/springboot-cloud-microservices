package com.company.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationService {

    @Autowired
    private OrganizationRepository organizationRepository;

    public List<Organization> findAllEmployee() {
        return organizationRepository.findAll();
    }

    public Organization findEmployeeById(String id) {
        return organizationRepository.findById(id).orElse(null);
    }

    public Organization addNewEmployee(Organization employee) {
        return organizationRepository.save(employee);
    }

    public void deleteEmployeeById(String id) {
        organizationRepository.deleteById(id);
    }

    public Organization updateEmployeeById(String id, Organization employee) {
        organizationRepository.findById(id).ifPresent(e -> employee.setId(e.getId()));
        return organizationRepository.save(employee);
    }


}