package de.tjjf.Domain.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;

import org.apache.commons.validator.routines.EmailValidator;

//TODO: sollte die Klasse nicht noch abstract werden?
public class DomainPerson implements DomainModel
{
    private long personId;

    private String firstName;

    private String middleNames;

    private String lastName;

    private Date dateOfBirth;

    private String phonenumber;

    private DomainAddress address;

    private String email;

    private List<DomainTicket> tickets = new ArrayList<>();

    public DomainPerson(long personId, String firstName, String middleNames, String lastName, Date dateOfBirth, String phonenumber, DomainAddress address, String email, List<DomainTicket> tickets) {
        this.personId = personId;
        this.firstName = firstName;
        this.middleNames = middleNames;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;

        //PhoneNumber-validation
        if(verifyPhonenumber(phonenumber)) this.phonenumber = phonenumber;

        // E-Mail-validation
        EmailValidator validator = EmailValidator.getInstance();
        boolean isValid = validator.isValid(email);
        if(!isValid) throw new IllegalArgumentException("Email is not a valid email");

        this.email = email;

        //TODO: geht hier scheinbar nicht
        //if(this.tickets != null) this.tickets = tickets;
    }


    public static boolean verifyPhonenumber(String phoneNumber){
        PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();

        try {
            Phonenumber.PhoneNumber parsedNumber = phoneNumberUtil.parse(phoneNumber, "DE"); //Simplification only german phoneNumbers are allowed

            return phoneNumberUtil.isValidNumber(parsedNumber);
        } catch (NumberParseException e) {
            System.err.println("Invalid Phonenumber: " + e.getMessage());
            return false;
        }
    }

    public String getFirstName( )
    {
        return firstName;
    }

    public long getPersonId( )
    {
        return personId;
    }

    public void setPersonId( long id )
    {
        this.personId = id;
    }

    public void setFirstName( String firstName )
    {
        this.firstName = firstName;
    }

    public String getLastName( )
    {
        return lastName;
    }

    public String getMiddleNames() {
        return middleNames;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public DomainAddress getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public void setLastName(String lastName )
    {
        this.lastName = lastName;
    }

    public void setMiddleNames(String middleNames) {
        this.middleNames = middleNames;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<DomainTicket> getTickets() {
        return tickets;
    }

    public void addTickets(DomainTicket ticket) {
        tickets.add(ticket);
    }

    public void setAddress(DomainAddress address) {
        this.address = address;
    }
}


