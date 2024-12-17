package de.tjjf.Infrastructure.api.resolvers;

import de.tjjf.Adapter.APIAdapter.EmployeePortImpl;
import de.tjjf.Infrastructure.api.mapper.APIEmployeeMapper;
import de.tjjf.Infrastructure.api.models.APIEmployee;
import de.tjjf.Infrastructure.persistence.mapper.EmployeeMapper;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;

public class EmployeeResolver implements GraphQLQueryResolver, GraphQLMutationResolver {

    public void createEmployee(APIEmployee apiEmployee){
        new EmployeePortImpl().createEmployee(new APIEmployeeMapper().toDomainEntity(apiEmployee));
    }

    public APIEmployee readEmployeeByID(long id){
        return new APIEmployeeMapper().toAPIEntity(new EmployeePortImpl().readEmployeeById(id));
    }

    public void updateEmloyee(APIEmployee apiEmployee) {
        new EmployeePortImpl().updateEmployee(new APIEmployeeMapper().toDomainEntity(apiEmployee));
    }
}
