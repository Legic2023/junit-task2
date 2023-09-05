import org.json.simple.parser.ParseException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class TestClass {

    @Test
    public void test1_jsonToList() throws ParseException {
// given:
        List<Employee> actualList = new ArrayList<>();
        Employee e1 = new Employee(1, "John", "Smith", "USA", 25);
        Employee e2 = new Employee(2, "Ivan", "Petrov", "RU", 23);
        actualList.add(e1);
        actualList.add(e2);

// when:
        List<Employee> expectedList = Main.jsonToList(Main.readString("new_data.json"));

// then:
        assertThat(expectedList, notNullValue());
        assertThat(actualList.toString(), is(expectedList.toString()));
    }

    @Test
    public void test2_jsonToList() throws ParseException {
// given:

// when:
        List<Employee> expectedList = Main.jsonToList(Main.readString("new_data.json"));

// then:
        assertThat(expectedList.get(0), sameInstance(expectedList.get(0)));
    }


}
