package de.tjjf.Infrastructure.api.mapper;

import de.tjjf.Domain.models.MEmployee;
import de.tjjf.Domain.models.MPerson;
import de.tjjf.Infrastructure.api.models.APIEmployee;
import de.tjjf.Adapter.APIAdapter.AirlinePortImpl;

public class APIEmployeeMapper extends AbstractAPIMapper<APIEmployee, MEmployee>{
    @Override
    public APIEmployee toAPIEntity(MEmployee mEmployee) {
        return new APIEmployee(
                mEmployee.getPersonId(),
                mEmployee.getFirstName(),
                mEmployee.getMiddleNames(),
                mEmployee.getLastName(),
                mEmployee.getAirline().getName(),
                mEmployee.getEmail(),
                new APIAddressMapper().toAPIEntity(mEmployee.getAddress()),
                mEmployee.getPhonenumber(),
                mEmployee.getDateOfBirth()
        );
    }

    @Override
    public MEmployee toDomainEntity(APIEmployee apiEmployee) {
        MPerson person = new PersonMapper().toDomain(apiEmployee);
        return new MEmployee(
                person.getPersonId(),
                person.getFirstName(),
                person.getMiddleNames(),
                person.getLastName(),
                person.getDateOfBirth(),
                person.getPhonenumber(),
                new APIAddressMapper().toDomainEntity(apiEmployee.getAddress()), person.getEmail(),
                //TODO: was hier tun? salary echt einfach auf 0 initalisieren?
                0,
                null,
                new AirlinePortImpl().readAirlineByName(apiEmployee.getAirlineName()),
                null
        );
    }
}
