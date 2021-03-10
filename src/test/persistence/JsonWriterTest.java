package persistence;

import model.StatCategory;
import model.StatValue;
import model.StatsManager;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonWriterTest extends JsonTest{


    @Test
    void testWriterInvalidFile() {
        try {
            StatsManager st = new StatsManager("statHistory");
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass!
        }
     }

     @Test
     void testWriterEmptyStatsManager() {
        try {
            StatsManager st = new StatsManager("statHistory");
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyWorkroom.json");
            writer.open();
            writer.write(st);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyWorkroom.json");
            st = reader.read();
            assertEquals("statHistory", st.getStatHistory());
            assertEquals(0, st.getAllStats().size());

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
     }



     @Test
     void testWriterGeneralStatList() {
        try {
            StatsManager st = new StatsManager("statHistory2");

            StatCategory category1 = StatCategory.values()[0];
            StatCategory category2 = StatCategory.values()[1];
            StatCategory category3 = StatCategory.values()[2];

            StatValue correctAnswers = new StatValue(category1, 4);
            StatValue incorrectAnswers = new StatValue(category2, 6);
            StatValue quizLength = new StatValue(category3, 10);

            st.addStat(correctAnswers);
            st.addStat(incorrectAnswers);
            st.addStat(quizLength);

            JsonWriter writer = new JsonWriter("./data/testWriterGeneralStatList.json");
            writer.open();
            writer.write(st);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralStatList.json");
            st = reader.read();

            assertEquals("statHistory2", st.getStatHistory());
            List<StatValue> allStats = st.getAllStats();
            assertEquals(3, allStats.size());

            checkStatValue(category1.CorrectAnswers, correctAnswers.getValue());
            checkStatValue(category1.IncorrectAnswers, incorrectAnswers.getValue());
            checkStatValue(category1.QuestionsAsked, quizLength.getValue());


        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
     }
}
