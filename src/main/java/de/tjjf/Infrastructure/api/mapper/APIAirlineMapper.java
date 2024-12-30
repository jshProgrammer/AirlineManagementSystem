package de.tjjf.Infrastructure.api.mapper;

import de.tjjf.Domain.models.MAirline;
import de.tjjf.Infrastructure.api.models.APIAirline;
import de.tjjf.Infrastructure.persistence.entities.Airline;
import de.tjjf.Infrastructure.persistence.mapper.AddressMapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class APIAirlineMapper extends AbstractAPIMapper<APIAirline, MAirline> {

    @Override
    public APIAirline toAPIEntity(MAirline mAirline) {
        return new APIAirline(
                mAirline.getName(),
                mAirline.getFoundationYear().toString(),
                new APIAddressMapper().toAPIEntity(mAirline.getAddress()),
                mAirline.getPhoneNumber(),
                mAirline.getEmail()
        );
    }

    @Override
    public MAirline toDomainEntity(APIAirline model) {
        //TODO: headquarters wieder in api implementieren, sonst bei update gelöscht!
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        Date date;
        try {
            date = formatter.parse(model.getFoundationYear());
            System.out.println("Parsed date: " + date);
        } catch (ParseException e) {
            throw new RuntimeException("Error parsing date: " + e.getMessage());
        }
        return new MAirline(
                model.getName(),
                date,
                "",
                new APIAddressMapper().toDomainEntity(model.getAddress()),
                model.getPhoneNumber(),
                model.getEmail()
        );
    }
}
