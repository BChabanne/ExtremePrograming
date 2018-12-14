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

    @Test
    public void testIsBankrupt() throws GameException {
        GameController controller = new GameController();
        controller.addPlayers(2, 100);

        //player 1 goes bankrupt
        controller.getCurrentPlayer().allIn();

        //player 2
        controller.nextPlayer();
        IPlayer player2 = controller.getCurrentPlayer();
        
        //assert that next player is player 2 because player 1 is bankrupt
        controller.nextPlayer();
        IPlayer current = controller.getCurrentPlayer();

        assertEquals(current, player2);



    }
}
