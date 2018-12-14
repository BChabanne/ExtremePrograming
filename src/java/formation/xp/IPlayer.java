package formation.xp;

public interface IPlayer {

    void drawCards(Card card1, Card card2);
    void firstBet(int initialBet) throws GameException;
    void call() throws GameException;
    void raise(int newBetValue) throws GameException;
    int allIn();
    void check();

    Card[] getCards();
    int getMoney();
    int getBet();
}