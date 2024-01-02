package Monster;

import Main.GameController;
import Player.Player;

public class Slime extends Monster{
    private GameController controller = GameController.getInstance();
    public Slime(int LEVEL) {
        super(LEVEL);
        setName("슬라임");
        setMAX_HP(LEVEL * 100);
        setAttack(LEVEL * 7);
        setDefense(LEVEL * 5);
        setMagicAttack(LEVEL * 5);
    }
    public void Attack(Player target) {
        System.out.printf("%s가 %s를 공격합니다.\n", getName(), target.getName());
        System.out.printf("%s가 %d의 피해를 입었습니다.\n", target.getName(), getAttack() - target.getDefense());
        target.setHP(target.getHP() - (getAttack() - target.getDefense()));
        if (target.getHP() <= 0) {
            System.out.printf("%s가 사망하였습니다.\n", target.getName());
            controller.setNextWindow("GameOver");
        }
        System.out.println(target);
    }
}
