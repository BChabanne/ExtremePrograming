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
        controller.nextTurn();
        assertEquals(player2, controller.getCurrentPlayer());
    }

    @Test
    public void testMinimumBetAtTheBeginingOfTheGame() throws GameException {
        GameController controller = new GameController();
        assertEquals(0, controller.getMinimumBet());
    }

    @Test
    public void testSetMinimumBet() throws GameException {
        GameController controller = new GameController();
        controller.setMinimumBet(10);
        assertEquals(10, controller.getMinimumBet());
    }
}
