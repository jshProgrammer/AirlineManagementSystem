package de.tjjf.Domain.ports;

import de.tjjf.Domain.Exceptions.NoSeatsAvailableException;
import de.tjjf.Domain.models.*;

//TODO: besseren Namen einfallen lassen
public interface APIPort {

    boolean addBooking(MTicket newBooking);
    MTicket readTicketById(int id);
    void upgradeSeatingClass(MTicket.SeatingClass newSeatingClass) throws NoSeatsAvailableException;
    void upgradeLuggageWeight(int newWeight) throws IllegalArgumentException;
    void cancelTicket(MPerson person, int flightnum);

    void createEmployee(MEmployee employee);
    boolean verifyPassword(MEmployee employee, String password);
    MEmployee readEmployeeById(long id);
    MEmployee updateEmployee(MEmployee employee);

    void createClient(MClient client);
    MClient readClientById(long id);
    MClient updateClient(MClient client);
    //TODO: delete Client/ Employee würde ich nicht hinzufügen, sonst müssen wir auch noch all seine Buchungen löschen


    void createFlight(MFlight flight);
    MFlight readFlightByNum(long flightNum);
    MFlight updateFlight(MFlight flight); //TODO: man könnte theoretisch dadurch status auf canceled setzen, ohne email zu verschicken?!
    void cancelFlight(MFlight flight);

    void createAirport(MAirport airport);
    MAirport readAirportByCode(String code);
    //TODO: ändern sich die Flughäfen überhaupt? brauchen wir update und delete?

    void createAirplane(MAirplane airplane);
    MAirplane readAirplaneBySerialNum(int serialNum);

    void createAirline(MAirline airline);
    MAirline readAirlineByName(String name);
    MAirline updateAirline(MAirline airline); // e.g. name or headquarter could change
    //TODO: lassen wir überhaupt zu, dass eine Airline gelöscht werden kann? bei Insolvenz sinnvoll, aber wie würden wir mit Tickets umgehen?!

    //TODO: wie sollen wir hier MAddress einbinden? hat ja keine id
}
