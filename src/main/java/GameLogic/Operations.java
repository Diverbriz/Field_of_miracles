package GameLogic;

import Mock.MockBase;
import Model.Player;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

import static java.lang.Character.toLowerCase;
import static java.lang.Character.toUpperCase;
import static java.lang.System.out;

public class Operations implements GameOperations{
    private int numberOfPlayers;
    private Scanner scanner = new Scanner(System.in);
    private static int i = 1;
    private String[] secretKey;
    private Player[] players;
    private static Operations instance;
    private static MockBase mockBase;
    public Operations(){}
    public static Operations getInstance(){
        if(instance == null){
            instance = new Operations();
            mockBase = new MockBase();
        }
        return instance;
    }
    @Override
//    char c = input.next(".").charAt(0);
    public void startGame() throws IOException {
        Scanner scanner = new Scanner(System.in);
        out.print("Введите количество игроков");
        initializationOfPlayers(scanner.nextInt());
        out.println(players.length);


        mockBase.randomQuestion();
        secretKey = new String[mockBase.getCurrentQuestion().getAnswer().length];
        while (!endGame()){
            drawMap(mockBase.getCurrentQuestion().getAnswer());
            out.println("Назовите букву!");
            openLetter();
            checkingForWinnings();

        }
    }

    @Override
    public boolean endGame() {
        if (i == 0){
            out.println("Winner " + Arrays.toString(secretKey));
            return true;
        }
        else return false;
    }

    @Override
    public void checkingForWinnings() {
        int key = 0;
        for (int i = 0; i < secretKey.length; i++) {
            if(secretKey[i] == "*"){
                key++;
            }
            if(key > 0) break;
        }
        if(key == 0) i = 0;
    }

    @Override
    public boolean chooseLetter(char s) {
        return false;
    }

    @Override
    public void openLetter() {
        Character letter = scanner.next().charAt(0);

        if (Character.isLetter(letter)) {

            for (int i = 0; i < secretKey.length; i++) {
                if (mockBase.getCurrentQuestion().getTmp().charAt(i) == letter
                        || mockBase.getCurrentQuestion().getTmp().charAt(i) == toUpperCase(letter)
                        || mockBase.getCurrentQuestion().getTmp().charAt(i) == toLowerCase(letter)
                ) {
                    secretKey[i] = letter.toString();
                }
            }
        }

        else{
            out.println("Слова состоят из букв. Предложения из слов. А речь из предложений!");
        }
    }

    @Override
    public void takeHint() {

    }

    private void initializationOfPlayers(int number) {
        players = new Player[number];
        Scanner scanner = new Scanner(System.in);

        //Кладем пустые объекты игроков в массив
        for (int i = 0; i < number; i++) {
            players[i] = new Player();
        }

        //Заполняем имена и ставим начальный счет
        for (int i = 0; i < players.length; i++) {
            System.out.println("Enter name of player " + (i+1));
            String name = scanner.next();
            players[i].setName(name);
            players[i].setScore(0);
        }
    }

    public void drawMap(String[] str){
        out.println(mockBase.getCurrentQuestion().getQuestion() + "\n");
        for (int i = 0; i < secretKey.length; i++){
            if(secretKey[i] == null){
                secretKey[i] = "*";
            }
        }

        out.println(Arrays.toString(secretKey));

        for(int i = 0; i < str.length; i++){
            out.print("--");
        }
        out.println('-');

        for(int i = 0; i < str.length; i++){
            if(i == 0){
                out.print("|" + secretKey[i]);
            }
            else if(i == str.length - 1){
                out.print("|" + secretKey[i] + "|");
            }
            else {
                out.print("|" + secretKey[i]);
            }
        }
        out.println();
        for(int i = 0; i < str.length; i++){
            out.print("--");
        }
        out.println('-');
    }


}
