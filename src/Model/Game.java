package Model;
import View.Console;
import View.ViewInterface;
import java.util.*;

public class Game {
	
	private Board board;
    private int numberOfPlayer;
	private Player atualPlayer;
    private ArrayList<Player> players;
	private Dice dice;
	private Iterator iterator;
	private int diceResults;
	private ViewInterface viewInterface;

	public Game() {
		board = Board.createInstance();
		dice = Dice.createDice();
		this.iterator = new Iterator();
        this.players = new ArrayList();
        this.viewInterface = new Console();
	}

    public void addJugadores() {
    	viewInterface.welcome();
        Scanner sc = new Scanner(System.in);
        numberOfPlayer = viewInterface.askNumberOfPlayers();
        ArrayList<Color> colors = new ArrayList<Color>(Arrays.asList(Color.values()));
        for(int i = 0; i < numberOfPlayer; i++) {
            Player playerAux = null;
            int j = i+1;
            int option = viewInterface.askColor(j, colors);
            int n = 1;
            for(Color color: colors) {
                if(n==option) {
                    playerAux = new Player(color);
                    colors.remove(color);
                    break;
                }
                n++;
            }
            
            option = viewInterface.askTypePlayer();
            if(option == 1) {
                playerAux.NormalPlayer();
            } else if (option == 2) {
                playerAux.PlayerIA();
            }
            players.add(playerAux);
        }
    }
	
	public void play() {
		ArrayList<Box> boxesWithPiecesList;
		
		while(!end()) {
            for(Player player : players) {
                atualPlayer = player;
                viewInterface.playerTurn(atualPlayer);
                if(player.typePlayerJ.toString() == "Normal") {
                    Scanner sc = new Scanner(System.in);
                    viewInterface.pressAnyKeyToContinue();
                    diceResults = dice.rollDice();

                    if(diceResults == 5 && this.board.getPiecesOnGame() <= 4){
                        this.board.addPiecesOnBoard(atualPlayer.getColor());
                    }else{
                        boxesWithPiecesList = this.iterator.march(atualPlayer.getColor());
                    if(boxesWithPiecesList.size() > 0) {
                            atualPlayer.printPiecesLocationByPlayer();

                            int eleccion = this.atualPlayer.choice();
                            this.board.movePieces(boxesWithPiecesList.get(eleccion-1).getPieces().get(0), boxesWithPiecesList.get(eleccion-1), diceResults);

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


