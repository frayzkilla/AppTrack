package com.motoshkin.apptrack.repository;

import com.motoshkin.apptrack.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    public Optional<User> findByEmail(String email);

    User findById(Integer id);

    @Query("SELECT p.department.id FROM User p WHERE p.id = :id")
    Integer findDeptByUserId(@Param("id") Long id);
}
