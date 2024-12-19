package de.tjjf.Infrastructure.api.resolvers;


import de.tjjf.Adapter.APIAdapter.AirlinePortImpl;
import de.tjjf.Adapter.APIAdapter.FlightPortImpl;
import de.tjjf.Infrastructure.api.mapper.APIAirlineMapper;
import de.tjjf.Infrastructure.api.mapper.APIFlightMapper;
import de.tjjf.Infrastructure.api.models.APIFlight;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;

public class FlightResolver implements GraphQLQueryResolver, GraphQLMutationResolver {

    public APIFlight readFlightByFlightNum(int flightNum) {
        return new APIFlightMapper().toAPIEntity(new FlightPortImpl().readFlightByNum(flightNum));
    }
}
