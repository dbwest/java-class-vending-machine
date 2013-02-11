package com.awesomevendingco.vendingmachine.coins;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class CoinTranslatorTest {

    private CoinTranslatorImpl translator;

    @Before
    public void setup() {
        translator = new CoinTranslatorImpl();
        translator.setCoinValues(coinValue());
    }

    private Map<String, Double> coinValue() {
        Map<String, Double> coinValues = new HashMap<String, Double>();
        coinValues.put(MockCoinTranslator.GOOD_COIN, 0.45);
        return coinValues;
    }

    @Test
    public void it_returns_value_of_coin() {
        double value = translator.valuateCoin(MockCoinTranslator.GOOD_COIN);
        assertEquals(0.45, value, 0.001);
    }

    @Test(expected = InvalidCoinException.class)
    public void it_throws_invalid_coin_exception_when_coin_is_invalid() {
        translator.valuateCoin(MockCoinTranslator.BAD_COIN);
    }

}
