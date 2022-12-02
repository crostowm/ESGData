package com.esg.esgdata.controller;

import com.esg.esgdata.staff.Employee;
import com.esg.esgdata.staff.StaffDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StaffController {

    @Autowired
    private StaffDao staffDao;

    @GetMapping("/staff/get-all")
    public List<Employee> getAllEmployees() {
        return staffDao.getAllEmployees();
    }

    @GetMapping("/staff/get/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return staffDao.getEmployeeById(id);
    }

    @PostMapping("/staff/save")
    public Employee saveEmployee(@RequestBody Employee employee) {
        return staffDao.save(employee);
    }
}
