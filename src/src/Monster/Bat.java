package Monster;

import Main.GameController;
import Player.Player;

public class Bat extends Monster{
    private GameController controller = GameController.getInstance();
    public Bat(int LEVEL) {
        super(LEVEL);
        super.setName("박쥐");
        setMAX_HP(LEVEL * 120);
        setAttack(LEVEL * 10);
        setDefense(LEVEL * 10);
        setMagicAttack(super.getMAX_HP() / 10 + LEVEL * 2);
    }

    public void Attack(Player target) {
        System.out.printf("%s가 %s를 공격합니다.\n", getName(), target.getName());
        System.out.printf("%s가 %d의 피해를 입었습니다.\n", target.getName(), getAttack() - target.getDefense());
        target.setHP(target.getHP() - (getAttack() - target.getDefense()));
        if (target.getHP() <= 0) {
            System.out.printf("%s가 사망하였습니다.\n", target.getName());
            controller.setNextWindow("GameOver");
        }
        System.out.printf("%s가 %d만큼 흡혈 했습니다.\n", getName(), getMagicAttack());
        if (getHP() + getMagicAttack() >= getMAX_HP()) {
            setHP(getMAX_HP());
        } else {
            setHP(getHP() + getMagicAttack());
        }
        System.out.println(target);
    }
}
