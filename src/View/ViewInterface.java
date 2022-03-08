package View;

import Model.Color;
import Model.Player;

import java.util.ArrayList;

public interface ViewInterface {
    public void welcome();
    public int askNumberOfPlayers();

    public int askColor(int playerNum, ArrayList<Color> colors);

    public int askTypePlayer();

    public void pressAnyKeyToContinue();

    public void playerTurn(Player player);
}
