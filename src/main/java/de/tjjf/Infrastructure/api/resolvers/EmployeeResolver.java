package de.tjjf.Infrastructure.api.resolvers;

import de.tjjf.Adapter.APIAdapter.ClientPortImpl;
import de.tjjf.Adapter.APIAdapter.EmployeePortImpl;
import de.tjjf.Infrastructure.api.InputModels.APIAirlineInput;
import de.tjjf.Infrastructure.api.InputModels.APIEmployeeInput;
import de.tjjf.Infrastructure.api.mapper.APIClientMapper;
import de.tjjf.Infrastructure.api.mapper.APIEmployeeMapper;
import de.tjjf.Infrastructure.api.models.APIAddress;
import de.tjjf.Infrastructure.api.models.APIAirline;
import de.tjjf.Infrastructure.api.models.APIEmployee;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;

public class EmployeeResolver implements GraphQLQueryResolver, GraphQLMutationResolver {
    public void createEmployee(APIEmployeeInput employee){
        APIAddress apiAddress = new APIAddress(employee.getAddress().street, employee.getAddress().number, employee.getAddress().zipcode, employee.getAddress().city, employee.getAddress().country);
        APIEmployee apiEmployee = new APIEmployee(employee.getEmployeeId(), employee.getFirstName(), employee.getMiddleNames(), employee.getLastName(), employee.getAirline(), employee.getPhoneNumber(), apiAddress, employee.getEmail(), employee.getDateOfBirth());
        new EmployeePortImpl().createEmployee(new APIEmployeeMapper().toDomainEntity(apiEmployee));
    }

    public APIEmployee readEmployeeByID(long id){
        return new APIEmployeeMapper().toAPIEntity(new EmployeePortImpl().readEmployeeById(id));
    }

    public void updateEmloyee(APIEmployeeInput employee) {
        APIAddress apiAddress = new APIAddress(employee.getAddress().street, employee.getAddress().number, employee.getAddress().zipcode, employee.getAddress().city, employee.getAddress().country);
        APIEmployee apiEmployee = new APIEmployee(employee.getEmployeeId(), employee.getFirstName(), employee.getMiddleNames(), employee.getLastName(), employee.getAirline(), employee.getPhoneNumber(), apiAddress, employee.getEmail(), employee.getDateOfBirth());
        new EmployeePortImpl().updateEmployee(new APIEmployeeMapper().toDomainEntity(apiEmployee));
    }
}
