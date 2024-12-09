package com.json.Json_Manager;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;

public class Employee {


    public Employee() {}

    //------------------------------------------------------------------------------------------------------------

    public Employee(String firstName, String lastName, String employeeID, String designation, ArrayList<Language> knownLanguages) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeID = employeeID;
        this.designation = designation;
        this.knownLanguages = knownLanguages;
    }
    //------------------------------------------------------------------------------------------------------------

    @JsonProperty("FirstName")
    private String firstName;

    //------------------------------------------------------------------------------------------------------------

    @JsonProperty("LastName")
    private String lastName;

    //------------------------------------------------------------------------------------------------------------

    @JsonProperty("EmployeeID")
    private String employeeID;

    //------------------------------------------------------------------------------------------------------------

    @JsonProperty("Designation")
    private String designation;

    //------------------------------------------------------------------------------------------------------------

    @JsonProperty("KnownLanguages")
    private ArrayList<Language> knownLanguages;

    //------------------------------------------------------------------------------------------------------------

    // Getter and Setter for firstName
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    //------------------------------------------------------------------------------------------------------------

    // Getter and Setter for lastName
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //------------------------------------------------------------------------------------------------------------

    // Getter and Setter for employeeID
    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }
    //------------------------------------------------------------------------------------------------------------


    // Getter and Setter for designation
    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
    //------------------------------------------------------------------------------------------------------------


    // Getter and Setter for knownLanguages
    public ArrayList<Language> getKnownLanguages() {
        return knownLanguages;
    }

    public void setKnownLanguages(ArrayList<Language> knownLanguages) {
        this.knownLanguages = knownLanguages;
    }

    //------------------------------------------------------------------------------------------------------------

}
