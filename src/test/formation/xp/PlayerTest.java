package formation.xp;

import org.junit.Test;

import junit.framework.TestCase;

import java.util.Arrays;

public class PlayerTest extends TestCase {
	@Test
	public void testDrawCard() {
		GameController controller = new GameController();
		Player player = new Player(100, controller);
		Card card1 = new Card(), card2 = new Card();
		player.drawCards(card1, card2);
		Card[] playerCards = player.getCards();
		assertEquals(2, playerCards.length);
		assert(Arrays.asList(playerCards).contains(card1));
		assert(Arrays.asList(playerCards).contains(card2));
	}

	@Test
	public void testGetMoney() {
		GameController controller = new GameController();
		Player player = new Player(100, controller);
		assertEquals(100, player.getMoney());
	}

	@Test
	public void testNegativeFirstBet() throws GameException {
		GameController controller = new GameController();
		Player player = new Player(100, controller);
		try {
			player.firstBet(-1);
			fail("didn't throw");
		} catch(GameException error) {
			assert true;
		}
	}

	@Test
	public void testFirstBet() throws GameException{
		int currentBet = 0;

		GameController controller = new GameController();
		Player player = new Player(100, controller);

		player.firstBet(20);
		assertEquals(80, player.getMoney());

	}

	@Test
	public void testTooBigFirstBet() {
		GameController controller = new GameController();
		Player player = new Player(100, controller);
		try {
			player.firstBet(101);
			fail("didn't throw");
		} catch(GameException error) {
			assert true;
		}
	}

	@Test
	public void testCall() throws GameException {
		GameController controller = new GameController();
		Player player1 = new Player(100, controller);

		controller.setMinimumBet(10);

		player1.call();
		assertEquals(90, player1.getMoney());
	}
}
