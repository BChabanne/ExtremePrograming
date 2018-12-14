package formation.xp;

public interface IGameController {
    int getMaxBet();
    void nextPlayer();
    IPlayer getCurrentPlayer();
    void addPlayer(IPlayer player);
}