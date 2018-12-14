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
		Player player1 = new Player(100, controller),
			player2 = new Player(100, controller);

		player1.firstBet(10);
		player2.call();
		assertEquals(90, player2.getMoney());
	}

	@Test
	public void testRaise() throws GameException {
		GameController controller = new GameController();
		Player player1 = new Player(100, controller),
			player2 = new Player(100, controller);
		player1.firstBet(10);
		player2.raise(20);
		assertEquals(80, player2.getMoney());
	}

	@Test
	public void testRaiseException() {
		GameController controller = new GameController();
		Player player1 = new Player(100, controller),
				player2 = new Player(100, controller);
		try {
			player1.firstBet(10);
			player2.raise(101);
			fail("player shouldn't be able to raise more than its money");
		} catch (GameException e) {
			assert true;
		}
	}

	@Test
	public void testRaiseBelowMaxBet()  {
		GameController controller = new GameController();
		Player player1 = new Player(100, controller),
				player2 = new Player(100, controller);
		try {
			player1.firstBet(10);
			player2.raise(5);
			fail("player shouldn't raise below current max bet");
		} catch ( GameException e) {
			assert true;
		}
	}

	@Test
	public void testAllIn() {
		GameController controller = new GameController();
		Player player1 = new Player(100, controller);
		int amountBet = player1.allIn();
		assertEquals(100, amountBet);
		assertEquals(0, player1.getMoney());
	}

	@Test
	public void testGetBet() throws  GameException {
		GameController controller = new GameController();
		Player player1 = new Player(100, controller);
		player1.firstBet(10);
		assertEquals(10, player1.getBet());
	}

	@Test
	public void testCheck() throws GameException {
		GameController controller = new GameController();
		Player player1 = new Player(100, controller),
				player2 = new Player(100, controller);

		player1.firstBet(10);
		player2.call();
		player1.check();

		assertEquals(10, player1.getBet());

	}

	@Test
	public void testCheckThrowsException() throws GameException {
		GameController controller = new GameController();
		Player player1 = new Player(100, controller),
				player2 = new Player(100, controller);
		try {
			player1.firstBet(10);
			player2.check();
			fail("player shouldn't check if his current bet is not high enough");
		} catch ( GameException e) {
			assert true;
		}
	}
}
