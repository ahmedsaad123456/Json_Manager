package com.json.Json_Manager;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/employee")

public class EmployeeController {
    private final EmployeeService service;

    //------------------------------------------------------------------------------------------------------------

    // Constructor

    EmployeeController(EmployeeService service){
        this.service = service;
    }


    //------------------------------------------------------------------------------------------------------------


    // show all employees

    @GetMapping(value = "/showAll")
    public ArrayList<Employee> showAllEmployees(){
        return service.showAllEmployees();
    }

    //------------------------------------------------------------------------------------------------------------

    // add new employee

    @PostMapping(value = "/Add")
    public Employee addEmployee(@RequestBody Employee employee){

        return service.addEmployee(employee);
    }

    //------------------------------------------------------------------------------------------------------------

    // search by id
    @GetMapping(value = "/searchByID")
    public Employee searchByID(@RequestBody String id) {
        return service.searchByID(id);
    }

    //------------------------------------------------------------------------------------------------------------


    // search by designation
    @GetMapping(value = "/searchByDesignation")
    public ArrayList<Employee> searchByDesignation(@RequestBody String designation){

        return service.searchByDesignation(designation);


    }

    //------------------------------------------------------------------------------------------------------------


    // delete employee
    @DeleteMapping(value = "/delete")
    public String deleteEmployee(@RequestBody String id){

        return  service.deleteEmployee(id);
    }

    //------------------------------------------------------------------------------------------------------------

    // update employee
    @PutMapping(value = "/update")
    public Employee updateEmployee(@RequestBody Employee employee){

        return service.updateEmployee(employee);


    }
    //------------------------------------------------------------------------------------------------------------

    // retrieve employees and sort the result
    @GetMapping(value = "/retrieve")
    public ArrayList<Employee> retrieveAndSort(){
        return service.retrieveAndSort();

    }

    //------------------------------------------------------------------------------------------------------------



}
