package com.restapi.employeemanager.service;

import com.restapi.employeemanager.model.Department;
import com.restapi.employeemanager.repo.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository){
        this.departmentRepository = departmentRepository;
    }
    public Department addDepartment(Department department){
       return departmentRepository.save(department);
    }
    public List<Department> findAllDepartments(){
        return departmentRepository.findAll();
    };

    public Department findDepartmentById(Long id){
        return  departmentRepository.findDepartmentById(id);
    }

    public Department updateDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public void deleteDepartmentById(Long id) {
        departmentRepository.deleteDepartmentById(id);
    }
}
