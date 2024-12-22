package de.tjjf.Infrastructure.api.MapperInput;

import de.tjjf.Infrastructure.api.InputModels.APIAddressInput;
import de.tjjf.Infrastructure.api.InputModels.APIPaymentInput;
import de.tjjf.Infrastructure.api.models.APIAddress;
import de.tjjf.Infrastructure.api.models.APIPayment;

public class AddressMapperInput {

    public APIAddressInput toClient(APIAddress address){
        return new APIAddressInput(
                address.getStreet(),
                address.getNumber(),
                address.getZipcode(),
                address.getCity(),
                address.getCountry()
        );
    }

    public APIAddress toDomain(APIAddressInput address){
        return new APIAddress(
                address.getStreet(),
                address.getNumber(),
                address.getZipcode(),
                address.getCity(),
                address.getCountry()
        );
    }
}
