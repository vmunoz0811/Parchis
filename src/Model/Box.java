package Model;

import java.util.ArrayList;
import java.util.List;

public class Box {
    private List<Piece> pieces;
    private BoxType boxType;
    private int actualPosition;

    public Box(BoxType boxType1, int position) {
        this.boxType = boxType1;
        this.actualPosition = position;

        if (boxType1.equals(BoxType.FINISH)) {
            this.pieces = new ArrayList<Piece>(4);
        } else {
            this.pieces = new ArrayList<Piece>(2);
        }
    }

    public void deletePiece(Piece piece) {
        this.pieces.remove(piece);
    }

    public void putPiece(Piece piece) {
        this.pieces.add(piece);
    }

    public List<Piece> getPieces() {
        return pieces;
    }

    public void setPieces(List<Piece> pieces) {
        this.pieces = pieces;
    }

    public BoxType getBoxType() {
        return boxType;
    }

    public void setBoxType(BoxType boxType) {
        this.boxType = boxType;
    }

    public int getActualPosition() {
        return actualPosition;
    }

    public void setActualPosition(int actualPosition) {
        this.actualPosition = actualPosition;
    }
}

enum BoxType {
    OUT,
    SAFE,
    ENTRY,
    HALLWAY,
    FINISH,
    NORMAL
}