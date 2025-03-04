package de.tjjf.LogicTests;

import de.tjjf.Domain.UseCases.PaymentUseCase;
import de.tjjf.Domain.models.DomainPayment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class PaymentTest {
    PaymentUseCase puc = new PaymentUseCase();

    @Test
    void successfulPaymentTest(){
        DomainPayment mp = new DomainPayment("4242424242424242", "12", "34", "567");
        boolean result = PaymentUseCase.paymentCall(10, mp);

        Assertions.assertTrue(result, "Die Zahlung sollte erfolgreich sein");
    }

    @Test
    void declinedCreditCardTest(){
        DomainPayment mp = new DomainPayment("4000000000000341", "12", "34", "1234");
        boolean result = PaymentUseCase.paymentCall(10, mp);
        Assertions.assertFalse(result, "Die Zahlung sollte fehlschlagen");
    }


}
