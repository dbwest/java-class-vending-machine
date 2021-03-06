package com.awesomevendingco.vendingmachine.machine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.awesomevendingco.vendingmachine.coins.MockCoinTranslator;

public class VendingMachine_WhenInvalidCoinInserted_Test {

    private VendingMachine machine;
    private String previousBlanace;

    @Before
    public void setup() {
        machine = new VendingMachine();
        machine.setCoinTranslator(new MockCoinTranslator());
        previousBlanace = machine.getBalance();
        machine.insertCoin(MockCoinTranslator.BAD_COIN);
    }

    @Test
    public void it_puts_coin_in_coin_return() {
        assertTrue(machine.getCoinReturn().contains(MockCoinTranslator.BAD_COIN));
    }

    @Test
    public void it_displays_message_of_invalid_coin() {
        assertEquals("INVALID COIN", machine.getMessage());
    }

    @Test
    public void it_does_not_change_balance() {
        assertEquals(previousBlanace, machine.getBalance());
    }

    @Test
    public void it_displays_message_of_insert_coin_when_valid_coin_inserted() {
        machine.insertCoin(MockCoinTranslator.GOOD_COIN);
        assertEquals("INSERT COIN", machine.getMessage());
    }

}
