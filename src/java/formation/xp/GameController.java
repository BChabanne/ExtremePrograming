package formation.xp;

import java.util.ArrayList;

public class GameController implements  IGameController {

    private ArrayList<IPlayer> players = new ArrayList<>();
    private int currentPlayer;
    private int minimumBet;

    public GameController(){
        currentPlayer = 0;
        minimumBet = 0;
    }

    @Override
    public IPlayer getCurrentPlayer() {
        return players.get(currentPlayer);
    }

    @Override
    public void nextTurn() {
        currentPlayer = (currentPlayer + 1) % players.size();
    }

    @Override
    public int getMinimumBet() {
        return minimumBet;
    }

    @Override
    public void addPlayer(IPlayer player) {
        players.add(player);
    }

    @Override
    public void setMinimumBet(int newMinimumBet) throws GameException {
        if (newMinimumBet <= minimumBet) {
            throw new GameException("the new bet need to increase the old bet");
        }

        minimumBet = newMinimumBet;

    }
}
