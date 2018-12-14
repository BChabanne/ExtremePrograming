package formation.xp;

import java.util.ArrayList;

public class GameController implements  IGameController {

    private ArrayList<IPlayer> players = new ArrayList<>();
    private int currentPlayer;

    public GameController(){
        currentPlayer = 0;
    }

    @Override
    public void addPlayers(int numberPlayer, int startingMoney) {
        for(int i =0; i< numberPlayer; i++){
            new Player(startingMoney, this);
        }
    }

    @Override
    public IPlayer getCurrentPlayer() {
        return players.get(currentPlayer);
    }

    @Override
    public void nextPlayer() throws GameException {
        if (players.size() == 0)
            throw new GameException("No player");

        currentPlayer = (currentPlayer + 1) % players.size();
    }

    @Override
    public void addPlayer(IPlayer player) {
        players.add(player);
    }

    @Override
    public int getMaxBet() {
        int max = 0;
        for(int i= 0; i< players.size(); i++){
            int bet = players.get(i).getBet();
            if(bet > max){
                max = bet;
            }
        }
        return max;
    }
}
