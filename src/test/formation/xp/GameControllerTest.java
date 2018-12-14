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

    @Test
    public void testGameWith5Players() throws GameException {
        int numberPlayer = 5;
        GameController controller = new GameController();
        controller.addPlayers(numberPlayer, 100);

        IPlayer firstPlayer = controller.getCurrentPlayer();

        for(int i =0; i< numberPlayer - 1; i++){
            controller.nextPlayer();
        }

        assertNotSame(firstPlayer, controller.getCurrentPlayer());

        controller.nextPlayer();

        assertEquals(firstPlayer, controller.getCurrentPlayer());
    }


}
