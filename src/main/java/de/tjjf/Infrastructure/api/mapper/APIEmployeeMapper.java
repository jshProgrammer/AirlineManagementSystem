package de.tjjf.Infrastructure.api.mapper;

import de.tjjf.Domain.models.DomainEmployee;
import de.tjjf.Domain.models.DomainPerson;
import de.tjjf.Infrastructure.api.models.APIEmployee;
import de.tjjf.Adapter.APIAdapter.AirlinePortImpl;

import java.util.Date;

public class APIEmployeeMapper extends AbstractAPIMapper<APIEmployee, DomainEmployee>{
    @Override
    public APIEmployee toAPIEntity(DomainEmployee mEmployee) {
        return new APIEmployee(
                mEmployee.getPersonId(),
                mEmployee.getFirstName(),
                mEmployee.getMiddleNames(),
                mEmployee.getLastName(),
                mEmployee.getAirline().getName(),
                mEmployee.getEmail(),
                new APIAddressMapper().toAPIEntity(mEmployee.getAddress()),
                mEmployee.getPhonenumber(),
                mEmployee.getDateOfBirth().toString()
        );
    }

    @Override
    public DomainEmployee toDomainEntity(APIEmployee apiEmployee) {
        DomainPerson person = new PersonMapper().toDomain(apiEmployee);
        return new DomainEmployee(
                person.getPersonId(),
                person.getFirstName(),
                person.getMiddleNames(),
                person.getLastName(),
                person.getDateOfBirth(),
                person.getPhonenumber(),
                new APIAddressMapper().toDomainEntity(apiEmployee.getAddress()),
                person.getEmail(),
                4000,
                "Default",
                new AirlinePortImpl().readAirlineByName(apiEmployee.getAirlineName()),
                new Date()
        );
    }
}
