package formation.xp;

public class Player implements IPlayer {

    private Card[] deck;
    private int money;
    private IGameController gameController;
    private int currentBet;

    public Player(int startingMoney, IGameController controller) {
        deck = new Card[] {null, null};
        money = startingMoney;
        gameController = controller;
        controller.addPlayer(this);
        currentBet = 0;
    }

    @Override
    public void drawCards(Card card1, Card card2) {
         deck[0] = card1;
         deck[1] = card2;
    }

    @Override
    public void firstBet(int initialBet) throws GameException {
        if(initialBet < 0){
            throw new GameException("Only positive bet accepted");
        } else if(initialBet > money) {
            throw new GameException("Bet amount too high");
        }
        money -= initialBet;
        currentBet = initialBet;
    }

    @Override
    public void call() throws GameException {
        int maxBet = gameController.getMaxBet();
        if(currentBet >= maxBet){
            throw new GameException("You can't call because you bet already too much");
        } else if ( maxBet - currentBet > money) {
            throw new GameException("You don't have enough money");
        }
        money -= maxBet - currentBet;
        currentBet = maxBet;
    }

    @Override
    public void raise(int newBetValue) throws GameException {
        int maxBet = gameController.getMaxBet();
        if (newBetValue <= maxBet)
            throw new GameException("Raised value is below the highest bet");
        else if (newBetValue - currentBet > money)
            throw new GameException("Impossible to raise, player doesn't have enough money");

        money -= newBetValue - currentBet;
        currentBet = newBetValue;
    }

    @Override
    public int allIn() {
        int betMoney = money;
        money = 0;
        return betMoney;
    }

    @Override
    public void check() {

    }

    @Override
    public int getMoney() {
        return money;
    }

    @Override
    public Card[] getCards() {
        return deck;
    }

    @Override
    public int getBet() {
        return currentBet;
    }
}
