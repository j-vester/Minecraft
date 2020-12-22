package minecraft.squidsquad;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class WindspeedTest {
    @Test
    public void vectorExists(){
        Vector wind = new Windspeed();
        assertNotNull(wind);
    }
}
