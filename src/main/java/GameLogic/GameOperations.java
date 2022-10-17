public interface GameOperations {
    boolean chooseLetter(char s); //возвращает true если угадали букву и false если не угадали
    void openLetter(char s); //открывает букву
    void takeHint();
}
