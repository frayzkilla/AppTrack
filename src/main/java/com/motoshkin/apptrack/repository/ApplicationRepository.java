package com.motoshkin.apptrack.repository;

import com.motoshkin.apptrack.models.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

    Application findApplicationById(Integer id);

    @Query("SELECT p FROM Application p WHERE p.user.id = :user_id")
    List<Application> findAllByUserId(@Param("user_id") Long userId);

    @Query("SELECT p FROM Application p WHERE p.department.id = :department_id")
    List<Application> findAllByDepartmentId(@Param("department_id") Long departmentId);

}