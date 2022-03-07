package Model;

public class GreenPiecesFactory implements AbstractPiecesFactory {
	@Override
	public Piece createPiece() {
		Color c1 = Color.GREEN;
		Piece f1 = new Piece(c1);
		return f1;
	}
}

