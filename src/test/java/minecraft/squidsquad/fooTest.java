package minecraft.squidsquad;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class fooTest{

    @Test
    public void testWillPass(){
        int a = 1;
        assertEquals(1, a);
    }

    @Test
    public void thisTestWillFail(){
        int a = 1;
        assertEquals(2, a);
    }

}
