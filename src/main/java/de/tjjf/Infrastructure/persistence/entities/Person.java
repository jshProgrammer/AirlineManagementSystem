package de.tjjf.Infrastructure.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;

//TODO: auf Datenbankebene eher sinnlos, eher wie in Vererbung/Objektorientierung
@Entity
public class Person implements Model
{
    @Column(nullable = false)
    @Id
    private long personId;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = true)
    private String middleNames;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private Date dateOfBirth;

    @Column(nullable = false)
    private String phonenumber;

    @Column(nullable = false)

    private String address;

    @Column(nullable = false)
    private String email;

    //TODO: nicht direkt in Klasse
    @Column(nullable = false)
    private String password;

    public Person( )
    {
    }

    public Person(long personId, String firstName, String middleNames, String lastName, Date dateOfBirth, String phonenumber, String address, String email, String password) {
        this.personId = personId;
        this.firstName = firstName;
        this.middleNames = middleNames;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.phonenumber = phonenumber;
        this.address = address;
        this.email = email;
        this.password = password;
    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}


