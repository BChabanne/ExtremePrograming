package formation.xp;

import java.util.ArrayList;

public class GameController implements  IGameController {

    private ArrayList<IPlayer> players = new ArrayList<>();
    private int currentPlayer;

    public GameController(){
        currentPlayer = -1;
    }

    @Override
    public void addPlayers(int numberPlayer, int startingMoney) {
        currentPlayer = 0;
        for(int i =0; i< numberPlayer; i++){
            new Player(startingMoney, this);
        }
    }

    @Override
    public IPlayer getCurrentPlayer() {
        if( currentPlayer == -1){
            return null;
        }
        return players.get(currentPlayer);
    }

    @Override
    public void nextPlayer() throws GameException {
        if (players.size() == 0)
            throw new GameException("No player");
        int tmpCurrentPlayer = currentPlayer;
        currentPlayer = -1;
        for( int i = 1; i <= players.size(); i++){
            IPlayer player = players.get((tmpCurrentPlayer + i) % players.size());
            if(player.getMoney() > 0){
                currentPlayer =  ( tmpCurrentPlayer + i) % players.size();
                break;
            }
        }
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
