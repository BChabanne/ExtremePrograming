package formation.xp;

public Interface Player {

    public void getCard(Card newCard) throws GameException; 
    public void bet(int newBet) throws GameException;
}