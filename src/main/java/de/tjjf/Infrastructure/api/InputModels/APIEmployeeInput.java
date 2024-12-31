package de.tjjf.Infrastructure.api.InputModels;

public class APIEmployeeInput implements APIModelInput {


    public APIEmployeeInput() {}

    public APIEmployeeInput(String firstName, String middleNames, String lastName, String dateOfBirth, String phoneNumber, APIAddressInput address, String email, String airlineName) {
        this.firstName = firstName;
        this.middleNames = middleNames;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
        this.airlineName = airlineName;
    }

    private String firstName;

    private String middleNames;

    private String lastName;

    private String dateOfBirth;

    private String phoneNumber;

    private APIAddressInput address;

    private String email;

    private String airlineName;

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

    public String getDateOfBirthInRFC3339() {
        String[] dateArr = dateOfBirth.split(" ");

        // if date format is already in RFC3339
        if(dateArr.length == 2) return dateOfBirth;

        String month = switch (dateArr[1]) {
            case "Jan" -> "01";
            case "Feb" -> "02";
            case "Mar" -> "03";
            case "Apr" -> "04";
            case "May" -> "05";
            case "Jun" -> "06";
            case "Jul" -> "07";
            case "Aug" -> "08";
            case "Sep" -> "09";
            case "Oct" -> "10";
            case "Nov" -> "11";
            case "Dec" -> "12";
            default -> "00";
        };

        return dateArr[5] + "-" + month + "-" + dateArr[2];
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

    public APIAddressInput getAddress() {
        return address;
    }

    public void setAddress(APIAddressInput address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAirlineName() {
        return airlineName;
    }
    public void setAirlineName(String airline) {
        this.airlineName = airline;
    }
}
