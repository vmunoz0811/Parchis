package Model;

public class BluePiecesFactory implements AbstractPiecesFactory {
	@Override
	public Piece createPiece() {
		Color c1 = Color.AZUL;
		Piece f1 = new Piece(c1);
		return f1;
	}
}
