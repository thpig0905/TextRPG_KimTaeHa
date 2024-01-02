package Player;

import Game.GameCommand;
import Main.GameController;
import Util.Util;

public class GameOver implements GameCommand {
   private GameController controller = GameController.getInstance();
    @Override
    public void init() {
        System.out.println("[ 게임 오버 ]");
        System.out.println("[1] 게임 종료");
        System.out.println("[2] 부활");
    }

    @Override
    public boolean update() {
        int sel = Util.getInteger("메뉴", 1, 2);

        if (sel == 1) {
            controller.setNextWindow(null);
        } else if (sel == 2) {
            controller.setPlayer(new Player(controller.getPlayer().getName(),
                    controller.getPlayer().getLevel() - 3 <= 1 ? 1 : controller.getPlayer().getLevel() - 3));
            controller.setNextWindow("GameMain");
        }
        return false;
    }
}
