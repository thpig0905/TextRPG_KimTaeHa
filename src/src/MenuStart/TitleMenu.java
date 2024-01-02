package MenuStart;

import Game.GameCommand;
import Main.GameController;
import Util.Util;
import Text.*;

public class TitleMenu implements GameCommand {
    private GameController controller = GameController.getInstance();

    @Override
    public void init() {
        GameTitle.printGameTitle();
        Util.delay(1000);
        System.out.println("1. 게임 시작");
        Util.delay(300);
        System.out.println("2. 게임 종료");
        Util.delay(300);
    }

    @Override
    public boolean update() {
        int sel = Util.getInteger("메뉴 선택", 1, 2);
        Util.printLoading(300);
        if (sel == 1) {
            Story.printStartStory();
            controller.setNextWindow("SelectCharacter");
        } else if (sel == 2) {
            controller.setNextWindow(null);
        }
        return false;
    }
}
