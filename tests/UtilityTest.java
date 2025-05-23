package tests;
import org.junit.Test;

import Utility.Utility;
import Position.Position;

import static org.junit.Assert.assertEquals;

public class UtilityTest {
    
    @Test
    public void testProcessRowGood() {
        char input = 'H';
        int expectedOutput = 7;
        Utility utility = new Utility();
        assertEquals(expectedOutput, utility.processRow(input));
    }

    @Test
    public void testProcessRowBad() {
        char input = 'Z';
        int expectedOutput = -1;
        Utility utility = new Utility();
        assertEquals(expectedOutput, utility.processRow(input));
    }

    @Test
    public void processFromPosition() {
        String input = "E2 E4";
        Position expectedOutput = new Position(6, 4);
        Utility utility = new Utility();
        assertEquals(expectedOutput.getRow(), utility.processFromPosition(input).getRow());
        assertEquals(expectedOutput.getColumn(), utility.processFromPosition(input).getColumn());
    }
}
