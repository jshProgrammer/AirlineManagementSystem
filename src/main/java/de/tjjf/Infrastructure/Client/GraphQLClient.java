package de.tjjf.Infrastructure.Client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.tjjf.Domain.UseCases.AuthenticationUseCase;
import de.tjjf.Domain.models.MAirline;
import de.tjjf.Infrastructure.Client.ClientOperations.APIOperations.*;
import de.tjjf.Infrastructure.api.InputModels.*;
import de.tjjf.Infrastructure.api.models.APIAirline;
import de.tjjf.Infrastructure.api.models.APIEmployee;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class GraphQLClient {

    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        //TODO: can be extracted to a test class
        GraphQLClient client = new GraphQLClient();
        //new FlightAPIOperation().cancelFlight(123);
        //new AirlineAPIOperation().readAirlineByName("Test ");

        //new FlightAPIOperation().createFlight(new APIFlightInput(1, 1, new Date(2000, 01,01), "Test", new Date(2000, 01,01), "Test", new Date(2000, 01,01), ))

        //new ClientAPIOperation().createClient(new APIClientInput(12, "Jan", "M", "Kowalski", new Date(2000, 01, 01), "0234214234", new APIAddressInput("Test", 1, 91237, "Berlin", "Germany"), "test@test.de", true));


        //new AirlineAPIOperation().createAirline(new APIAirlineInput("Test1423112381231", new Date(2005, 01, 01), new APIAddressInput("Test", 1, 91237, "Berlin", "Germany" ), "+4915112345678", "test@test.de"));
        //APIEmployee apiEmployee = new EmployeeAPIOperation().createEmployee(new APIEmployeeInput("Jan", "M", "Kowalski", new Date(2000, 2, 1) , "+4915112345678", new APIAddressInput("Test", 1, 91237, "Berlin", "Germany"), "test@test.de", "Test"));
        //new EmployeeAPIOperation().readEmployeeById(123);
        //new ClientAPIOperation().readClientById(123);
        //new TicketAPIOperation().readTicketById(1);
        //new AirportAPIOperation().readAirportByCode("FRA"); //funktioniert schon mit DB
        //new FlightAPIOperation().readFlightByFlightNum(102); // funktioniert noch nicht mit DB
        //new AirplaneAPIOperation().readAirplaneBySerialNum(1232147119);
        //new AirlineAPIOperation().readAirlineByName("Test");

        //new FlightAPIOperation().updateFlight(new APIFlightInput(1, 1, new Date(2000, 01, 01), "Test", new Date(2000, 01, 01), "Test", new Date(2000, 01, 01), APIFlightInput.FlightStatus.canceled, 1, 1, 1));
        //new TicketAPIOperation().cancelClientTicket(1, 1);
        //new TicketAPIOperation().upgradeLuggageWeight(1, 20);
        //TODO: addBooking und upgradeSeatingClass funktioniert noch nicht!
        //new TicketAPIOperation().upgradeSeatingClass(1, APITicket.SeatingClass.Business.name());
        //new TicketAPIOperation().addBooking(new APITicketInput(1, 1, true, 1, new Date(2000, 01, 01), 1, 1, APITicketInput.SeatingClass.Business, APITicketInput.TicketStatus.paid, 1), new APIPaymentInput("1", "Jan", "2005", "na"));
        //new AirportAPIOperation().createAirport(new APIAirportInput("ABC", "Frankfurt", "Germany", "Frankfurt", "german"));
        new AirportAPIOperation().readAirportByCode("ABC");
        //new AirlineAPIOperation().updateAirline(new APIAirlineInput("Test", new Date(2005, 01, 01), new APIAddressInput("Test", 1, 91237, "Berlin", "Germany" ), "02341324", "test@test.de" ));
        new AirlineAPIOperation().createAirline(new APIAirlineInput("Test12384718293", new Date(2005, 2, 2), new APIAddressInput("Test", 1, 91237, "Berlin", "Germany" ), "+4915112345678", "test@test.de"  ));
        //new AirlineAPIOperation().readAirlineByName("Test1238471829371");
        //new AirplaneAPIOperation().createAirplane(new APIAirplaneInput(123, "MeineAirline", true));
        //new AirplaneAPIOperation().readAirplaneBySerialNum(123);
    }
}