package de.tjjf.Infrastructure.Client.ClientOperations.APIOperations;

import de.tjjf.Infrastructure.api.InputModels.APIPaymentInput;
import de.tjjf.Infrastructure.api.InputModels.APITicketInput;
import de.tjjf.Infrastructure.api.models.APITicket;

public class TicketAPIOperation extends AbstractAPIOperation {

    private String transformToQuery(APITicketInput apiTicketInput, String commandName) {
        //TODO: wie hier mit enums vorgehen?
        String query = """
        {
            "query": "mutation {
                %s (client: {
                    ticketID: %d,
                    personID: %d,
                    isClient: \\"%b\\",
                    flightNum: %d,
                    dateTimeOfBooking: \\"%s\\",
                    totalPrice: %d,
                    seatNum: %d,
                    seatingClass: \\"%s\\",
                    ticketStatus: \\"%s\\",
                    weightOfLuggage: %d
                })
            }"
        }
        """.formatted(
                commandName,
                apiTicketInput.getTicketId(),
                apiTicketInput.getPersonId(),
                apiTicketInput.isClient(),
                apiTicketInput.getFlightNum(),
                apiTicketInput.getDateTimeOfBooking(),
                apiTicketInput.getTotalPrice(),
                apiTicketInput.getSeatNum(),
                apiTicketInput.getSeatingClass(),
                apiTicketInput.getTicketStatus(),
                apiTicketInput.getWeightOfLuggage()

        );

        return query;

    }

    public void addBooking(APITicketInput newBooking, APIPaymentInput paymentInput) {
        //TODO: hier muss noch iwie payment mit rein?!
        execute(transformToQuery(newBooking, "addBooking"), "addBooking", APITicket.class);
    }

    public APITicket readTicketById(int ticketId) {
        String query = """
        {
            "query": "{
                readTicketById(ticketId: %d) {
                    ticketID
                    personID
                    isClient
                    flightNum
                    dateTimeOfBooking
                    totalPrice
                    seatNum
                    seatingClass
                    ticketStatus
                    weightOfLuggage
                }
            }"
        }
        """.formatted(ticketId);

        return execute(query, "readTicketById", APITicket.class);
    }

    //TODO: hier erst noch besprechen, ob wirklich id ausreicht oder ganzes input objekt nötig
    public void cancelEmployeeTicket(int employeeId, int flightNum) {
        String query = """
        {
            "query": "mutation {
                cancelEmployeeTicket(employeeId: %d, flightNum: %d)
            }"
        }
        """.formatted(employeeId, flightNum);

        execute(query, "cancelEmployeeTicket", APITicket.class);
    }

    public void cancelClientTicket(int clientId, int flightNum) {
        String query = """
        {
            "query": "mutation {
                cancelClientTicket(clientId: %d, flightNum: %d)
            }"
        }
        """.formatted(clientId, flightNum);

        execute(query, "cancelClientTicket", APITicket.class);
    }

    //TODO: hier müsste APISeatingClassInput eigentlich hin?!
    public void upgradeSeatingClass(int ticketId, String newSeatingClass) {
        String query = """
        {
            "query": "mutation {
                upgradeSeatingClass(ticketId: %d, newSeatingClass: \\"%s\\")
            }"
        }
        """.formatted(ticketId, newSeatingClass);

        execute(query, "upgradeSeatingClass", APITicket.class);
    }

    public void upgradeLuggageWeight(int ticketId, int newLuggageWeight) {
        String query = """
        {
            "query": "mutation {
                upgradeLuggageWeight(ticketId: %d, newLuggageWeight: %d)
            }"
        }
        """.formatted(ticketId, newLuggageWeight);

        execute(query, "upgradeLuggageWeight", APITicket.class);
    }

}
