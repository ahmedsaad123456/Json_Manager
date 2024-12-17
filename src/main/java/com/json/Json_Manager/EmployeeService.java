package com.json.Json_Manager;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class EmployeeService {

    //------------------------------------------------------------------------------------------------------------
    // Add a new employee
    public Employee addEmployee(Employee employee) {
        validateEmployee(employee); // Validate the employee before adding
        return JsonManager.addEmployee(employee);
    }
    //------------------------------------------------------------------------------------------------------------

    // Show all employees
    public ArrayList<Employee> showAllEmployees() {
        return JsonManager.showAll();
    }

    //------------------------------------------------------------------------------------------------------------
    // Search employee by ID
    public Employee searchByID(String id) {
        return JsonManager.searchByID(id);
    }

    //------------------------------------------------------------------------------------------------------------
    // Search employees by designation
    public ArrayList<Employee> searchByDesignation(String designation) {
        return JsonManager.searchByDesignation(designation);
    }

    //------------------------------------------------------------------------------------------------------------
    // Delete employee by ID
    public String deleteEmployee(String id) {
        return JsonManager.deleteEmployee(id);
    }

    //------------------------------------------------------------------------------------------------------------
    // Update employee details
    public Employee updateEmployee(Employee updatedEmployee) {
        validateEmployee(updatedEmployee); // Validate the employee before updating
        return JsonManager.updateEmployee(updatedEmployee);
    }

    //------------------------------------------------------------------------------------------------------------
    // Retrieve and sort employees by name
    public ArrayList<Employee> retrieveAndSort() {
        return JsonManager.retrieveAndSort();
    }

    //------------------------------------------------------------------------------------------------------------
    // Validation method for employee
    private void validateEmployee(Employee employee) {
        // Validate FirstName and LastName (only letters allowed)
        if (!employee.getFirstName().matches("^[a-zA-Z]+$")) {
            throw new IllegalArgumentException("First Name can only contain letters.");
        }
        if (!employee.getLastName().matches("^[a-zA-Z]+$")) {
            throw new IllegalArgumentException("Last Name can only contain letters.");
        }

        // Validate Designation (only letters allowed)
        if (!employee.getDesignation().matches("^[a-zA-Z]+$")) {
            throw new IllegalArgumentException("Designation can only contain letters.");
        }

        // Validate Known Languages (scores between 0 and 100)
        if (employee.getKnownLanguages() != null) {
            for (Language language : employee.getKnownLanguages()) {
                if (language.getScoreOutOf100() < 0 || language.getScoreOutOf100() > 100) {
                    throw new IllegalArgumentException("Score must be between 0 and 100 for language: "
                            + language.getLanguageName());
                }
            }
        }
    }
    //------------------------------------------------------------------------------------------------------------
}
