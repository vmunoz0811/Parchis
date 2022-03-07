package Model;

public class RedPiecesFactory implements AbstractPiecesFactory {
	@Override
	public Piece createPiece() {
		Color c1 = Color.RED;
		Piece f1 = new Piece(c1);
		return f1;
	}

}
