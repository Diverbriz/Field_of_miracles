import GameLogic.Operations;
import org.testng.annotations.Test;

public class OperationsTest {

    @Test
    public void setUp() throws Exception{
        Operations.getInstance().endGame();
    }
}
