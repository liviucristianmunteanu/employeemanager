package com.restapi.employeemanager.controller;

import com.restapi.employeemanager.model.Department;
import com.restapi.employeemanager.model.Employee;
import com.restapi.employeemanager.repo.DepartmentRepository;
import com.restapi.employeemanager.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService ;

    public DepartmentController(DepartmentService departmentService){
        this.departmentService = departmentService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Department>> getAllDepartments(){
        List<Department> departments = departmentService.findAllDepartments();
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Department>getDepartmentById(@PathVariable("id") Long id){
        Department department = departmentService.findDepartmentById(id);
        return new ResponseEntity<>(department, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Department> addDepartment(@RequestBody Department department){
        Department newDepartment = departmentService.addDepartment(department);
        return new ResponseEntity<>(department, HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable("id") Long id,@RequestBody Department department){
        Department updateDepartment = departmentService.updateDepartment(department);
        return new ResponseEntity<>(updateDepartment, HttpStatus.OK);
    }
    @Transactional
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteDepartment(@PathVariable("id") Long id){
        departmentService.deleteDepartmentById(id);
        return new ResponseEntity<>( HttpStatus.OK);
    }
}
