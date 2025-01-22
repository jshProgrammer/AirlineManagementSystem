package de.tjjf.Infrastructure.api.mapper;

import de.tjjf.Domain.models.DomainAirline;
import de.tjjf.Infrastructure.api.models.APIAirline;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class APIAirlineMapper extends AbstractAPIMapper<APIAirline, DomainAirline> {

    @Override
    public APIAirline toAPIEntity(DomainAirline mAirline) {
        return new APIAirline(
                mAirline.getName(),
                mAirline.getFoundationYear().toString(),
                new APIAddressMapper().toAPIEntity(mAirline.getAddress()),
                mAirline.getPhoneNumber(),
                mAirline.getEmail()
        );
    }

    @Override
    public DomainAirline toDomainEntity(APIAirline model) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        Date date;
        try {
            date = formatter.parse(model.getFoundationYear());
        } catch (ParseException e) {
            throw new RuntimeException("Error parsing date: " + e.getMessage());
        }
        return new DomainAirline(
                model.getName(),
                date,
                "Default",
                new APIAddressMapper().toDomainEntity(model.getAddress()),
                model.getPhoneNumber(),
                model.getEmail()
        );
    }
}
