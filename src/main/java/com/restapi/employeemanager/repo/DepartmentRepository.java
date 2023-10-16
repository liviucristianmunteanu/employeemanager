package com.restapi.employeemanager.repo;

import com.restapi.employeemanager.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Department findDepartmentById(Long id);

    void deleteDepartmentById(Long id);
}
