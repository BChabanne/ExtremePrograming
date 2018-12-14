package formation.xp;

public interface IGameController {
    IPlayer getCurrentPlayer();
    void nextTurn();
    int getMinimumBet();
    void addPlayer(IPlayer player);
    void setMinimumBet(int minimumBet) throws GameException;
}