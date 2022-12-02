package com.esg.esgdata.staff;

import com.esg.esgdata.model.task.TaskItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StaffDao {

    @Autowired
    private StaffRepository repository;

    public Employee save(Employee employee) {
        return repository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        Streamable.of(repository.findAll())
                .forEach(employee -> {
                    employees.add(employee);
                });
        return employees;
    }

    public void delete(int id) {
        repository.deleteById(id);
    }

    public Employee getEmployeeById(int id) {
        List<Employee> employees = new ArrayList<>();
        Streamable.of(repository.findAll())
                .forEach(employee -> {
                    if(employee.getId() == id)
                        employees.add(employee);
                });
        if(employees.size() > 0)
            return employees.get(0);
        return null;
    }
}
