package persistence;

import model.StatCategory;
import model.StatValue;
import model.StatsManager;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonReaderTest extends JsonTest {

    // creds to JSON Serialization Demo.
    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            StatsManager st = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }



    @Test
    void testReaderEmptyWorkRoom() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyWorkRoom.json");
        try {
            StatsManager st = reader.read();
            assertEquals("My work room", st.getStatHistory());
            assertEquals(0, st.getAllStats().size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }




    @Test
    void testReaderGeneralWorkRoom() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralWorkRoom.json");
        try {
            StatsManager st = reader.read();
            assertEquals("My work room", st.getStatHistory());
            List<StatValue> stats = st.getAllStats();
            assertEquals(2, stats.size())
            ;
            StatCategory category = StatCategory.values()[0];
            checkStatValue(category, stats.get(0));

        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

}
