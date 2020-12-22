package minecraft.squidsquad;
import org.bukkit.util.*;
import org.bukkit.entity.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class allTest{

    @Test 
    public void thisTestWillPass(){
        int a = 1;
        assertEquals(1, a);
    }

    @Test
    public void thisTestWillNotFail(){
        int a = 1;
        assertNotEquals(2, a);
    }

    ////Windspeed tests////

    @Test
    public void vectorExists(){
        Vector wind = new Windspeed();
        assertNotNull(wind);
    }

    @Test
    public void vectorIsSettable(){
        Vector wind = new Windspeed(1,2);
        assertEquals(1, wind.getX());
        assertEquals(2, wind.getY());
    }

    @Test
    public void vectorPropertiesCanBeChanged(){
        Vector wind = new Windspeed(1,1);
        assertEquals(1, wind.getX());
        wind.setX(3);
        assertEquals(3, wind.getX());
    }

    @Test
    public void vectorZDefaultsToZero(){
        Vector wind = new Windspeed();
        Vector setWind = new Windspeed(3, 2);
        assertEquals(0, wind.getZ());
        assertEquals(0, setWind.getZ());
    }
    
    //Instantiating a mock arrow to be used in tests
    Arrow arrow = mock(Arrow.class);    

    @Test
    public void testArrowExists(){
        assertNotNull(arrow);
    }

    @Test
    public void testArrowHasNoVelocity(){
        assertNull(arrow.getVelocity());
    }

    @Test
    public void testArrowCanBeGivenVelocity(){
        Vector velocity = new Vector(2, 3, 0);
        when(arrow.getVelocity()).thenReturn(velocity);
        //Verify works, but it doesn't change the actual
        //properties of the object:
        assertEquals(velocity, arrow.getVelocity());
    }

    /////////////////////
}
