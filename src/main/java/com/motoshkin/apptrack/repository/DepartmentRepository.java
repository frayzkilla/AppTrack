package com.motoshkin.apptrack.repository;

import com.motoshkin.apptrack.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Department findById(Integer id);

    Department findByName(String name);
}