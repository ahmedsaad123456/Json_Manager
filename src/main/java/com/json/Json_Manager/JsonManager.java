package com.json.Json_Manager;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

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
    public static Employee searchByID(String id) {
        System.out.println("searching for id " + id);
        for (Employee employee : employeeList) {
            if (employee.getEmployeeID().equals(id)) {
                return employee;
            }
            else {
                System.out.println("not found");
            }
        }
        return null;
    }

    public static ArrayList<Employee> searchByDesignation(String designation) {
        ArrayList<Employee> result = new ArrayList<>();

        for (Employee employee : employeeList) {
            if (employee.getDesignation().equalsIgnoreCase(designation)) {
                result.add(employee);
            }
        }
       return result;
    }

    public static String deleteEmployee(String id) {

        boolean removed = employeeList.removeIf(employee -> employee.getEmployeeID().equals(id));

        if (removed) {
            saveJson(); // Save changes to the JSON file
            return "Employee with ID " + id + " has been successfully deleted.";
        } else {
            return "Employee with ID " + id + " not found.";
        }
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

        ArrayList<Employee> result = new ArrayList<>();

        for (Employee employee : employeeList) {

            for (Language language : employee.getKnownLanguages()) {
                if (language.getLanguageName().equalsIgnoreCase("Java") && language.getScoreOutOf100() > 50) {
                    result.add(employee);
                    break;
                }
            }
        }

        // Sort the result by the language score in ascending order
        result.sort((e1, e2) -> {
            int score1 = getJavaScore(e1);
            int score2 = getJavaScore(e2);
            return Integer.compare(score1, score2);
        });

        return result;
    }

    // Helper method to get the Java score for an employee
    private static int getJavaScore(Employee employee) {
        for (Language language : employee.getKnownLanguages()) {
            if (language.getLanguageName().equalsIgnoreCase("Java")) {
                return language.getScoreOutOf100();
            }
        }
        return -1;
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