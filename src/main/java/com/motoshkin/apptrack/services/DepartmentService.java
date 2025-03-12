package com.motoshkin.apptrack.services;

import com.motoshkin.apptrack.models.Department;
import com.motoshkin.apptrack.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> getAllDepartments() {
        return this.departmentRepository.findAll();

    }

    public Department loadDepartmentByName(String name) {
        return departmentRepository.findByName(name);
    }

    public Department loadDepartmentById(Integer id) {
        return departmentRepository.findById(id);
    }
}