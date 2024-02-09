package com.example.eglbmobfkzgieoqusdjl.employee.controller;

import com.example.eglbmobfkzgieoqusdjl.customer.dto.CustomerRequest;
import com.example.eglbmobfkzgieoqusdjl.employee.dto.EmployeeRequest;
import com.example.eglbmobfkzgieoqusdjl.employee.dto.EmployeeResponse;
import com.example.eglbmobfkzgieoqusdjl.employee.model.Employee;
import com.example.eglbmobfkzgieoqusdjl.employee.service.EmployeeService;
import com.example.eglbmobfkzgieoqusdjl.filter.Filter;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
@AllArgsConstructor
public class EmployeeController {
    @PostConstruct
    public void init(){
        service.create(new EmployeeRequest("margulan", 2005, "+77077146503", "+77077146503"));
        service.create(new EmployeeRequest("margulan", 2005, "+77077146503", "+77077146503"));
        service.create(new EmployeeRequest("margulan", 2005, "+77077146503", "+77077146503"));
        service.create(new EmployeeRequest("margulan", 2005,"+77077146503", "+77077146503"));
    }
    private final EmployeeService service;

    @PostMapping("/createEmployee")
    public ResponseEntity<EmployeeResponse> createEmployee(@RequestBody EmployeeRequest request) {
        return service.createEmployee(request);
    }

    @DeleteMapping("/deleteEmployeeById/{id}")
    public ResponseEntity<EmployeeResponse> deleteEmployee(@PathVariable ObjectId id) {
        return service.deleteById(id);
    }

    @GetMapping("/getEmployeeById/{id}")
    public ResponseEntity<EmployeeResponse> getEmployee(@PathVariable ObjectId id) {
        return service.getById(id);
    }

    @PatchMapping("/updateEmployee/{employeeId}")
    public ResponseEntity<EmployeeResponse> updateCustomer(@RequestBody EmployeeRequest request, @PathVariable ObjectId employeeId) {
        return service.updateCustomer(request, employeeId);
    }
    @GetMapping("/getEmployeeWithFilter")
    public List<Employee> getEmployeesWithFilter(@RequestBody Filter filter){
        return service.getWithFilterAndOffset(filter.getLimit(), filter.getOffset());
    }

}
