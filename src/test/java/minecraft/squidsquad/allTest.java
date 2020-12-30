package minecraft.squidsquad;
import org.bukkit.util.Vector;
import org.bukkit.entity.Arrow;
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
        Windspeed wind = new Windspeed();
        assertNotNull(wind);
    }

    @Test
    public void vectorIsSettable(){
        Windspeed wind = new Windspeed(1,2);
        assertEquals(1, wind.getX());
        assertEquals(2, wind.getZ());
    }

    @Test
    public void vectorPropertiesCanBeChanged(){
        Windspeed wind = new Windspeed(1,1);
        assertEquals(1, wind.getX());
        assertEquals(1, wind.getZ());
        wind.changeWindDirection(3, 4);
        //vector is normalized, so divided by length.
        //the length of the vector(3, 4) is sqrt(27).
        //the closest int approximation is 5, therefore
        //the individual values are divided by 5.
        assertNotEquals(3, wind.getX());
        assertNotEquals(4, wind.getZ());
        assertEquals(0.6, wind.getX());
        assertEquals(0.8, wind.getZ());
        assertEquals(1, wind.length());
    }

    @Test
    public void vectorYDefaultsToZero(){
        Windspeed wind = new Windspeed();
        Windspeed setWind = new Windspeed(3, 2);
        assertEquals(0, wind.getY());
        assertEquals(0, setWind.getY());
    }

    @Test 
    public void vectorYCannotBeChanged(){
        Windspeed wind = new Windspeed();
        assertEquals(0, wind.getY());
        wind.setY(4);
        assertEquals(0, wind.getY());
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
        assertEquals(velocity, arrow.getVelocity());
    }

    @Test
    public void arrowCanInteractWithWind(){
        Vector velocity = new Vector(2, 3, 0);
        Windspeed wind = new Windspeed(3, 4);
        when(arrow.getVelocity()).thenReturn(velocity);
        assertEquals(velocity, arrow.getVelocity());
        Vector newVelocity = wind.applyWindToProjectile(velocity);
        assertEquals(((wind.clone()).add(velocity)).length(), newVelocity.length());
        assertEquals(((wind.clone()).add(velocity)).getX(), newVelocity.getX());
        assertEquals(((wind.clone()).add(velocity)).getY(), newVelocity.getY());
        assertEquals(((wind.clone()).add(velocity)).getZ(), newVelocity.getZ());
    }

    /////////////////////

}
