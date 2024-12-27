package de.tjjf.LogicTests;

import de.tjjf.Domain.models.MFlight;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//should work 23.12.24
public class FlightLuggageTest {
    MFlight mFlight = new MFlight(999999, null, null, null, null, null,null,null,0,null,null);

    @Test
    public void testNegativeValueInitial(){
        int negativeValue = -1;
        assertThrows(IllegalArgumentException.class, () -> {mFlight.addCurrentInitialLuggageWeight(negativeValue);});
    }

    @Test
    public void testPositiveValueInitial(){
        int positiveValue = 1;
        assertDoesNotThrow(() -> {mFlight.addCurrentInitialLuggageWeight(positiveValue);});
    }


    @Test
    public void testZeroValueInitial(){
        int zeroValue = 0;
        assertThrows(IllegalArgumentException.class, () -> {mFlight.addCurrentInitialLuggageWeight(zeroValue);});
    }


    @Test
    public void testNegativeValueUpgrade(){
        int negativeValue = -1;
        assertThrows(IllegalArgumentException.class, () -> {mFlight.addCurrentUpgradeLuggageWeight(negativeValue);});
    }

    @Test
    public void testPositiveValueUpgrade(){
        int positiveValue = 1;
        assertDoesNotThrow(() -> mFlight.addCurrentUpgradeLuggageWeight(positiveValue));
    }

    @Test
    public void testZeroValueUpgrade(){
        int zeroValue = 0;
        assertThrows(IllegalArgumentException.class, () -> {mFlight.addCurrentUpgradeLuggageWeight(zeroValue);});
    }
}
