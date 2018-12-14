package formation.xp;

public class Player implements IPlayer {

    private Card[] deck;
    private int money;
    private IGameController gameController;

    public Player(int startingMoney, IGameController controller) {
        deck = new Card[] {null, null};
        money = startingMoney;
        gameController = controller;
        controller.addPlayer(this);
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
    }

    @Override
    public void call() throws GameException {
        int minimumBet = gameController.getMinimumBet();
        if(money < minimumBet){
            throw new GameException("Impossible to call. Player doesn't have enough money");
        }
        money -= minimumBet;
    }

    @Override
    public void raise(int newBetValue) throws GameException {
        if (newBetValue <= gameController.getMinimumBet())
            throw new GameException("Impossible to raise, new bet is lower than the old one");
        else if (money < newBetValue)
            throw new GameException("Impossible to raise, player doesn't have enough money");

        gameController.setMinimumBet(newBetValue);
        money -= newBetValue;
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
}
