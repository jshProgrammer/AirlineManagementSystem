package de.tjjf.Infrastructure.api.resolvers;

import de.tjjf.Infrastructure.api.adapter.AirplanePortImpl;
import de.tjjf.Infrastructure.api.InputModels.APIAirplaneInput;
import de.tjjf.Infrastructure.api.MapperInput.AirplaneMapperInput;
import de.tjjf.Infrastructure.api.mapper.APIAirplaneMapper;
import de.tjjf.Infrastructure.api.models.APIAirplane;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

@Component
public class AirplaneResolver implements GraphQLQueryResolver, GraphQLMutationResolver {

    public APIAirplane readAirplaneBySerialNum(int serialNum ){

        return new APIAirplaneMapper().toAPIEntity(new AirplanePortImpl().readAirplaneBySerialNum(serialNum));
    }

    public APIAirplane createAirplane(APIAirplaneInput airplane) {
        APIAirplane apiAirplane = new AirplaneMapperInput().toDomain(airplane);
        return new APIAirplaneMapper().toAPIEntity(new AirplanePortImpl().createAirplane(new APIAirplaneMapper().toDomainEntity(apiAirplane)));

    }

    public void setOperable(int serialNum, boolean isOperable){
        new AirplanePortImpl().setOperable(serialNum, isOperable);
    }
}
