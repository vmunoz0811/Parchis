package View;
;
import Model.Piece;
import Model.Player;
import java.util.ArrayList;
import java.util.Scanner;

public class Console implements ViewInterface {
	@Override
	public void welcome() {
		String ANSI_CYAN_BACKGROUND = "\u001B[46m";
		String ANSI_RESET = "\u001B[0m";
		System.out.println(ANSI_CYAN_BACKGROUND + "BIENVENIDO/S A PARCHIS" + ANSI_RESET);
	}

	@Override
	public int askNumberOfPlayers() {
		Scanner sc = new Scanner(System.in);
		int numberOfPlayers = -1;
		while(numberOfPlayers < 1 || numberOfPlayers > 4){
			String ANSI_BOLD = "\u001B[1m";
			String ANSI_RESET = "\u001B[0m";
			System.out.println(ANSI_BOLD+ "¿Cuántos jugadores van a ingresar a la partida? (Máx. 4)" + ANSI_RESET);
			numberOfPlayers = sc.nextInt();
		}
		return numberOfPlayers;
	}

	@Override
	public int askColor(int numberOfPlayers, ArrayList<Piece> colors) {
		Scanner sc = new Scanner(System.in);
		System.out.println("El jugador - " + numberOfPlayers + "\n¿Con qué color desea jugar?");
        int colorNumber = 1;
        for(Piece color: colors) {
            System.out.println(colorNumber + ")" +color.toString());
            colorNumber++;
        }
        int option = sc.nextInt();
		return option;
	}

	@Override
	public int askTypePlayer() {
		Scanner sc = new Scanner(System.in);
		System.out.println("�Sera un jugador humano o una IA?");
        System.out.println("1.Humano\n2.Ia\n");
        int opcion = sc.nextInt();
		return opcion;
	}

	@Override
	public void pressAnyKeyToContinue() {
		System.out.println("Pulsa ENTER para tirar el dado.\n");
        try
        {
            System.in.read();
        }  
        catch(Exception e)
        {}  
	}

	@Override
	public void playerTurn(Player actuaPlayer) {
		// TODO Auto-generated method stub
		System.out.println("Turno jugador "+ actuaPlayer.playerType.toString()+"-"+actuaPlayer.color);
	}

}
