package de.tjjf.Infrastructure.api.resolvers;

import de.tjjf.Adapter.APIAdapter.AirplanePortImpl;
import de.tjjf.Infrastructure.api.InputModels.APIAirplaneInput;
import de.tjjf.Infrastructure.api.mapper.APIAirplaneMapper;
import de.tjjf.Infrastructure.api.models.APIAirplane;
import de.tjjf.Infrastructure.persistence.entities.Airplane;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;

public class AirplaneResolver implements GraphQLQueryResolver, GraphQLMutationResolver {

    public void createAirplane(APIAirplaneInput airplane) {
        APIAirplane apiAirplane = new APIAirplane(airplane.getSerialNum(), airplane.getBelongingAirline(), airplane.isOperable());
        new AirplanePortImpl().createAirplane(new APIAirplaneMapper().toDomainEntity(apiAirplane));
    }

    public APIAirplane readAirplaneBySerialNum(int serialNum ){
        return new APIAirplaneMapper().toAPIEntity(new AirplanePortImpl().readAirplaneBySerialNum(serialNum));
    }

    public void setOperable(int serialNum, boolean isOperable){
        new AirplanePortImpl().setOperable(serialNum, isOperable);
    }
}
