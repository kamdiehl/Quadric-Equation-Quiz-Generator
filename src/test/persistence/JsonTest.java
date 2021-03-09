package persistence;

import model.StatCategory;
import model.StatValue;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {

    protected void checkStatValue(StatCategory category, StatValue value) {
        assertEquals(value, value.getValue());
        assertEquals(category, value.getCategory());

    }
}
