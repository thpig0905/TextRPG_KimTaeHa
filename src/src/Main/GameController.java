package Main;

import Game.GameCommand;
import MenuGame.GameMain;
import MenuStart.SelectCharacter;
import MenuStart.TitleMenu;
import Monster.Monster;
import Player.*;

import java.util.HashMap;
import java.util.Map;

public class GameController {
    private GameController() {}
    private static GameController instance = new GameController();
    public static GameController getInstance() { return instance; }

    private String nextMenu;
    private GameCommand command;
    private Player player;
    private Monster monster;
    private int Stage;
    public Map<String, GameCommand> commandMap;

    public Player getPlayer() { return player; }
    public void setPlayer(Player player) { this.player = player; }

    public Monster getMonster() { return monster; }
    public void setMonster(Monster monster) { this.monster = monster; }

    public int getStage() { return Stage; }
    public void setStage(int stage) { Stage = stage; }

    public void setNextWindow(String nextWindow) { this.nextMenu = nextWindow; }

    public void init() {
        commandMap = new HashMap<>();
        commandMap.put("TitleMenu", new TitleMenu());
        commandMap.put("SelectCharacter", new SelectCharacter());
        commandMap.put("GameMain", new GameMain());
        commandMap.put("Battle", new Battle());
        commandMap.put("GameOver", new GameOver());

        command = commandMap.get("TitleMenu");
        command.init();
        update();
    }
    public void update() {
        while (true){
            if (!command.update()) {
                if (nextMenu != null) {
                    command = commandMap.get(nextMenu);
                    command.init();
                } else {
                    return;
                }
            }
        }
    }
}
