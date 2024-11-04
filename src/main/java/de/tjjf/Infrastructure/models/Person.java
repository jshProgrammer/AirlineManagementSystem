package de.tjjf.Infrastructure.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Person
{
    @Column(nullable = false)
    @Id
    private long personId;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String middleNames;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private Date dateOfBirth;

    @Column(nullable = false)
    private String phonenumber;

    @Column(nullable = false)
    //TODO: evtl. Adress-Objekt anlegen
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
}


