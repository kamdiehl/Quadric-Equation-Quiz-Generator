package persistence;

import model.StatCategory;
import model.StatValue;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {

    protected void checkStatValue(StatCategory category, int value) {
        StatValue st = new StatValue(category, value);
        assertEquals(value, st.getValue());
        assertEquals(category, st.getCategory());

    }
}
