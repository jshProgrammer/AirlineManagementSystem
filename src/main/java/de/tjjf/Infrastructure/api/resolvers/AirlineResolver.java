package de.tjjf.Infrastructure.api.resolvers;

import de.tjjf.Infrastructure.api.InputModels.APIAirlineInput;
import de.tjjf.Infrastructure.api.MapperInput.AirlineMapperInput;
import de.tjjf.Infrastructure.api.mapper.APIAddressMapper;
import de.tjjf.Infrastructure.api.mapper.APIAirlineMapper;
import de.tjjf.Infrastructure.api.models.APIAddress;
import de.tjjf.Infrastructure.api.models.APIAirline;
import de.tjjf.Adapter.APIAdapter.AirlinePortImpl;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

@Component
public class AirlineResolver implements GraphQLQueryResolver, GraphQLMutationResolver {

    public APIAirline readAirlineByName(String name) {
        System.out.println("TEST.B" + new AirlinePortImpl().readAirlineByName(name).getName());
        return new APIAirlineMapper().toAPIEntity(new AirlinePortImpl().readAirlineByName(name));
    }

    //TODO: mapper für address
    public APIAirline createAirline(APIAirlineInput airline) {
        System.out.println("TEST.A" + airline.getName());
        System.out.println("TEST.B" + new AirlineMapperInput().toDomain(airline).getName());
        APIAirline apiAirline = new AirlineMapperInput().toDomain(airline);
        System.out.println("Test.E" + new APIAirlineMapper().toDomainEntity(apiAirline).getName());
        return new APIAirlineMapper().toAPIEntity(new AirlinePortImpl().createAirline(new APIAirlineMapper().toDomainEntity(apiAirline)));
    }

    public void updateAirline(APIAirlineInput airline) {
        APIAirline apiAirline = new AirlineMapperInput().toDomain(airline);
        new AirlinePortImpl().updateAirline(new APIAirlineMapper().toDomainEntity(apiAirline));
    }
}
