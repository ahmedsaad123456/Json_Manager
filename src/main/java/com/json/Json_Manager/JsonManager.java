package com.json.Json_Manager;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class JsonManager {

    private static final String FILE_PATH = "src/main/resources/data/employee.json";

    private static ArrayList<Employee> employeeList;

    //------------------------------------------------------------------------------------------------------------

    static {
        try {
            employeeList = readJson();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //------------------------------------------------------------------------------------------------------------

    public static ArrayList<Employee> showAll() {
        return employeeList;
    }

    public static Employee addEmployee(Employee employee) {
        // Check if ID is unique
        if (!isIdUnique(employee.getEmployeeID())) {
            throw new IllegalArgumentException("Employee ID must be unique.");
        }

        // Add the new employee to the list
        employeeList.add(employee);

        // Save the updated list to the JSON file
        saveJson();

        return employee;
    }
    public static ArrayList<Employee> searchByID(String id) {
        return new ArrayList<>();
    }

    public static ArrayList<Employee> searchByDesignation(String designation) {
        return new ArrayList<>();
    }

    public static String deleteEmployee(String id) {
        return "";
    }

    public static Employee updateEmployee(Employee updatedEmployee) {
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getEmployeeID().equals(updatedEmployee.getEmployeeID())) {
                // Update employee details
                employeeList.set(i, updatedEmployee);
                saveJson();
                return updatedEmployee;
            }
        }
        throw new IllegalArgumentException("Employee with ID " + updatedEmployee.getEmployeeID() + " not found.");
    }


    public static ArrayList<Employee> retrieveAndSort() {
        return new ArrayList<>();
    }

    //------------------------------------------------------------------------------------------------------------

    private static ArrayList<Employee> readJson() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        // convert JSON into a list of Employee objects
        ArrayList<Employee> employees = objectMapper.readValue(new File(FILE_PATH), new TypeReference<ArrayList<Employee>>() {});

        // Print each employee and their details
        for (Employee employee : employees) {
            System.out.println("First Name: " + employee.getFirstName());
            System.out.println("Last Name: " + employee.getLastName());
            System.out.println("Employee ID: " + employee.getEmployeeID());
            System.out.println("Designation: " + employee.getDesignation());
            System.out.println("Known Languages:");
            for (Language language : employee.getKnownLanguages()) {
                System.out.println("- " + language.getLanguageName() + ": " + language.getScoreOutOf100());
            }
        }

        return employees;
    }

    //------------------------------------------------------------------------------------------------------------

    private static void saveJson() {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // convert the employeeList to the JSON file
            objectMapper.writeValue(new File(FILE_PATH), employeeList);
            System.out.println("Employee list successfully saved to " + FILE_PATH);
        } catch (IOException e) {
            System.err.println("Error saving employee list: " + e.getMessage());
        }
    }

    //------------------------------------------------------------------------------------------------------------

    private static boolean isIdUnique(String id) {
        for (Employee employee : employeeList) {
            if (employee.getEmployeeID().equals(id)) {
                return false;
            }
        }
        return true;
    }

    //------------------------------------------------------------------------------------------------------------

}