package de.tjjf.Domain.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;

import de.tjjf.Domain.EmailSender;
import org.apache.commons.validator.routines.EmailValidator;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//TODO: sollte die Klasse nicht noch abstract werden?
public class MPerson implements MModel
{
    private long personId;

    private String firstName;

    private String middleNames;

    private String lastName;

    private Date dateOfBirth;

    private String phonenumber;

    private MAddress address;

    private String email;

    BCryptPasswordEncoder passwordEncoder;

    private String hashedPassword;

    private List<MTicket> tickets = new ArrayList<>();

    public MPerson(long personId, String firstName, String middleNames, String lastName, Date dateOfBirth, String phonenumber, MAddress address, String email, String password, List<MTicket> tickets) {
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

        // encode the desired password: https://www.baeldung.com/java-password-hashing
        passwordEncoder = new BCryptPasswordEncoder();
        this.hashedPassword = passwordEncoder.encode(password);

        //TODO: geht hier scheinbar nicht
        //if(this.tickets != null) this.tickets = tickets;
    }

    // Passwort-Überprüfung
    public boolean verifyPassword(String password) {
        //TODO implement verification with https://staging.api.fiw.thws.de/auth/api/users/me
        return passwordEncoder.matches(password, this.hashedPassword);
    }

    public static void main(String[] args) {
        // should not throw Illegal Argument Exception
        MPerson person = new MPerson(1, "A", null, "C", new Date(1998), "091234u", new MAddress("test", 1, 34534,"Berlin", "germany"), "jpfennig2403@gmail.com", "fkgk rdof hhkj arwc", null);
        System.out.println(person.getHashedPassword());

        // should throw IllegalArgumentException
        //MPerson person2 = new MPerson(1, "A", null, "C", new Date(1998), "091234u", "Adresse", "a@aa", "passwd");
    }


    public static boolean verifyPhonenumber(String phoneNumber){
        PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();

        try {
            Phonenumber.PhoneNumber parsedNumber = phoneNumberUtil.parse(phoneNumber, "DE"); //Simplification only german phoneNumbers are allowed

            return phoneNumberUtil.isValidNumber(parsedNumber);
        } catch (NumberParseException e) {
            System.out.println("Invalid Phonenumber: " + e.getMessage());
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

    public MAddress getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getHashedPassword() {
        return hashedPassword;
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

    public List<MTicket> getTickets() {
        return tickets;
    }

    public void addTickets(MTicket ticket) {
        tickets.add(ticket);
    }

    public void setAddress(MAddress address) {
        this.address = address;
    }
}


