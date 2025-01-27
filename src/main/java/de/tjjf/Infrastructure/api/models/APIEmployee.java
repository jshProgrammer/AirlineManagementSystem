package de.tjjf.Infrastructure.api.models;

public class APIEmployee implements APIModel {
    private long employeeId;

    private String firstName;

    private String middleNames;

    private String lastName;

    private String dateOfBirth;

    private String phoneNumber;

    private APIAddress address;

    private String email;

    private String airlineName;


    public APIEmployee(){}

    public APIEmployee(long employeeId, String firstName, String middleNames, String lastName, String airlineName, String email, APIAddress address, String phoneNumber, String dateOfBirth) {
        this.airlineName = airlineName;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.lastName = lastName;
        this.middleNames = middleNames;
        this.firstName = firstName;
        this.employeeId = employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleNames() {
        return middleNames;
    }

    public void setMiddleNames(String middleNames) {
        this.middleNames = middleNames;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public APIAddress getAddress() {
        return address;
    }

    public void setAddress(APIAddress address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }
}
