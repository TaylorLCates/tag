import org.improving.tag.Game;
import org.improving.tag.Player;
import org.improving.tag.SpringContext;
import org.improving.tag.commands.SetNameCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class SetNameTests {
    SetNameCommand target;
    TestInputOutput io;
    Game game;

    @BeforeEach
    public void arrange() {
        //Arrange
        io = new TestInputOutput();
        target = new SetNameCommand(io);
        game = mock(Game.class);

        Player player = new Player(null);
        player.setName("hi");
        when(game.getPlayer()).thenReturn(player);

    }

    @Test
    public void isValid_should_return_true_when_input_is_set_name() {

        //Act
        var result = target.isValid("@set name=chuck norris", null);

        //Assert
        assertTrue(result);
    }

    @Test
    public void isValid_should_be_false_when_input_is_null() {
        //Act
        var result = target.isValid(null, null);

        //Assert
        assertFalse(result);
    }

    @Test
    public void isValid_should_be_false_when_input_does_not_contain_equal_sign() {
        var result = target.isValid("@set name to fluefedor", null);

        assertFalse(result);
    }

    @Test
    public void isValid_should_be_false_when_input_is_only_set_name() {

        var result = target.isValid("@set name=", null);

        assertFalse(result);
    }
    @Test
    public void execute_should_change_player_name() {
        //Act
        target.execute("@set name=chuck norris", game);
        //Assert
        assertEquals("chuck norris", game.getPlayer().getName());
    }
    @Test
    public void execute_should_trim_spaces() {
        Player player = new Player(null);
        player = spy(player);
        when(game.getPlayer()).thenReturn(player);
        //Act
        target.execute("    @set name=chuck norris          ", game);
        //Assert
        verify(player).setName("chuck norris");

    }

    @Test
    public void isValid_should_ignore_case_for_set_name() {

        //Act
        var result = target.isValid("@SeT nAmE=chuck norris", null);
        //Assert

        assertTrue(result);
    }
}