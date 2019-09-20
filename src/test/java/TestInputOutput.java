import org.improving.tag.InputOutput;
import org.improving.tag.commands.DanceCommand;
import org.improving.tag.commands.MoveCommand;
import org.junit.jupiter.api.BeforeEach;

public class TestInputOutput implements InputOutput {
    MoveCommand target;
    TestInputOutput io;

    @BeforeEach
    public void arrange() {
        //Arrange
        io = new TestInputOutput();
        target = new MoveCommand(io);
    }


    public String lastText;

    @Override
    public String receiveInput() {
        return null;
    }
    @Override
    public void displayText(String text) {
        this.lastText = text;
    }
    @Override
    public void displayPrompt(String prompt) {
    }
}
