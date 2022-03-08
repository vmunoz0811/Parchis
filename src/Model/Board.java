package Model;

import java.util.*;

public class Board {
	private static Board _instanceBoard = null;
	private List<Box> whiteBoxes;
	private List<Box> hallway;
	private int piecesOnGame;

	private Board() {
		createWhitePieces();
		createHallway();
		piecesOnGame = 0;
	}

	public List<Box> getWhiteBoxes() {
		return whiteBoxes;
	}

	public void setWhiteBoxes(List<Box> whiteBoxes) {
		this.whiteBoxes = whiteBoxes;
	}

	public List<Box> getHallway() {
		return hallway;
	}

	public void setHallway(List<Box> hallway) {
		this.hallway = hallway;
	}

	public static Board createInstance() {
		if (_instanceBoard == null) {
			_instanceBoard = new Board();
		}
		return _instanceBoard;
	}

	public void createWhitePieces() {

		whiteBoxes = new ArrayList<Box>(68);

		for (int i = 0; i < 68; i++) {
			Box aux;
			if (i == 3 || i == 20 || i == 37 || i == 54) {
				aux = new Box(BoxType.OUT, i + 1);
			} else if (i == 12 || i == 29 || i == 46 || i == 63) {
				aux = new Box(BoxType.SAFE, i + 1);
			} else if (i == 67 || i == 16 || i == 33 || i == 50) {
				aux = new Box(BoxType.ENTRY, i + 1);
			} else {
				aux = new Box(BoxType.NORMAL, i + 1);
			}
			whiteBoxes.add(aux);
		}
	}

	public void createHallway() {
		hallway = new ArrayList<Box>(8);
		for (int i = 0; i < 8; i++) {
			Box aux;
			if (i == 7) {
				aux = new Box(BoxType.FINISH, i + 1);
			} else {
				aux = new Box(BoxType.HALLWAY, i + 1);
			}
			hallway.add(aux);
		}
	}

	public void addPiecesOnBoard(Color color) {
		AbstractPiecesFactory fabrica;
		Piece piece;

		switch (color) {
			case ROJO:
				fabrica = new RedPiecesFactory();
				piece = fabrica.createPiece();
				this.whiteBoxes.get(37).putPiece(piece);
				break;
			case AMARILLO:
				fabrica = new YellowPiecesFactory();
				piece = fabrica.createPiece();
				this.whiteBoxes.get(3).putPiece(piece);
				break;
			case AZUL:
				fabrica = new BluePiecesFactory();
				piece = fabrica.createPiece();
				this.whiteBoxes.get(20).putPiece(piece);
				break;
			case VERDE:
				fabrica = new GreenPiecesFactory();
				piece = fabrica.createPiece();
				this.whiteBoxes.get(54).putPiece(piece);
				break;
			default:
				break;
		}
		this.piecesOnGame++;
	}

	public void movePieces(Piece piece, Box boxActual, int nDado) {
		Iterator iterator = new Iterator(boxActual.getActualPosition(), boxActual.getBoxType());
		Box boxDestino = null;
		while (iterator.moreBoxesToMove() && nDado >= 0) {
			boxDestino = iterator.nextBox();
			nDado--;
		}
		boxDestino.putPiece(piece);
		boxActual.deletePiece(piece);
	}

	public void borrarFicha() {
		this.piecesOnGame--;
	}

	public int getPiecesOnGame() {
		return piecesOnGame;
	}

}
