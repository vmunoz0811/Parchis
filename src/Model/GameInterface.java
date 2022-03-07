package Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public interface GameInterface {

	public static int pieceChoice(Color color, int piecesOnGame) {
		System.out.println("¿Cual quieres mover?" + "-" + color.toString());
		Scanner scc = new Scanner(System.in);
		int i = scc.nextInt();
		if (i <= piecesOnGame) {
			System.out.println("Jugador-" + color + "- muevo la ficha numero: " + i);
			return i;
		} else {
			return 0;
		}
	}

	public static int pieceChoiceIA(Color color, int piecesOnGame) {
		// Empieza aquí
		Random rand = new Random();
		rand.setSeed(new Date().getTime());
		int rNumber = rand.nextInt(piecesOnGame) + 1;
		System.out.println("IA-" + color + "- muevo la ficha numero: " + rNumber);
		return rNumber;
	}

	public static void diceResults(int result) {
		System.out.println("Has sacado:" + result);
	}
	
	public static void showPiecesOnGame(ArrayList<Box> piecesPlayer , int size){
		for(int i = 0; i < piecesPlayer.size(); i++) {
			System.out.println("Ficha " + (i+1) + " en casilla: " + piecesPlayer.get(i).getActualPosition() + "\n");
		}
	}
}