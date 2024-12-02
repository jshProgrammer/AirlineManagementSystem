package de.tjjf.Domain;

import de.tjjf.Domain.models.MAirplane;
import de.tjjf.Domain.models.MAirport;
import de.tjjf.Domain.models.MEmployee;
import de.tjjf.Domain.models.MFlight;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Create.FlightCreateImpl;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Read.AirplaneReadImpl;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Read.AirportReadImpl;
import de.tjjf.Infrastructure.persistence.DBOperations.ImplOperations.Read.EmployeeReadImpl;
import de.tjjf.Infrastructure.persistence.entities.Airplane;
import de.tjjf.Infrastructure.persistence.entities.Flight;
import de.tjjf.Infrastructure.persistence.mapper.AirplaneMapper;
import de.tjjf.Infrastructure.persistence.mapper.AirportMapper;
import de.tjjf.Infrastructure.persistence.mapper.EmployeeMapper;
import de.tjjf.Infrastructure.persistence.mapper.FlightMapper;
import org.apache.commons.lang3.ObjectUtils;

import java.util.Date;

public class TestCreateFlight {
    private static long flightnum = 1;
    //TODO: Evtl ändern von Create Methoden das die ein MModel nehmen, dann braucht man da keine Mapper mehr
    //TODO: Evtl rausschmeißen von ENUMS und die nur im Client zur Erstellung verwenden, später dann evtl nur mit String arbeiten
    //TODO: Wie machen wir es wenn falsche Nummer eingegeben wurde geben wir einen allg. Fehler aus? Lassen wir den Fehler im Read werfen
    public void CreateFlight(int serialNum, Date departuretime, String departureAirport, Date arrivaltime, String arrivalAirprt, Date boardingTime, MFlight.FlightStatus flightStatus, int duration, long pilotCrew, long copilotCrew) {
        MAirplane airplane = new AirplaneMapper().toDomain(new AirplaneReadImpl(serialNum).run().model);
        MEmployee pilot = TestReadEmployee.ReadEmployee(pilotCrew);
        MEmployee copilot = TestReadEmployee.ReadEmployee(copilotCrew);
        MAirport dAirport = new AirportMapper().toDomain(new AirportReadImpl(departureAirport).run().model);
        MAirport aAirport = new AirportMapper().toDomain(new AirportReadImpl(arrivalAirprt).run().model);
        if(airplane == null){
            throw new IllegalArgumentException("Airplane doesn`t exist");
        }
        MFlight newFlight = new MFlight(flightnum, airplane, departuretime, dAirport, arrivaltime, aAirport, boardingTime, flightStatus,duration, pilot, copilot);
        Flight toDatabase = new FlightMapper().toEntity(newFlight);
        new FlightCreateImpl(toDatabase).run();
        flightnum++;
    }
}
