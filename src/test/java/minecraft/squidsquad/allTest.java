package minecraft.squidsquad;
import org.bukkit.util.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class allTest{

    ////Windspeed tests////

    @Test
    public void vectorExists(){
        Vector wind = new Windspeed();
        assertNotNull(wind);
    }

    @Test
    public void vectorIsSettable(){
        Vector wind = new Windspeed(1,2,3);
        assertEquals(1, wind.getX());
        assertEquals(2, wind.getY());
        assertEquals(3, wind.getZ());
    }

    @Test
    public void vectorPropertiesCanBeChanged(){
        Vector wind = new Windspeed(1,1,1);
        assertEquals(1, wind.getX());
        wind.setX(3);
        assertEquals(3, wind.getX());
    }

    /////////////////////
}
