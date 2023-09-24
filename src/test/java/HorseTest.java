import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class HorseTest {

    @Test
    void nameIllegalArgumentExceptionHorse(){
        assertThrows(IllegalArgumentException.class, () ->
                    new Horse(null, 1.0, 1.0));
    }

    @Test
    void messageNameIllegalArgumentExceptionHorse(){
        Throwable exception = assertThrows(IllegalArgumentException.class, () ->
                new Horse(null, 1.0, 1.0));
        assertEquals( "Name cannot be null.", exception.getMessage());
    }

    @ParameterizedTest
    @CsvSource({
            ", 1.0, 1.0",
            " , 1.0, 1.0",
            "   , 1.0, 1.0"
    })
    void spaceNameIllegalArgumentExceptionHorse(String name, double speed, double distance){
        assertThrows(IllegalArgumentException.class, () ->
                new Horse(name, speed, distance));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "   "})
    void spaceMessageNameIllegalArgumentExceptionHorse(String name){
        Throwable exception = assertThrows(IllegalArgumentException.class, () ->
                new Horse(" ", 1.0, 1.0));
        assertEquals("Name cannot be blank.", exception.getMessage());
    }

    @Test
    void speedIllegalArgumentExceptionHorse(){
        assertThrows(IllegalArgumentException.class, () ->
                new Horse("name", -1.0, 1.0));
    }

    @Test
    void messageSpeedIllegalArgumentExceptionHorse(){
        Throwable exception = assertThrows(IllegalArgumentException.class, () ->
                new Horse("name", -1.0, 1.0));
        assertEquals("Speed cannot be negative.", exception.getMessage());
    }

    @Test
    void distanceIllegalArgumentExceptionHorse(){
        assertThrows(IllegalArgumentException.class, () ->
                new Horse("name", 1.0, -1.0));
    }

    @Test
    void messageDistanceIllegalArgumentExceptionHorse(){
        Throwable exception = assertThrows(IllegalArgumentException.class, () ->
                new Horse("name", 1.0, -1.0));
        assertEquals("Distance cannot be negative.", exception.getMessage());
    }

    @Test
    void getName(){
        Horse horse = new Horse("Name", 1.0, 2.0);
        String nameHorse = horse.getName();
        assertEquals("Name", nameHorse);
    }

    @Test
    void getSpeed(){
        Horse horse = new Horse("Name", 1.0, 2.0);
        double speedHorse = horse.getSpeed();
        assertEquals(1.0, speedHorse);
    }

    @Test
    void getDistance(){
        Horse horse = new Horse("Name", 1.0, 2.0);
        double distanceHorse = horse.getDistance();
        assertEquals(2.0, distanceHorse);
    }

    @Test //todo
    void move(){

    }
}