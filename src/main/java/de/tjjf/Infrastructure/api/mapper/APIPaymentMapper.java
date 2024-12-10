package de.tjjf.Infrastructure.api.mapper;

import de.tjjf.Domain.models.MPayment;
import de.tjjf.Infrastructure.api.models.APIPayment;

public class APIPaymentMapper extends AbstractAPIMapper<APIPayment, MPayment> {


    @Override
    public APIPayment toAPIEntity(MPayment mPayment){
        return new APIPayment(
                mPayment.getCardNumber(),
                mPayment.getCvc(),
                mPayment.getExpMonth(),
                mPayment.getExpYear()
        );
    }

    @Override
    public MPayment toDomainEntity(APIPayment apiPayment){
        return new MPayment(
                apiPayment.getCardNumber(),
                apiPayment.getExpMonth(),
                apiPayment.getExpYear(),
                apiPayment.getCvc()
        );
    }
}
