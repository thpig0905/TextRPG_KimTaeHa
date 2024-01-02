package MenuStart;

import Game.GameCommand;
import Main.GameController;
import Player.Player;
import Util.Util;
import DAO.PlayerDAO;

public class SelectCharacter implements GameCommand {
    private GameController controller = GameController.getInstance();
    private PlayerDAO playerDAO = new PlayerDAO();
    @Override
    public void init() {
        System.out.println("[ 캐릭터 선택 ]");
        System.out.println("1. 소서러");
        System.out.println("2. 뱀파이어");
        System.out.println("3. 성직자");
    }

    @Override
    public boolean update() {
        int sel = Util.getInteger("캐릭터 선택", 1, 3);
        Util.printLoading(300);
        if (sel == 1) {
            System.out.println("소서러를 선택하셨습니다.");
            playerDAO.makePLayer(sel);
        } else if (sel == 2) {
            System.out.println("뱀파이어를 선택하셨습니다.");
            playerDAO.makePLayer(sel);
        } else if (sel == 3) {
            System.out.println("성직자를 선택하셨습니다.");
            playerDAO.makePLayer(sel);
        }
        controller.setStage(1);
        controller.setNextWindow("GameMain");
        return false;
    }
}
