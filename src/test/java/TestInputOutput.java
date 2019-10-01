import org.improving.tag.InputOutput;
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
    public void displayText(Object text) {
        this.lastText = text.toString();
    }
    @Override
    public void displayPrompt(String prompt) {
    }
    @Override
    public void displayNewLine() {
    }
}
