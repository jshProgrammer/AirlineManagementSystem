package de.tjjf.Domain.UseCases;

import java.util.HashMap;
import java.util.Map;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.*;
import com.stripe.param.*;
import de.tjjf.Domain.PasswordDecryption;
import de.tjjf.Domain.models.DomainPayment;

public class PaymentUseCase extends AuthorizedUseCase {

    public PaymentUseCase() {
        super(AuthenticationUseCase.getInstance());
    }

    static{
        try {
            Stripe.apiKey = PasswordDecryption.decryptPassword("src/main/java/de/tjjf/Domain/paymentApiKey.enc", "src/main/java/de/tjjf/Domain/paymentApiKey.key");
        } catch (Exception e) {
            throw new RuntimeException("Password could not be decrypted");
        }
    }

    public static boolean paymentCall(int amountEuros, DomainPayment mPayment){
        String token = simulateCardToken(mPayment);
        return paymentImpl(amountEuros, token);
    }
    //Gibt Token zurück, ziehen uns in Payment Call nur die ID davon, leider Frontend möglich und nicht so lösbar wegen Testkarten
    /*public static Token createToken(MPayment mPayment){
        TokenCreateParams.Card card = TokenCreateParams.Card.builder()
                .setNumber(mPayment.getCardNumber())
                .setExpMonth(mPayment.getExpMonth())
                .setExpYear(mPayment.getExpYear())
                .setCvc(mPayment.getCvc())
                .build();

        TokenCreateParams params = TokenCreateParams.builder()
                .setCard(card)
                .build();

        try {
            return Token.create(params);
        } catch (StripeException e) {
            throw new RuntimeException(e);
        }
    }*/
    public static String simulateCardToken(DomainPayment mPayment) {
        if ("4242424242424242".equals(mPayment.getCardNumber())) {
            return "tok_visa";
        } else if ("4000000000000341".equals(mPayment.getCardNumber())) {
            return "tok_chargeDeclined";
        } else {
            throw new RuntimeException("Ungültige Testkarte");
        }
    }



    public static boolean paymentImpl(int amountEuros, DomainPayment method) {
        boolean result = false;
        try {
            Stripe.apiKey = PasswordDecryption.decryptPassword("src/main/java/de/tjjf/Domain/paymentApiKey.enc", "src/main/java/de/tjjf/Domain/paymentApiKey.key");
        } catch (Exception e) {
            throw new RuntimeException("Password could not be decrypted");
        }
        return result;
    }

    public static boolean paymentImpl(int amountEuros, String tokenId)  {
        //new CancelTicketUseCase().authorize();
        try {
            Stripe.apiKey = PasswordDecryption.decryptPassword("src/main/java/de/tjjf/Domain/paymentApiKey.enc", "src/main/java/de/tjjf/Domain/paymentApiKey.key");
        } catch (Exception e) {
            throw new RuntimeException("Password could not be decrypted");
        }
        try {
            Map<String, Object> paymentMethodParams = new HashMap<>();
            paymentMethodParams.put("type", "card");
            paymentMethodParams.put("card", Map.of("token", tokenId));  // 'tok_visa' als Beispiel
            PaymentMethod paymentMethod = PaymentMethod.create(paymentMethodParams);

            Map<String, Object> params = new HashMap<>();
            params.put("amount", amountEuros * 100); // Betrag in Cent
            params.put("currency", "eur");
            params.put("payment_method", paymentMethod.getId());
            //params.put("confirmation_method", "automatic");
            params.put("confirm", true);
            params.put("return_url", "https://www.deinewebsite.de/payment-success");

            Map<String, Object> automaticPaymentMethods = new HashMap<>();
            automaticPaymentMethods.put("enabled", true);
            params.put("automatic_payment_methods", automaticPaymentMethods);


            PaymentIntent intent = PaymentIntent.create(params);
            if ("succeeded".equals(intent.getStatus())) {
                System.out.println("Payment successful");
                return true;
            } else {
                System.out.println("Payment failed with status: " + intent.getStatus());
                return false;
            }
        } catch (StripeException e) {
            System.out.println("Payment failed due to an error:");
            e.printStackTrace();
            return false;
        }

    }

    public static String createPaymentMethodFromMPayment(DomainPayment mPayment) throws StripeException {

        try {
            Stripe.apiKey = PasswordDecryption.decryptPassword("src/main/java/de/tjjf/Domain/paymentApiKey.enc", "src/main/java/de/tjjf/Domain/paymentApiKey.key");
        } catch (Exception e) {
            throw new RuntimeException("Password could not be decrypted");
        }

        Map<String, Object> cardParams = new HashMap<>();
        cardParams.put("number", mPayment.getCardNumber());
        cardParams.put("exp_month", mPayment.getExpMonth());
        cardParams.put("exp_year", mPayment.getExpYear());
        cardParams.put("cvc", mPayment.getCvc());

        Map<String, Object> paymentMethodParams = new HashMap<>();
        paymentMethodParams.put("type", "card");
        paymentMethodParams.put("card", cardParams);

        PaymentMethod paymentMethod = PaymentMethod.create(paymentMethodParams);
        System.out.println("Generated PaymentMethod ID: " + paymentMethod.getId());
        return paymentMethod.getId();
        //return "pm_card_visa";
    }

    public SetupIntent createSetupIntent() {
        try {
            Stripe.apiKey = PasswordDecryption.decryptPassword("src/main/java/de/tjjf/Domain/paymentApiKey.enc", "src/main/java/de/tjjf/Domain/paymentApiKey.key");  // Ersetze mit deinem Secret Key
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        SetupIntentCreateParams params = SetupIntentCreateParams.builder()
                .setUsage(SetupIntentCreateParams.Usage.OFF_SESSION)  // Optional
                .build();

        try {
            SetupIntent setupIntent = SetupIntent.create(params);
            return setupIntent;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
