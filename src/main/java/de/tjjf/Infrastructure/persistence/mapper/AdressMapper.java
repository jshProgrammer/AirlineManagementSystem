package de.tjjf.Infrastructure.persistence.mapper;

import de.tjjf.Domain.models.MAdress;

public class AdressMapper {
    public static MAdress toDomain(String adress){
        String[] splitted = adress.split(";");
        MAdress object = new MAdress(splitted[0], Integer.valueOf(splitted[1]), Integer.valueOf(splitted[2]), splitted[3], splitted[4]);
        return object;
    }

    public static String toEntity(MAdress mAdress){
        String adressString = mAdress.street+";"+mAdress.number+";"+mAdress.zipcode+";"+mAdress.city+";"+mAdress.country;
        return adressString;
    }
}
