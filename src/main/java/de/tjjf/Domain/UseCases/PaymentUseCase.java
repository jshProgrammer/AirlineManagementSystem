package de.tjjf.Domain.UseCases;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.model.PaymentMethod;
import de.tjjf.Domain.Exceptions.UnauthorizedException;
import de.tjjf.Domain.models.MPayment;

public class PaymentUseCase extends AuthorizedUseCase {

    public PaymentUseCase() {
        super(AuthenticationUseCase.getInstance());
    }

    public static boolean paymentCall(int amountEuros, MPayment mPayment) throws UnauthorizedException {
        //new CancelTicketUseCase().authorize();

        Stripe.apiKey = ("sk_test_51QKmmwGprcegLKPYNfuU5wgoOLFCnINfPbpKDClrxDfgfzYbSNoJyjjyLDM4xW14NuMTkU2g7J2Cg7WEbQQYjfTI00G5oHMHD0");
        Map<String, Object> params = new HashMap<>();
        params.put("amount", amountEuros * 100); // amount in cents
        params.put("currency", "eur");
        params.put("payment_method_types", new String[]{"card"}); // Simplification only one Card accepted
        try {
            Map<String, Object> cardParams = new HashMap<>();
            cardParams.put("number", mPayment.getCardNumber());
            cardParams.put("exp_month", mPayment.getExpMonth());
            cardParams.put("exp_year", mPayment.getExpYear());
            cardParams.put("cvc", mPayment.getCvc());

            Map<String, Object> paymentMethodParams = new HashMap<>();
            paymentMethodParams.put("type", "card");
            paymentMethodParams.put("card", cardParams);

            PaymentMethod paymentMethod = PaymentMethod.create(paymentMethodParams);

            PaymentIntent intent = PaymentIntent.create(params);
            return true;
        } catch (StripeException e) {
            System.out.println("Card declined");
            e.printStackTrace();
            return false;
        }

       /*
        System.out.println("PaymentIntent ID: " + intent.getId());
        System.out.println("Status: " + intent.getStatus());
        */

    }

    /*public static void main(String[] args) {
        boolean a = paymentCall(1000);
        System.out.println(a);

    }*/
}
