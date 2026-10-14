import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumTokenTest {

    @Test
    void getTokenString() {
        NumToken test = new NumToken("5");
        assertEquals("5", test.getTokenString());
    }

}