package de.tjjf.LogicTests;

import de.tjjf.Domain.UseCases.PaymentUseCase;
import de.tjjf.Domain.models.MPayment;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

//should work 23.12.24
public class PaymentTest {

    PaymentUseCase puc = new PaymentUseCase();

    @Test
    void successfulPaymentTest(){
        MPayment mp = new MPayment("4242424242424242", "234", "1234", "1234");
        assertTrue(puc.paymentCall(250, mp));
    }

    @Test
    void declinedCreditCardTest(){
        MPayment mp = new MPayment("4000000000009995", "234", "1234", "1234");
        assertFalse(puc.paymentCall(250 , mp));
    }


}
