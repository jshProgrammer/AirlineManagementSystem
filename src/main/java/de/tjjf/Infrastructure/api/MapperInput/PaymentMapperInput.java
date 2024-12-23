package de.tjjf.Infrastructure.api.MapperInput;

import de.tjjf.Infrastructure.api.InputModels.APIPaymentInput;
import de.tjjf.Infrastructure.api.InputModels.APITicketInput;
import de.tjjf.Infrastructure.api.models.APIPayment;
import de.tjjf.Infrastructure.api.models.APITicket;

public class PaymentMapperInput {

    public APIPaymentInput toClient(APIPayment payment){
        return new APIPaymentInput(
                payment.getCardNumber(),
                payment.getExpMonth(),
                payment.getExpYear(),
                payment.getCvc()
        );
    }

    public APIPayment toDomain(APIPaymentInput payment){
        return new APIPayment(
                payment.getCardNumber(),
                payment.getExpMonth(),
                payment.getExpYear(),
                payment.getCvc()
        );
    }
}