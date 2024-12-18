package de.tjjf.Infrastructure.api.resolvers;

import de.tjjf.Infrastructure.api.InputModels.APIAirlineInput;
import de.tjjf.Infrastructure.api.mapper.APIAddressMapper;
import de.tjjf.Infrastructure.api.mapper.APIAirlineMapper;
import de.tjjf.Infrastructure.api.models.APIAddress;
import de.tjjf.Infrastructure.api.models.APIAirline;
import de.tjjf.Adapter.APIAdapter.AirlinePortImpl;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;

public class AirlineResolver implements GraphQLQueryResolver, GraphQLMutationResolver {

    public APIAirline readAirlineByName(String name) {
        return new APIAirlineMapper().toAPIEntity(new AirlinePortImpl().readAirlineByName(name));
    }

    //TODO: mapper für address
    public void createAirline(APIAirlineInput airline) {
        APIAddress apiAddress = new APIAddress(airline.getAddress().street, airline.getAddress().number, airline.getAddress().zipcode, airline.getAddress().city, airline.getAddress().country);
        APIAirline apiAirline = new APIAirline(airline.getName(), airline.getFoundationYear(), apiAddress, airline.getPhoneNumber(), airline.getEmail());
        new AirlinePortImpl().createAirline(new APIAirlineMapper().toDomainEntity(apiAirline));
    }

    public void updateAirline(APIAirlineInput airline) {
        APIAddress apiAddress = new APIAddress(airline.getAddress().street, airline.getAddress().number, airline.getAddress().zipcode, airline.getAddress().city, airline.getAddress().country);
        APIAirline apiAirline = new APIAirline(airline.getName(), airline.getFoundationYear(), apiAddress, airline.getPhoneNumber(), airline.getEmail());
        new AirlinePortImpl().updateAirline(new APIAirlineMapper().toDomainEntity(apiAirline));
    }
}
