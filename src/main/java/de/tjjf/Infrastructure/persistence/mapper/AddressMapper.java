package de.tjjf.Infrastructure.persistence.mapper;

import de.tjjf.Domain.models.MAddress;

public class AddressMapper {
    public static MAddress toDomain(String adress){
        String[] splitted = adress.split(";");
        MAddress object = new MAddress(splitted[0], Integer.valueOf(splitted[1]), Integer.valueOf(splitted[2]), splitted[3], splitted[4]);
        return object;
    }

    public static String toEntity(MAddress mAddress){
        String addressString = mAddress.street+";"+ mAddress.number+";"+ mAddress.zipcode+";"+ mAddress.city+";"+ mAddress.country;
        return addressString;
    }
}
