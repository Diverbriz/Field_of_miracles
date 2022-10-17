package GameLogic;

import java.io.IOException;

public interface GameOperations {
    void startGame() throws IOException;
    boolean endGame();
    void checkingForWinnings();
    boolean chooseLetter(char s); //возвращает true если угадали букву и false если не угадали
    void openLetter(); //открывает букву
    void takeHint();
}
