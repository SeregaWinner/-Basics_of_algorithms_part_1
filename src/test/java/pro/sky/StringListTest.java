package pro.sky;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringListTest {
    private final StringList stringList = new StringListImpl();

    private final String[] repositorySize = new String[10];

    @BeforeEach
    public void beforeEach(){
        repositorySize.
    }
    @Test
    void add1Test(){
        String expected = "шесть";

        assertEquals(stringList.add("шесть"),expected);
    }
    @Test
    void add2Test(){
        int expected = 6;
        assertEquals(stringList.add(6,"семь"),expected);
    }





}
