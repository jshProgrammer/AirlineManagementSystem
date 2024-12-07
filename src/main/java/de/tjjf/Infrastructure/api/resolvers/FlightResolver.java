package de.tjjf.Infrastructure.api.resolvers;

import de.tjjf.Infrastructure.api.InputModels.FlightInput;
import de.tjjf.Infrastructure.api.models.APIFlight;
import de.tjjf.Infrastructure.api.resolvers.AbstractResolvers.AbstractMutationResolver;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;

public class FlightResolver implements GraphQLQueryResolver, GraphQLMutationResolver {

    public APIFlight flightByFlightNum(int flightNum) {
        return null;
    }
}
