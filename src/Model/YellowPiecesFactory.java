package Model;

public class YellowPiecesFactory implements AbstractPiecesFactory {

	@Override
	public Piece createPiece() {
		Color c1 = Color.AMARILLO;
		Piece f1 = new Piece(c1);
		return f1;
	}
}
