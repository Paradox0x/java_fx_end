package cityapp;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RexExAppTest {

    @org.junit.jupiter.api.Test
    void getZipCode() {
        //GIVEN
        RexExApp app = new RexExApp();
        String input = null;
        //WHEN
        List<String> result = app.getZipCode(input);
        //THAN
        assertNotNull(result);
        assertEquals(result.size(), 1);
        assertEquals(result.get(0), "12-345");
        assertEquals(result.get(1), "34-567");


        
    }
}