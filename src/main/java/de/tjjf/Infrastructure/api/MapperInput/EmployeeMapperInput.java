package de.tjjf.Infrastructure.api.MapperInput;

import de.tjjf.Infrastructure.api.InputModels.APIAddressInput;
import de.tjjf.Infrastructure.api.InputModels.APIEmployeeInput;
import de.tjjf.Infrastructure.api.models.APIAddress;
import de.tjjf.Infrastructure.api.models.APIEmployee;

public class EmployeeMapperInput {

    public APIEmployeeInput toClient(APIEmployee employee) {
        APIAddressInput apiAddress = new AddressMapperInput().toClient(employee.getAddress());
        return new APIEmployeeInput(
                //employee.getEmployeeId(),
                employee.getFirstName(),
                employee.getMiddleNames(),
                employee.getLastName(),
                employee.getDateOfBirth(),
                employee.getPhoneNumber(),
                apiAddress,
                employee.getEmail(),
                employee.getAirlineName()
        );
    }

    public APIEmployee toDomain(Long employeeId, APIEmployeeInput employee) {
        APIAddress apiAddress = new AddressMapperInput().toDomain(employee.getAddress());
        return new APIEmployee(
                employeeId,
                employee.getFirstName(),
                employee.getMiddleNames(),
                employee.getLastName(),
                employee.getAirlineName(),
                employee.getEmail(),
                apiAddress,
                employee.getPhoneNumber(),
                employee.getDateOfBirth()
        );
    }

}
