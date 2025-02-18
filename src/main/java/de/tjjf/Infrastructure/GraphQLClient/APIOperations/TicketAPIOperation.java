package de.tjjf.Infrastructure.GraphQLClient.APIOperations;

import de.tjjf.Infrastructure.api.DateParser;
import de.tjjf.Infrastructure.api.InputModels.APIPaymentInput;
import de.tjjf.Infrastructure.api.InputModels.APITicketInput;
import de.tjjf.Infrastructure.api.models.APITicket;

public class TicketAPIOperation extends AbstractAPIOperation {

    private String transformToQuery(APITicketInput apiTicketInput, APIPaymentInput apiPaymentInput, String commandName) {
        String query = """
        {
            "query": "mutation {
                %s (newBooking: {
                    personId: %d,
                    isClient: %b,
                    flightNum: %d,
                    dateTimeOfBooking: \\"%s\\",
                    totalPrice: %d,
                    seatNum: %d,
                    seatingClass: %s,
                    ticketStatus: %s,
                    weightOfLuggage: %d
                }, payment: {
                    cardNumber: \\"%s\\",
                    expMonth: \\"%s\\",
                    expYear: \\"%s\\",
                    cvc: \\"%s\\"
                }) %s
            }"
        }
        """.formatted(
                commandName,
                apiTicketInput.getPersonId(),
                apiTicketInput.getIsClient(),
                apiTicketInput.getFlightNum(),
                DateParser.getDateTimeFromDBInRFC3339(apiTicketInput.getDateTimeOfBooking()),
                apiTicketInput.getTotalPrice(),
                apiTicketInput.getSeatNum(),
                apiTicketInput.getSeatingClass(),
                apiTicketInput.getTicketStatus(),
                apiTicketInput.getWeightOfLuggage(),
                apiPaymentInput.getCardNumber(),
                apiPaymentInput.getExpMonth(),
                apiPaymentInput.getExpYear(),
                apiPaymentInput.getCvc(),
                "{ticketId personId isClient flightNum dateTimeOfBooking totalPrice seatNum seatingClass ticketStatus weightOfLuggage}"
        );

        return query;

    }

    public APITicket addTicket(APITicketInput newBooking, APIPaymentInput paymentInput) {
        return execute(transformToQuery(newBooking, paymentInput, "addTicket"), "addTicket", APITicket.class);
    }

    public APITicket readTicketById(long ticketId) {
        String query = """
        {
            "query": "{
                readTicketById(ticketId: %d) {
                    ticketId
                    personId
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

    public void cancelEmployeeTicket(long employeeId, int flightNum) {
        String query = """
        {
            "query": "mutation {
                cancelTicketEmployee(employeeId: %d, flightNum: %d)
            }"
        }
        """.formatted(employeeId, flightNum);

        execute(query, "cancelTicketEmployee", APITicket.class);
    }

    public void cancelClientTicket(long personId, long flightNum) {
        String query = """
        {
            "query": "mutation {
                cancelTicketClient(clientId: %d, flightNum: %d)
            }"
        }
        """.formatted(personId, flightNum);

        execute(query, "cancelTicketClient", APITicket.class);
    }

    public void upgradeSeatingClass(long ticketId, String newSeatingClass) {
        String query = """
        {
            "query": "mutation {
                upgradeSeatingClass(ticketId: %d, newSeatingClass: %s)
            }"
        }
        """.formatted(ticketId, newSeatingClass);

        execute(query, "upgradeSeatingClass", APITicket.class);
    }

    public void upgradeLuggageWeight(long ticketId, int newLuggageWeight) {
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
