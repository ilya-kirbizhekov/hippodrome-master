import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
    @ParameterizedTest
    @ValueSource(strings = {"","    ", "\t\t", "\n\n\n\n\n\n\n"})
    void BlankNameException(String name)
    {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, ()->new Horse(name,1,1));
        assertEquals("Name cannot be blank.",e.getMessage());
    }



}
