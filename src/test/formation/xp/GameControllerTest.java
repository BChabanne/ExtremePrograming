package formation.xp;

import org.junit.Test;

import junit.framework.TestCase;

public class GameControllerTest extends TestCase {
    @Test
    public void testNextPlayer() throws GameException{
        GameController controller = new GameController();
        Player player1 = new Player(100, controller),
                player2 = new Player(100, controller);
        assertEquals(player1, controller.getCurrentPlayer());
        controller.nextPlayer();
        assertEquals(player2, controller.getCurrentPlayer());
    }

    @Test
    public void testGetMaxBet() throws GameException{
        GameController controller = new GameController();
        Player player1 = new Player(100, controller);

        player1.firstBet(10);
        assertEquals( 10, controller.getMaxBet());
    }
}
