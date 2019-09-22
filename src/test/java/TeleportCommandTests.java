import org.improving.tag.commands.DanceCommand;
import org.improving.tag.commands.TeleportCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TeleportCommandTests {

    TeleportCommand target;
    TestInputOutput io;

    @BeforeEach
    public void arrange() {
        //Arrange
        io = new TestInputOutput();
        target = new TeleportCommand(io);
    }

    @Test
    public void execute_should_return_phrase() {
        //Act
        target.execute(null);

        //Assert
        assertEquals("You phase out of existence.", io.lastText);
    }

    @Test
    public void isValid_should_return_true_when_input_is_teleport() {

        //Act
        var result = target.isValid("teleport");

        //Assert
        assertTrue(result);
    }

    @Test
    public void isValid_should_return_true_when_input_is_teleport_with_spaces() {

        //Act
        var result = target.isValid("     teleport  ");

        //Assert
        assertTrue(result);
    }

    @Test
    public void isValid_should_return_true_when_input_is_teleport_with_caps() {

        //Act
        var result = target.isValid("TeLePoRt");

        //Assert
        assertTrue(result);
    }

    @Test
    public void isValid_should_be_false_when_input_is_foobar() {


        //Act
        var result = target.isValid("foobar");

        //Assert
        assertFalse(result);
    }

    @Test
    public void isValid_should_be_false_when_input_is_null() {


        //Act
        var result = target.isValid(null);

        //Assert
        assertFalse(result);
    }

}
