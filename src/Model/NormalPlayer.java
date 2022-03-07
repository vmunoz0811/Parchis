package Model;

public class NormalPlayer implements PlayerTypeInterface {
    public String GetDescription()
    {
        return "Jugador Normal";
    }
    
    public int choice(Color color, int piecesOnGame) {
    	return GameInterface.pieceChoice(color, piecesOnGame);
    }
}
