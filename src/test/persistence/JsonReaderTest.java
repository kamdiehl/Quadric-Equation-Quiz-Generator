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
            StatsManager sc = reader.read();
            assertEquals("statHistory2", sc.getStatHistory());
            assertEquals(0, sc.getAllStats().size());
        } catch (IOException e) {
            System.out.println("Couldn't read from file");
        }
    }




    @Test
    void testReaderGeneralWorkRoom() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralWorkRoom.json");
        try {
            StatsManager st = reader.read();
            assertEquals("My work room", st.getStatHistory());
            List<StatValue> stats = st.getAllStats();
            StatValue stat = stats.get(0);
            assertEquals(2, stats.size());

            StatCategory category = StatCategory.values()[0];
            checkStatValue(category, stat.getValue());

        } catch (IOException e) {
          System.out.println("Couldn't read from file");
        }
    }

}
