package minecraft.squidsquad;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class allTest{
    @Test
    public void testWillPass(){
        int a = 1;
        assertEquals(1, a);
    }
    @Test
    public void thisTestWillNotFail(){
        int a = 1;
        assertNotEquals(2, a);
    }

}
