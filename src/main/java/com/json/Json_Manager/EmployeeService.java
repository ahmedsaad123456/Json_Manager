package com.json.Json_Manager;

import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class EmployeeService {

    //------------------------------------------------------------------------------------------------------------

    // Add a new employee
    public Employee addEmployee(Employee employee) {
        return JsonManager.addEmployee(employee);

    }

    //------------------------------------------------------------------------------------------------------------


    // Show all employees
    public ArrayList<Employee> showAllEmployees() {
        return JsonManager.showAll();
    }

    // Search employee by ID
    public ArrayList<Employee> searchByID(String id) {
        return JsonManager.searchByID(id);
    }

    //------------------------------------------------------------------------------------------------------------

    // Search employees by designation
    public ArrayList<Employee> searchByDesignation(String designation) {
        return  JsonManager.searchByDesignation(designation);
    }

    //------------------------------------------------------------------------------------------------------------


    // Delete employee by ID
    public String deleteEmployee(String id) {
        return JsonManager.deleteEmployee(id);
    }

    //------------------------------------------------------------------------------------------------------------

    // Update employee details
    public Employee updateEmployee(Employee updatedEmployee) {
        return JsonManager.updateEmployee(updatedEmployee);
    }

    //------------------------------------------------------------------------------------------------------------

    // Retrieve and sort employees by name
    public ArrayList<Employee> retrieveAndSort() {
        return JsonManager.retrieveAndSort();
    }

    //------------------------------------------------------------------------------------------------------------

}
