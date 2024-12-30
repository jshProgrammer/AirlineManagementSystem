package de.tjjf.Infrastructure.api.MapperInput;

import de.tjjf.Infrastructure.api.InputModels.APIAddressInput;
import de.tjjf.Infrastructure.api.InputModels.APIAirlineInput;
import de.tjjf.Infrastructure.api.models.APIAddress;
import de.tjjf.Infrastructure.api.models.APIAirline;

public class AirlineMapperInput {

    public APIAirlineInput toClient(APIAirline airline){
        APIAddressInput apiAddress = new AddressMapperInput().toClient(airline.getAddress());
        return new APIAirlineInput(
                airline.getName(),
                airline.getFoundationYear(),
                apiAddress,
                airline.getPhoneNumber(),
                airline.getEmail()
        );
    }

    public APIAirline toDomain(APIAirlineInput airline) {
        System.out.println("TEST.D" + airline.getAddress());
        System.out.println("TEST.D2" + airline.getAddress().getCity());
        System.out.println("TEST.D2" + airline.getAddress().getCountry());
        System.out.println("TEST.D2" + airline.getAddress().getStreet());
        System.out.println("TEST.D2" + airline.getAddress().getNumber());
        System.out.println("TEST.D2" + airline.getAddress().getZipCode());

        APIAddress apiAddress = new AddressMapperInput().toDomain(airline.getAddress());
        System.out.println("TEST.C");
        System.out.println("TEST.C" + airline.getFoundationYear());
        return new APIAirline(
                airline.getName(),
                airline.getFoundationYear(),
                apiAddress,
                airline.getPhoneNumber(),
                airline.getEmail()
        );
    }
}
