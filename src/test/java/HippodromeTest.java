import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class HippodromeTest {

    @Test
    void illegalArgumentExceptionHippodrome(){
        assertThrows(IllegalArgumentException.class, () ->
                new Hippodrome(null));
    }

    @Test
    void messageIllegalArgumentExceptionHippodrome(){
        Throwable exception = assertThrows(IllegalArgumentException.class, () ->
                new Hippodrome(null));
        assertEquals( "Horses cannot be null.", exception.getMessage());
    }

    @Test
    void emptyIllegalArgumentExceptionHippodrome(){
        assertThrows(IllegalArgumentException.class, () ->
                new Hippodrome(List.of()));
    }

    @Test
    void messageEmptyIllegalArgumentExceptionHippodrome(){
        Throwable exception = assertThrows(IllegalArgumentException.class, () ->
                new Hippodrome(List.of()));
        assertEquals( "Horses cannot be empty.", exception.getMessage());
    }

    @Test
    void getHorses(){
        List<Horse> horses = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            horses.add(new Horse("horse_" + i, i, i));

            Hippodrome hippodrome = new Hippodrome(horses);

            assertEquals(horses, hippodrome.getHorses());
        }
    }

    @Test
    void move(){
        List<Horse> horses = new ArrayList<>();
        for (int i = 0; i < 30; i++){
            horses.add(mock(Horse.class));
        }

        Hippodrome hippodrome = new Hippodrome(horses);
        hippodrome.move();

        for (Horse horse: horses) {
            verify(horse).move();
        }
    }

    @Test
    void getWinner(){
        Horse horse1 = new Horse("Horse_1", 1.0, 1.0);
        Horse horse2 = new Horse("Horse_2", 1.0, 2.0);
        Horse horse3 = new Horse("Horse_3", 1.0, 3.0);

        Hippodrome hippodrome = new Hippodrome(List.of(horse1, horse2, horse3));

        Horse horseWinner = hippodrome.getWinner();

        assertEquals(horse3, horseWinner);
    }
}