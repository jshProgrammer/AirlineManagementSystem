package de.tjjf.Infrastructure.api.resolvers;

import de.tjjf.Adapter.APIAdapter.EmployeePortImpl;
import de.tjjf.Infrastructure.api.InputModels.APIEmployeeInput;
import de.tjjf.Infrastructure.api.MapperInput.EmployeeMapperInput;
import de.tjjf.Infrastructure.api.mapper.APIEmployeeMapper;
import de.tjjf.Infrastructure.api.models.APIAddress;
import de.tjjf.Infrastructure.api.models.APIEmployee;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

@Component
public class EmployeeResolver implements GraphQLQueryResolver, GraphQLMutationResolver {
    public APIEmployee createEmployee(APIEmployeeInput employee){
        APIEmployee apiEmployee = new EmployeeMapperInput().toDomain(employee);
        return new APIEmployeeMapper().toAPIEntity(new EmployeePortImpl().createEmployee(new APIEmployeeMapper().toDomainEntity(apiEmployee)));
    }

    public APIEmployee readEmployeeById(long employeeId){
        return new APIEmployeeMapper().toAPIEntity(new EmployeePortImpl().readEmployeeById(employeeId));
    }

    public void updateEmloyee(APIEmployeeInput employee) {
        APIEmployee apiEmployee = new EmployeeMapperInput().toDomain(employee);
        new EmployeePortImpl().updateEmployee(new APIEmployeeMapper().toDomainEntity(apiEmployee));
    }
}
