package de.tjjf.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Person
{
    @Id
    private long id;

    private String firstName;

    private String lastName;

    public Person( )
    {
    }

    public Person( String firstName, String lastName )
    {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName( )
    {
        return firstName;
    }

    public long getId( )
    {
        return id;
    }

    public void setId( long id )
    {
        this.id = id;
    }

    public void setFirstName( String firstName )
    {
        this.firstName = firstName;
    }

    public String getLastName( )
    {
        return lastName;
    }

    public void setLastName( String lastName )
    {
        this.lastName = lastName;
    }
}


