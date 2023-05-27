import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HorseTest {
    @Test
    public void nullNameException(){
        assertThrows(IllegalArgumentException.class, ()-> new Horse(null,1,1));
    }
    @Test
    public void  NullNameMessage(){
        try {
            new Horse(null, 1, 1);
        }
        catch (IllegalArgumentException e)
        {
            assertEquals("Name cannot be null.", e.getMessage());
        }

    }



}
