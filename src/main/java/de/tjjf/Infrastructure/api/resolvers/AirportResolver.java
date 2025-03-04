package de.tjjf.Infrastructure.api.resolvers;

import de.tjjf.Infrastructure.api.adapter.AirportPortImpl;
import de.tjjf.Infrastructure.api.InputModels.APIAirportInput;
import de.tjjf.Infrastructure.api.mapper.APIAirportMapper;
import de.tjjf.Infrastructure.api.models.APIAirport;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

@Component
public class AirportResolver implements GraphQLQueryResolver, GraphQLMutationResolver {

    public APIAirport createAirport(APIAirportInput airport){
        APIAirport apiAirport = new APIAirport(airport.getCode(), airport.getName(), airport.getCountry(), airport.getCity(), airport.getTimezone());
        return new APIAirportMapper().toAPIEntity(new AirportPortImpl().createAirport(new APIAirportMapper().toDomainEntity(apiAirport)));
    }

    public APIAirport readAirportByCode(String code){
        return new APIAirportMapper().toAPIEntity(new AirportPortImpl().readAirportByCode(code));
    }
}
