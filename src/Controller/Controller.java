package Controller;

import Model.Game;

public class Controller {
    private Game model;

    public Controller(){
        model = new Game();
        init();
    }
    public void init (){
        model.addJugadores();
        model.play();
    }

}
