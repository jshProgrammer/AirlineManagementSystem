package de.tjjf.Infrastructure.api.resolvers;

import de.tjjf.Adapter.APIAdapter.AirlinePortImpl;
import de.tjjf.Adapter.APIAdapter.BookingPortImpl;
import de.tjjf.Infrastructure.api.InputModels.APITicketInput;
import de.tjjf.Infrastructure.api.mapper.APIAirlineMapper;
import de.tjjf.Infrastructure.api.mapper.APITicketMapper;
import de.tjjf.Infrastructure.api.models.APITicket;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;

public class TicketResolver implements GraphQLQueryResolver, GraphQLMutationResolver {

    public void addBooking(APITicketInput ticket, ) {
        new BookingPortImpl().addBooking();
    }

    public APITicket readTicketById(int id) {
        return new APITicketMapper().toAPIEntity(new BookingPortImpl().readTicketById(id));
    }

    public void upgradeSeatingClass(SeatingClassInput newSeatingClass) {

    }

    public void upgradeLuggageWeight(int newWeight) {

    }

    public void cancelTicket(APIPersonInput person, int flightNum) {
        new BookingPortImpl().cancelTicket(person, flightNum);
    }

}
