package de.tjjf.Infrastructure.api.resolvers;

import de.tjjf.Infrastructure.api.InputModels.APIAirlineInput;
import de.tjjf.Infrastructure.api.MapperInput.AirlineMapperInput;
import de.tjjf.Infrastructure.api.mapper.APIAirlineMapper;
import de.tjjf.Infrastructure.api.models.APIAirline;
import de.tjjf.Adapter.APIAdapter.AirlinePortImpl;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

@Component
public class AirlineResolver implements GraphQLQueryResolver, GraphQLMutationResolver {

    public APIAirline readAirlineByName(String name) {
        return new APIAirlineMapper().toAPIEntity(new AirlinePortImpl().readAirlineByName(name));
    }

    public APIAirline createAirline(APIAirlineInput airline) {
        APIAirline apiAirline = new AirlineMapperInput().toDomain(airline);
        return new APIAirlineMapper().toAPIEntity(new AirlinePortImpl().createAirline(new APIAirlineMapper().toDomainEntity(apiAirline)));
    }

    public void updateAirline(APIAirlineInput airline) {
        APIAirline apiAirline = new AirlineMapperInput().toDomain(airline);
        new AirlinePortImpl().updateAirline(new APIAirlineMapper().toDomainEntity(apiAirline));
    }
}
