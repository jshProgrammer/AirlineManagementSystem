package de.tjjf.Infrastructure.api.resolvers;

import de.tjjf.Adapter.APIAdapter.ClientPortImpl;
import de.tjjf.Infrastructure.api.InputModels.APIClientInput;
import de.tjjf.Infrastructure.api.MapperInput.AddressMapperInput;
import de.tjjf.Infrastructure.api.MapperInput.ClientMapperInput;
import de.tjjf.Infrastructure.api.mapper.APIClientMapper;
import de.tjjf.Infrastructure.api.models.APIAddress;
import de.tjjf.Infrastructure.api.models.APIClient;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;

public class ClientResolver implements GraphQLQueryResolver, GraphQLMutationResolver {

    public void createClient(APIClientInput client){
        APIClient apiClient = new ClientMapperInput().toClient(client);
        new ClientPortImpl().createClient(new APIClientMapper().toDomainEntity(apiClient));
    }

    public APIClient readClientById(long id){
        return new APIClientMapper().toAPIEntity(new ClientPortImpl().readClientById(id));
    }

    public void updateClient(APIClientInput client){
        APIClient apiClient = new ClientMapperInput().toClient(client);
        new ClientPortImpl().updateClient(new APIClientMapper().toDomainEntity(apiClient));
    }

}
