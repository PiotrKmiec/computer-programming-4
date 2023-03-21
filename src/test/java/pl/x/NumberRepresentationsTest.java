package pl.x;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

public class NumberRepresentationsTest {
    @Test
    void testDoubleRepresentation() {
        double a = 0.02d;
        double b = 0.03d;
        double c = b - a;

        assertEquals(0.01d, c);
    }

    @Test
    void testBigDecimalRepresentation() {
        BigDecimal a = BigDecimal.valueOf(0.02d);
        BigDecimal b = BigDecimal.valueOf(0.03d);
        BigDecimal c = b.subtract(a);

        assertEquals(0, c.compareTo(BigDecimal.valueOf(0.01d)));
    }
}
