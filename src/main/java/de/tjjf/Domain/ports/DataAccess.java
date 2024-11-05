package de.tjjf.Domain.ports;


import de.tjjf.Domain.models.*;

import java.util.List;

public interface DataAccess {
    public void create(MModel mModel);

    //TODO: schönere Lösung falls möglich
    public MModel readAirline(String name);
    public MModel readAirplane(int serialnumber);
    public MAirport readAirport(String code);
    public MBooking readBooking(int bookingnum);
    /*public MClient readClient(int personId);
    public MEmployee readEmployee(int employeeid);
    public MFlight readFlight(long flightnum);/
    public MPerson readPerson(int id);


    void update( MModel mModel );

    //TODO: schönere Lösung falls möglich
    public void deleteAirplane(int serialnumber);
    public void deleteAirline(String name);
    public void deleteAirport(String code);
    public void deleteBooking(int bookingnum);
    /*public void deleteClient(int personId);
    public void deleteEmployee(int employeeid);
    public void deleteFlight(long flightnum);*/
    public void deletePerson(int id);
}
