package model;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PositionTest {

    @Test
    public void shouldP22EqualsToP22() throws Exception {
        Position position = new Position(2,2);
        assertTrue(position.equals(new Position(2,2)));
    }

    @Test
    public void shouldP22NotEqualsToP12() throws Exception {
        Position position = new Position(2,2);
        assertFalse(position.equals(new Position(1,2)));
    }
}