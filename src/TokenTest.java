import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TokenTest {

    @Test
    void getTokenString() {
        Token test = new Token("Hello!");
        assertEquals("Hello!", test.getTokenString());
    }

}