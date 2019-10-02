import org.improving.tag.Exit;
import org.improving.tag.Location;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class ExitTests {

    @Test
    public void toString_should_include_name() {
        //arrange
        var target = new Exit("Door", new Location());
        //act
        var result = target.toString();
        //assert
        assertTrue(result.contains("Door"));
    }

    @Test
    public void equals_should_be_true_when_name_and_destination_match() {
        //arrange
        var destination = new Location();
        var exit1 = new Exit("door", destination);
        var exit2 = new Exit("door", destination, "this", "intentionally");
        //act
        var result = exit1.equals(exit2);
        //assert
        assertTrue(result);
    }
    @Test
    public void equals_should_be_false_when_compared_to_non_exit() {
        //arrange
        var destination = new Location();
        var exit1 = new Exit("door", destination);
        //act
        var result = exit1.equals("door");
        //assert
        assertFalse(result);
    }

    @Test
    public void equals_should_be_true_when_destinations_match() {
        //arrange
        var exit1 = new Exit("door", new Location());
        var exit2 = new Exit("door", new Location(), "this", "intentionally");
        //act
        var result = exit1.equals(exit2);
        //assert
        assertTrue(result);
    }
}
