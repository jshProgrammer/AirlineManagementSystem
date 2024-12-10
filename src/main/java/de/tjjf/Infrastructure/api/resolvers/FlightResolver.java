package de.tjjf.Infrastructure.api.resolvers;


import de.tjjf.Infrastructure.api.models.APIFlight;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;

public class FlightResolver implements GraphQLQueryResolver, GraphQLMutationResolver {

    public APIFlight flightByFlightNum(int flightNum) {
        return null;
    }
}
