package formation.xp;

public interface IGameController {
    int getMaxBet();
    void nextPlayer() throws GameException;
    IPlayer getCurrentPlayer();
    void addPlayer(IPlayer player);
    void addPlayers(int numberPlayer, int startingMoney);
}