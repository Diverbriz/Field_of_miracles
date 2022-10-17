package Model;

import junit.framework.TestCase;

public class PlayerTest extends TestCase {
    Player player = new Player();

    Player player2 = new Player();
    public void testGetScore() {
        player.setScore(200);

        player2.increaseScore(200);
        assertEquals(player.getScore(), player2.getScore());
    }

    public void testSetScore() {
    }

    public void testIncreaseScore() {
    }
}