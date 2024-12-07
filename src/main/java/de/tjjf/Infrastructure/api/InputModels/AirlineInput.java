package de.tjjf.Infrastructure.api.InputModels;

import de.tjjf.Domain.models.MAddress;

import java.util.Date;

public class AirlineInput implements MModelInput {
    private String name;

    private final Date foundationYear;

    private String headQuarters;

    private MAddress address;

    private String phoneNumber;

    private String email;

    //TODO: MAddress muss vermutlich zu AddressInput werden?!
    public AirlineInput(String name, Date foundationYear, String headQuarters, MAddress address, String phoneNumber, String email) {
        this.name = name;
        this.foundationYear = foundationYear;
        this.headQuarters = headQuarters;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getFoundationYear() {
        return foundationYear;
    }

    public String getHeadQuarters() {
        return headQuarters;
    }

    public void setHeadQuarters(String headQuarters) {
        this.headQuarters = headQuarters;
    }

    public MAddress getAddress() {
        return address;
    }

    public void setAddress(MAddress address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}