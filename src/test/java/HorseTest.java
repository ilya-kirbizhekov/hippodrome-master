import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.MockedStatic;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mockStatic;

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
    @Test
    public void getName() throws NoSuchFieldException, IllegalAccessException {
        Horse horse = new Horse("qwerty", 1, 1);
        Field name = Horse.class.getDeclaredField("name");
        name.setAccessible(true);
        String nameValue = (String) name.get(horse);
        assertEquals("qwerty", nameValue);
    }
    @ Test
    public void GetSpeed(){
        double expectedSpeed = 443;
        Horse horse = new Horse("qqerty", expectedSpeed, 1);
        assertEquals(expectedSpeed, horse.getSpeed());
    }

    @ Test
    public void GetDistance(){
        Horse horse = new Horse("qqerty", 1, 200);
        assertEquals(200, horse.getDistance());
    }
    @Test
    public void zeroDistanceByDefault(){
        Horse horse = new Horse("qerty", 1);
        assertEquals(0,horse.getDistance());
    }
    @Test
    void moveUsesGetRandom(){
        try (MockedStatic<Horse> mockedStatic = mockStatic(Horse.class)){
         new Horse("qwerty",1,1).move();
         mockedStatic.verify(()->Horse.getRandomDouble(0.2,0.9));

        }

    }
    @ParameterizedTest
    @ValueSource(doubles = {0.1,0.2,0.5,0.9,999.999,0.0})
    void move(double random)
    {
        try (MockedStatic<Horse> mockedStatic = mockStatic(Horse.class)) {
            Horse horse = new Horse("rrr", 31, 283);
            mockedStatic.when(()->Horse.getRandomDouble(0.2,0.9)).thenReturn(random);
            horse.move();
            assertEquals(283+31 * random, horse.getDistance());

        }

    }


}
