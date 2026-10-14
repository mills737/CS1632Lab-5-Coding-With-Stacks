import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OpTokenTest {

    @Test
    void getOperator() {
        OpToken test = new  OpToken(11);
        assertEquals(test.getOperator(),11);
    }

    @Test
    void getPrecedence() {
        OpToken test = new  OpToken(11);
        assertEquals(test.getPrecedence(),0);
    }
}