package MenuGame;
import Game.GameCommand;
import Main.GameController;
import Util.Util;
import DAO.*;

public class GameMain implements GameCommand{
    private GameController controller = GameController.getInstance();
    private MonsterDAO monsterDAO = new MonsterDAO();
    @Override
    public void init() {
        System.out.println("=====[ 게임 메인 ]=====");
        System.out.println("[1] 싸우기");
        System.out.println("[2] 도망가기");
    }

    @Override
    public boolean update() {
        int sel = Util.getInteger("메뉴", 1, 2);

        controller.setMonster(monsterDAO.makeMonster());

        if (sel == 1) {
            controller.setNextWindow("Battle");
        } else if (sel == 2) {
            int runOut = Util.getRandInteger(controller.getStage(), controller.getMonster().getLEVEL());
            if (runOut % 2 == 0){
                controller.setNextWindow("GameMain");
            } else {
                controller.setNextWindow("Battle");
            }
        }
        return false;
    }
}
