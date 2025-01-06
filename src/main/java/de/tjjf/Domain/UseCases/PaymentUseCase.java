package de.tjjf.Domain.UseCases;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.*;
import com.stripe.param.*;
import de.tjjf.Domain.Exceptions.UnauthorizedException;
import de.tjjf.Domain.PasswordDecryption;
import de.tjjf.Domain.PasswordEncryption;
import de.tjjf.Domain.models.MPayment;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

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

    public static boolean paymentCall(int amountEuros, MPayment mPayment){
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
    public static String simulateCardToken(MPayment mPayment) {
        if ("4242424242424242".equals(mPayment.getCardNumber())) {
            return "tok_visa";
        } else if ("4000000000000341".equals(mPayment.getCardNumber())) {
            return "tok_chargeDeclined";
        } else {
            throw new RuntimeException("Ungültige Testkarte");
        }
    }



    public static boolean paymentImpl(int amountEuros, MPayment method) {
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

    // Methode zur Konvertierung von MPayment zu einer PaymentMethod
    public static String createPaymentMethodFromMPayment(MPayment mPayment) throws StripeException {

        try {
            Stripe.apiKey = PasswordDecryption.decryptPassword("src/main/java/de/tjjf/Domain/paymentApiKey.enc", "src/main/java/de/tjjf/Domain/paymentApiKey.key");
        } catch (Exception e) {
            throw new RuntimeException("Password could not be decrypted");
        }

        // Test-Kartendaten konfigurieren
        Map<String, Object> cardParams = new HashMap<>();
        cardParams.put("number", mPayment.getCardNumber());
        cardParams.put("exp_month", mPayment.getExpMonth());
        cardParams.put("exp_year", mPayment.getExpYear());
        cardParams.put("cvc", mPayment.getCvc());

        Map<String, Object> paymentMethodParams = new HashMap<>();
        paymentMethodParams.put("type", "card");
        paymentMethodParams.put("card", cardParams);

        // Erstellen der PaymentMethod in Stripe
        PaymentMethod paymentMethod = PaymentMethod.create(paymentMethodParams);
        System.out.println("Generated PaymentMethod ID: " + paymentMethod.getId());
        return paymentMethod.getId();
        //return "pm_card_visa";
    }

    public SetupIntent createSetupIntent() {
        // Setze deinen Secret API Key
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
            // Erstelle den SetupIntent
            SetupIntent setupIntent = SetupIntent.create(params);
            return setupIntent;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
