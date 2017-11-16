package utils;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class OperationsTest {
    @Test
    public void sumArrayTest() throws Exception {
        long l = Operations.sumArray(new int[]{1, 23, 4, 5});
        assertEquals(l,33);
    }

    @Rule
    public ExpectedException arrayWithNullException = ExpectedException.none();

    @Test
    public void sumArrayTestWithNull() throws Exception {
        arrayWithNullException.expectMessage("Input array cannot be null");
        arrayWithNullException.expect(IllegalStateException.class);
        long l = Operations.sumArray(null);
    }
}