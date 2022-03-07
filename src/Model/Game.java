package Model;
import View.Console;
import View.ViewInterface;
import java.util.*;

public class Game {
	
	private Board board;
    private int numberOfPlayer;
	private Player playerActual;
    private ArrayList<Player> jugadores;
	private Dice dice;
	private Iterator iterator;
	private int resultadoDado;
	private ViewInterface viewInterface;

	public Game() {
		board = Board.createInstance();
		dice = Dice.createDice();
		this.iterator = new Iterator();
        this.jugadores = new ArrayList();
        this.viewInterface = new Console();
	}

    public void addJugadores() {
    	viewInterface.welcome();
        Scanner sc = new Scanner(System.in);
        numberOfPlayer = viewInterface.askNumberOfPlayers();
        ArrayList<Piece> colores = new ArrayList<Piece>(Arrays.asList(Color.values()));
        for(int i = 0; i < numberOfPlayer; i++) {
            Player playerAux = null;
            int j = i+1;
            int opcion = viewInterface.askColor(j, colores);
            int n = 1;
            for(Color color: colores) {
                if(n==opcion) {
                    playerAux = new Player(color);
                    colores.remove(color);
                    break;
                }
                n++;
            }
            
            opcion = viewInterface.askTypePlayer();
            if(opcion == 1) {
                playerAux.NormalPlayer();
            } else if (opcion == 2) {
                playerAux.PlayerIA();
            }
            jugadores.add(playerAux);
        }
    }
	
	public void play() {
		ArrayList<Box> boxesWithPiecesList;
		
		while(!end()) {
            for(Player player : jugadores) {
                playerActual = player;
                viewInterface.playerTurn(playerActual);
                if(player.typePlayerJ.toString() == "Normal") {
                    Scanner sc = new Scanner(System.in);
                    viewInterface.pressAnyKeyToContinue();
                    resultadoDado = dice.rollDice();

                    if(resultadoDado == 5 && this.board.getPiecesOnGame() <= 4){
                        this.board.addPiecesOnBoard(playerActual.getColor());
                    }else{
                        boxesWithPiecesList = this.iterator.march(playerActual.getColor());
                    if(boxesWithPiecesList.size() > 0) {
                            playerActual.printPiecesLocationByPlayer();

                            int eleccion = this.playerActual.choice();
                            this.board.movePieces(boxesWithPiecesList.get(eleccion-1).getPieces().get(0), boxesWithPiecesList.get(eleccion-1), resultadoDado);

                        }
                    }
                }
            }
		}
	}

	public boolean end() {
		if(this.board.getHallway().get(7).getPieces().size() == 4) {
			System.out.println();
			return true;
		}else{
			return false;
		}
	}
}


