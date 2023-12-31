package Monster;

import Main.GameController;
import Player.Player;
import Skill.Attackable;
import Unit.Unit;

public class Goblin extends Monster {
    private GameController controller = GameController.getInstance();
    public Goblin(int LEVEL) {
        super(LEVEL);
        setName("고블린");
        setMAX_HP(LEVEL * 50);
        setAttack(LEVEL * 8);
        setDefense(LEVEL * 2);
        setMagicAttack(LEVEL * 5);
    }

    public void Attack(Player target) {
        System.out.printf("%s가 %s를 공격합니다.\n", getName(), target.getName());
        if (getAttack() - target.getDefense() >= 0) {
            System.out.printf("%s가 %d의 피해를 입었습니다.\n", target.getName(), getAttack() - target.getDefense());
            target.setHP(target.getHP() - (getAttack() - target.getDefense()));
        } else {
            System.out.printf("%s가 %d의 피해를 입었습니다.\n", target.getName(), 0);
        }
        target.setHP(target.getHP() - (getAttack() - target.getDefense()));
        if (target.getHP() <= 0) {
            System.out.printf("%s가 사망하였습니다.\n", target.getName());
            controller.setNextWindow("GameOver");
        }
        System.out.println(target);
    }
}
