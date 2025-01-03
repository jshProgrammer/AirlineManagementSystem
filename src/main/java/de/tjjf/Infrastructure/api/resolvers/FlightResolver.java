package de.tjjf.Infrastructure.api.resolvers;


import de.tjjf.Adapter.APIAdapter.AirlinePortImpl;
import de.tjjf.Adapter.APIAdapter.FlightPortImpl;
import de.tjjf.Infrastructure.api.InputModels.APIFlightInput;
import de.tjjf.Infrastructure.api.MapperInput.EmployeeMapperInput;
import de.tjjf.Infrastructure.api.MapperInput.FlightMapperInput;
import de.tjjf.Infrastructure.api.mapper.APIAirlineMapper;
import de.tjjf.Infrastructure.api.mapper.APIFlightMapper;
import de.tjjf.Infrastructure.api.models.APIEmployee;
import de.tjjf.Infrastructure.api.models.APIFlight;
import de.tjjf.Infrastructure.persistence.mapper.FlightMapper;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

@Component
public class FlightResolver implements GraphQLQueryResolver, GraphQLMutationResolver {

    public APIFlight createFlight(APIFlightInput apiFlightInput) {
        APIFlight apiFlight = new FlightMapperInput().toDomain(0L, apiFlightInput);
        // auch das funktioniert noch
        System.out.println("TEST.Z2+ " + new APIFlightMapper().toDomainEntity(apiFlight).getCopilot().getFirstName());

        //TODO: createFlight-Methode macht probleme
        System.out.println("Test.z3" + new FlightPortImpl().createFlight(new APIFlightMapper().toDomainEntity(apiFlight)));
        return new APIFlightMapper().toAPIEntity(new FlightPortImpl().createFlight(new APIFlightMapper().toDomainEntity(apiFlight)));
    }

    public APIFlight readFlightByFlightNum(int flightNum) {
        return new APIFlightMapper().toAPIEntity(new FlightPortImpl().readFlightByNum(flightNum));
    }

    public void updateFlight(long flightNum, APIFlightInput apiFlightInput) {
        APIFlight apiFlight = new FlightMapperInput().toDomain(flightNum, apiFlightInput);
        new FlightPortImpl().updateFlight(new APIFlightMapper().toDomainEntity(apiFlight));
    }

    public void cancelFlight(long flightNum) {
        new FlightPortImpl().cancelFlight(new FlightPortImpl().readFlightByNum(flightNum));
    }
}
