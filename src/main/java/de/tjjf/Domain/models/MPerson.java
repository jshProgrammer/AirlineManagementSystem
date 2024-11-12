package de.tjjf.Domain.models;

import java.util.Date;
import java.util.List;

import de.tjjf.Domain.EmailSender;
import org.apache.commons.validator.routines.EmailValidator;

public class MPerson implements MModel
{
    private long personId;

    private String firstName;

    private String middleNames;

    private String lastName;

    private Date dateOfBirth;

    private String phonenumber;

    //TODO: evtl. Adress-Objekt anlegen
    private String address;

    private String email;

    //TODO: nicht direkt in Klasse
    private String password;
    private List<MTicket> tickets;

    //TODO: validate whether phone number is valid
    public MPerson(long personId, String firstName, String middleNames, String lastName, Date dateOfBirth, String phonenumber, String address, String email, String password) {
        this.personId = personId;
        this.firstName = firstName;
        this.middleNames = middleNames;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.phonenumber = phonenumber;
        this.address = address;

        // E-Mail-validation
        EmailValidator validator = EmailValidator.getInstance();
        boolean isValid = validator.isValid(email);
        if(!isValid) throw new IllegalArgumentException("Email is not a valid email");

        this.email = email;
        this.password = password;
    }

    public static void main(String[] args) {
        // should not throw Illegal Argument Exception
        //MPerson person = new MPerson(1, "A", null, "C", new Date(1998), "091234u", "Adresse", "jpfennig2403@gmail.com", "passwd");

        // should throw IllegalArgumentException
        //MPerson person2 = new MPerson(1, "A", null, "C", new Date(1998), "091234u", "Adresse", "a@aa", "passwd");
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

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
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

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<MTicket> getTickets() {
        return tickets;
    }

    public void addTickets(MTicket ticket) {
        tickets.add(ticket);
    }

    public void cancelFlight(int flightnum){
        for(MTicket ticket : tickets){
            if(flightnum  == (int) ticket.getFlight().getFlightNum()){
                MFlight mFlight = ticket.getFlight();
                EmailSender.sendCancelationMailCustomer(mFlight);
                mFlight.getTickets().remove(ticket);
            }
        }
    }
}


