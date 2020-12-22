package minecraft.squidsquad;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito;

public class allTest{
    @Test
    public void testWillPass(){
        int a = 1;
        assertEquals(1, a);
    }

    @Mock
    Player player;
    MyPluginListener mypluginlistener;
    EntityShootBowEvent entityshootbowevent;
    


    @Test
    public void isMonsterShotFromArrowTest(){
        mypluginlistener.onEntityShootBowEvent(entityshootbowevent);
        
        assertEquals("Bucky", 0);
    }

}