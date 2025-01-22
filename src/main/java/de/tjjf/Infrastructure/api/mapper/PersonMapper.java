package de.tjjf.Infrastructure.api.mapper;

import de.tjjf.Domain.models.DomainPerson;
import de.tjjf.Infrastructure.api.models.APIClient;
import de.tjjf.Infrastructure.api.models.APIEmployee;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PersonMapper {

    public DomainPerson toDomain(APIEmployee apiEmployee){
        return new DomainPerson(
                apiEmployee.getEmployeeId(),
                apiEmployee.getFirstName(),
                apiEmployee.getMiddleNames(),
                apiEmployee.getLastName(),
                parseDate(apiEmployee.getDateOfBirth()),
                apiEmployee.getPhoneNumber(),
                new APIAddressMapper().toDomainEntity(apiEmployee.getAddress()),
                apiEmployee.getEmail(),
                null
        );
    }

    private Date parseDate(String date){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        Date parsedDate;
        try {
            parsedDate = formatter.parse(date);
            System.out.println("Parsed date: " + date);
        } catch (ParseException e) {
            throw new RuntimeException("Error parsing date: " + e.getMessage());
        }
        return parsedDate;
    }

    public DomainPerson toDomain(APIClient apiClient){
        return new DomainPerson(
                apiClient.getClientId(),
                apiClient.getFirstName(),
                apiClient.getMiddleNames(),
                apiClient.getLastName(),
                parseDate(apiClient.getDateOfBirth()),
                apiClient.getPhoneNumber(),
                new APIAddressMapper().toDomainEntity(apiClient.getAddress()),
                apiClient.getEmail(),
                null
        );
    }


}
