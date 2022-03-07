package Model;
import java.util.*;

public class Iterator {
	private Board board;
	private int index;

	public Iterator() {
		this.board = Board.createInstance();
		this.index = 0;
	}
	
	public Iterator(int position, BoxType type) {
		this.board = Board.createInstance();
		if(type.equals(BoxType.HALLWAY)){
			this.index = this.board.getWhiteBoxes().size() + position-1;
		}
		else { 
			this.index = position-1;
		}
		
	}
	
	public ArrayList<Box> march(Color color) {
		ArrayList<Box> boxes = new ArrayList<Box>();
		Box boxActual = null;
		this.index = 0;
		
		while(moreBoxesToMove()) {
			boxActual = nextBox();
			if(boxActual.getPieces().size() != 0)
			{	if (boxActual.getPieces().get(0).getColor().equals(color)) {
					boxes.add(boxActual);
				}
			}
		}
		
		return boxes;
	}

	public Box nextBox() {
		Box aux = null;
		int indicePasillo = this.index -this.board.getWhiteBoxes().size()+1;
		int sizeAll = this.board.getWhiteBoxes().size()+this.board.getHallway().size();
		
		
		if(this.index <this.board.getWhiteBoxes().size()) {
			aux = this.board.getWhiteBoxes().get(this.index);
		} else if(this.index >=this.board.getWhiteBoxes().size() && this.index <sizeAll){
			if(indicePasillo<this.board.getHallway().size()) {
				aux = this.board.getHallway().get(indicePasillo);
			}
		}
		this.index++;
		return aux;
	}

	public boolean moreBoxesToMove() {
		boolean more;
		int sizeAll = this.board.getWhiteBoxes().size()+this.board.getHallway().size();
		if(this.index <sizeAll-1) {
			more = true;
		} else {
			more = false;
			this.index = -1;
		}
		return more;
	}
}
