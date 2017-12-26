import controller.GameManager;
import controller.MenuController;
import views.GameView;
import views.MenuView;

public class Launch {
    public static void main(String[] args)
    {
        /*GameManager gameManager=new GameManager();
        GameView gameView=new GameView("GAME",gameManager);
        gameManager.setGameView(gameView);
        gameManager.start();*/
        MenuView menuView=new MenuView("game");
        MenuController menuController=new MenuController(menuView);
        menuView.setMenuController(menuController);


    }
}
