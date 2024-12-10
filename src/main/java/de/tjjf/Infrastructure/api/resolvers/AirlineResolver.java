package de.tjjf.Infrastructure.api.resolvers;

import de.tjjf.Infrastructure.api.mapper.APIAirlineMapper;
import de.tjjf.Infrastructure.api.models.APIAirline;
import de.tjjf.Adapter.APIAdapter.AirlinePortImpl;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;

public class AirlineResolver implements GraphQLQueryResolver, GraphQLMutationResolver {

    public APIAirline readAirlineByName(String name) {
        return new APIAirlineMapper().toAPIEntity(new AirlinePortImpl().readAirlineByName(name));
    }

}
