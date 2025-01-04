package de.tjjf.LogicTests;

import de.tjjf.Domain.UseCases.PaymentUseCase;
import de.tjjf.Domain.models.MPayment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

//should work 23.12.24
public class PaymentTest {
    //TODO: Wie machen wir es mit Testen? Switch Case für Card Numbers? Schwierig oder ich bin zu blöd für wegen Token
    PaymentUseCase puc = new PaymentUseCase();

    @Test
    void successfulPaymentTest(){
        MPayment mp = new MPayment("4242424242424242", "12", "34", "567");
        //assertTrue(puc.paymentCall(250, mp));
        boolean result = PaymentUseCase.paymentCall(10, mp);

        Assertions.assertTrue(result, "Die Zahlung sollte erfolgreich sein");
    }

    @Test
    void declinedCreditCardTest(){
        MPayment mp = new MPayment("4000000000000341", "12", "34", "1234");
        boolean result = PaymentUseCase.paymentCall(10, mp);
        Assertions.assertFalse(result, "Die Zahlung sollte fehlschlagen");
    }


}
