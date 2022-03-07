package Model;

public class IAPlayer implements PlayerTypeInterface {

	public String GetDescription()
    {
        return "Jugador IA";
    }
	
	public int choice(Color color, int piecesOnGame) {
		return GameInterface.pieceChoiceIA(color, piecesOnGame);
	}
}
