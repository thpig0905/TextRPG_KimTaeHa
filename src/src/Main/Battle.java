package Main;

import Game.GameCommand;
import DAO.*;
import Util.Util;

public class Battle implements GameCommand {
    private GameController controller = GameController.getInstance();
    private PlayerDAO playerDAO = new PlayerDAO();
    private MonsterDAO monsterDAO = new MonsterDAO();
    @Override
    public void init() {
        System.out.printf("[ %s와 Battle ]\n", controller.getMonster().getName());
        System.out.println(controller.getMonster());
    }

    @Override
    public boolean update() {
        int max = playerDAO.printSkillList();

        while (true){
            System.out.println("============================================");
            int sel = Util.getInteger("스킬 선택", 1, max);
            playerDAO.battle(sel);
            if (controller.getMonster().getHP() == 0) {
                controller.setStage(controller.getStage() + 1);
                controller.setNextWindow("GameMain");
                break;
            }
            System.out.println("============================================");
            monsterDAO.battle();
            if (controller.getPlayer().getHP() == 0) {
                controller.setStage(controller.getStage() - 1);
                controller.setNextWindow("GameOver");
                break;
            }
        }
        return false;
    }
}
