import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class HippodromeTest {

    @Test
 public void emptyHorsesException()
 {
     IllegalArgumentException e = assertThrows(IllegalArgumentException.class,()->new Hippodrome(new ArrayList<>()));
 }

 @Test
    public void getHorses(){

     List<Horse> horses = new ArrayList<>();
    for(int i = 1; i < 30; i++)
     {
         horses.add(new Horse(""+i, i,i));
     }
    Hippodrome hippodrome = new Hippodrome(horses);
    assertEquals(horses,hippodrome.getHorses());

 }
 @Test
    public void move(){
        // arrange
        List<Horse> horses = new ArrayList<>();
        for (int i = 0; i < 50; i++ )
        {
            horses.add(mock(Horse.class));
        }
        //act
        Hippodrome hippodrome = new Hippodrome(horses);
        hippodrome.move();
        //assert
        for(Horse horse: horses){
            verify(horse).move();
        }

 }

}