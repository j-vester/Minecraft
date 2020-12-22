package minecraft.squidsquad;
import org.bukkit.util.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class allTest{
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

    ////Windspeed tests////

    @Test
    public void vectorExists(){
        Vector wind = new Windspeed();
        assertNotNull(wind);
    }

    /////////////////////
}
