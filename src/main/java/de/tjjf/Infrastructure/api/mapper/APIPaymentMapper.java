package de.tjjf.Infrastructure.api.mapper;

import de.tjjf.Domain.models.DomainPayment;
import de.tjjf.Infrastructure.api.models.APIPayment;

public class APIPaymentMapper extends AbstractAPIMapper<APIPayment, DomainPayment> {


    @Override
    public APIPayment toAPIEntity(DomainPayment mPayment){
        return new APIPayment(
                mPayment.getCardNumber(),
                mPayment.getCvc(),
                mPayment.getExpMonth(),
                mPayment.getExpYear()
        );
    }

    @Override
    public DomainPayment toDomainEntity(APIPayment apiPayment){
        return new DomainPayment(
                apiPayment.getCardNumber(),
                apiPayment.getExpMonth(),
                apiPayment.getExpYear(),
                apiPayment.getCvc()
        );
    }
}
