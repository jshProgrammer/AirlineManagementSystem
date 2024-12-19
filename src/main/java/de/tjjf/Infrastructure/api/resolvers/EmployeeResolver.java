package de.tjjf.Infrastructure.api.resolvers;

import de.tjjf.Adapter.APIAdapter.EmployeePortImpl;
import de.tjjf.Infrastructure.api.InputModels.APIEmployeeInput;
import de.tjjf.Infrastructure.api.MapperInput.EmployeeMapperInput;
import de.tjjf.Infrastructure.api.mapper.APIEmployeeMapper;
import de.tjjf.Infrastructure.api.models.APIAddress;
import de.tjjf.Infrastructure.api.models.APIEmployee;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;

public class EmployeeResolver implements GraphQLQueryResolver, GraphQLMutationResolver {
    public void createEmployee(APIEmployeeInput employee){
        APIEmployee apiEmployee = new EmployeeMapperInput().toDomain(employee);
        new EmployeePortImpl().createEmployee(new APIEmployeeMapper().toDomainEntity(apiEmployee));
    }

    public APIEmployee readEmployeeByID(long id){
        return new APIEmployeeMapper().toAPIEntity(new EmployeePortImpl().readEmployeeById(id));
    }

    public void updateEmloyee(APIEmployeeInput employee) {
        APIEmployee apiEmployee = new EmployeeMapperInput().toDomain(employee);
        new EmployeePortImpl().updateEmployee(new APIEmployeeMapper().toDomainEntity(apiEmployee));
    }
}
