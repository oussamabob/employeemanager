package com.oussama.employeemanager.Service;

import com.oussama.employeemanager.Model.Employee;
import com.oussama.employeemanager.Repository.EmployeeRepository;
import com.oussama.employeemanager.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    public Employee addEmployee(Employee employee){
       employee.setEmployeeCode(UUID.randomUUID().toString());
       return employeeRepository.save(employee);

    }
    public List<Employee> findAllEmployee(){
        return employeeRepository.findAll();
    }
    public Employee updateEmployee(Employee employee){
        return   employeeRepository.save(employee);
    }
    public Employee findEmployeeById(Long id){
        return employeeRepository.findEmployeeByID(id).orElseThrow(()->new UserNotFoundException("User by Id"+id+" Not Found"));
    }
    public void deleteEmployee(Long id){
        employeeRepository.deleteEmployeeById(id);
    }
}
