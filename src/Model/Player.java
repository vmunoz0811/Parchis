package Model;

import java.util.*;

public class Player {
	public Color color;
	public Iterator iterator;
	public int piecesOnGame;
	public PlayerTypeInterface playerType;
	public TypePlayer typePlayerJ;

	public Player(Color c1){
		this.color = c1;
		this.iterator = new Iterator();
	}
	
	public void NormalPlayer()
    {
		typePlayerJ = TypePlayer.Normal;
		PlayerTypeInterface jugadorNormal = new NormalPlayer();
		setPlayerType(jugadorNormal);
    }
 
    public void PlayerIA()
    {
		typePlayerJ = TypePlayer.IA;
    	PlayerTypeInterface jugadorIA = new IAPlayer();
    	setPlayerType(jugadorIA);
    }

	public Color getColor() {
		return color;
	}

public ArrayList<Box> getBoxesWithPieces() {
		return this.iterator.march(this.color);
	}

	public void printPiecesLocationByPlayer() {
		ArrayList<Box> listaFichasJugador = getBoxesWithPieces();
		this.piecesOnGame = listaFichasJugador.size();
		GameInterface.showPiecesOnGame(listaFichasJugador , piecesOnGame);
		
	}

	public int choice(){
		return this.playerType.choice(this.color, this.piecesOnGame);
	}

	public int getPiecesOnGame() {
		return piecesOnGame;
	}

	public void setPiecesOnGame(int piecesOnGame) {
		this.piecesOnGame = piecesOnGame;
	}
	
	public PlayerTypeInterface getPlayerType() {
		return playerType;
	}

	public void setPlayerType(PlayerTypeInterface playerType) {
		this.playerType = playerType;
	}
}

enum TypePlayer {
	Normal,
	IA
};
