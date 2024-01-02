package DAO;

import Main.GameController;
import Monster.Monster;
import Util.Util;
import Monster.*;

public class MonsterDAO {
    private GameController controller = GameController.getInstance();

    public Monster makeMonster() {
        int level = Util.getRandInteger(controller.getStage(), controller.getStage() * 3);

        if (level <= 3) {
            return new Goblin(level);
        } else if (level >= 4 && level <= 6) {
            return new Slime(level);
        } else if (level >= 7 && level <= 9) {
            return new Mushroom(level);
        } else if (level >= 10 && level <= 12) {
            return new Bat(level);
        } else if (level >= 13 && level <= 15) {
            return new Golem(level);
        } else if (level >= 16) {
            if (level >= 30){
                Dragon dragon = new Dragon(level);
                dragon.setName("드래곤 ( 보스 ) [ Level : " + level + " ]");
                dragon.setHP(dragon.getHP() * 2);
                dragon.setAttack(dragon.getAttack() * 2);
                dragon.setDefense(dragon.getDefense() * 2);
                dragon.setMagicAttack(dragon.getMagicAttack() * 2);
                return dragon;
            }
            return new Dragon(level);
        }

        return null;
    }

    public void battle() {
        controller.getMonster().Attack(controller.getPlayer());
        System.out.println(controller.getPlayer());
    }
}
