import org.json.simple.parser.ParseException;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.Files.readString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class MainTest {

    @Test
    public void testJsonToList_returnNotNull_success() throws ParseException {
// given: expectedList not null

// when:
        List<Employee> expectedList = Main.jsonToList(Main.readString("new_data.json"));

// then:
        assertThat(expectedList, notNullValue());
    }

    @Test
    public void testJsonToList_listValidValues_success() throws ParseException {
// given:
        List<Employee> actualList = new ArrayList<>();
        Employee e1 = new Employee(1, "John", "Smith", "USA", 25);
        Employee e2 = new Employee(2, "Ivan", "Petrov", "RU", 23);
        actualList.add(e1);
        actualList.add(e2);

// when:
        List<Employee> expectedList = Main.jsonToList(Main.readString("new_data.json"));

// then:
        assertThat(actualList, samePropertyValuesAs(expectedList));
    }


    @Test
    public void testReadString_IOException_expected() {
// given: IOException not expected
        String fileName = "new_data.json";
// when: IOException expected
        String fileName_expected = "fileNotExist.json";
// then:

        try {
            String json = readString(Path.of(fileName_expected)); //file Not Exist
            Assertions.fail("Expected IOException");
        } catch (IOException e) {

            assertThat(e, instanceOf(IOException.class));

        }


    }


}
