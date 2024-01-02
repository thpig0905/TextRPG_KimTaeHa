package Player;

import DAO.PlayerDAO;
import Main.GameController;
import Monster.Monster;
import SkillPlayer.HolyLight;

public class Priest extends Player {
    private GameController controller = GameController.getInstance();
    private PlayerDAO playerDAO = new PlayerDAO();
    public Priest(String name, int LEVEL) {
        super(name, LEVEL);
        setMAX_HP(LEVEL * 250);
        setMAX_MP(LEVEL * 300);
        setAttack(LEVEL * 20);
        setMagicAttack(LEVEL * 20);
        setDefense(LEVEL * 25);
    }
    @Override
    public void Attack(Monster target) {
        PlayerDAO playerDAO = new PlayerDAO();

        System.out.printf("%s가 %s를 공격합니다.\n", getName(), target.getName());
        System.out.printf("%s가 %d의 피해를 입었습니다.\n", target.getName(), getAttack() - target.getDefense());
        target.setHP(target.getHP() - (getAttack() - target.getDefense()));
        if (target.getHP() <= 0) {
            System.out.printf("%s를 처치했습니다.\n", target.getName());
            System.out.printf("경험치를 %d 획득했습니다.", controller.getStage() * target.getLEVEL() * 10);
            setExp(getExp() + (controller.getStage() * target.getLEVEL() * 10));
            if (getExp() >= getMAX_EXP()){
                controller.setPlayer(playerDAO.LevelUp(this));
            } else {
                controller.setPlayer(new Player(getName(), getLEVEL()));
                setExp(getExp() + (controller.getStage() * target.getLEVEL() * 10));
            }
        }

        System.out.println(this);
    }

    @Override
    public void holyLight(Monster target) {
        if (getMp() - 300 < 0) {
            System.out.println("마나가 부족합니다.");
            System.out.println("[ 필요 마나 : 20 ]");
            return;
        }
        setMp(getMp() - 300);

        System.out.printf("%s가 %s에게 성스러운 빛을 시전합니다.\n", getName(), target.getName());
        if (target.getName().equals("고블린") || target.getName().equals("박쥐") || target.getName().equals("골렘") || target.getName().equals("드래곤")) {
            System.out.printf("%s가 %d의 피해를 입었습니다.\n", target.getName(), getMagicAttack() + getAttack() + getDefense() + 5 * getLEVEL() * 2 / 10 - target.getDefense());
            target.setHP(target.getHP() - (getMagicAttack() * 5 / 2 - target.getDefense()));
        } else {
            System.out.printf("%s가 %d의 피해를 입었습니다.\n", target.getName(), getMagicAttack() + getAttack() + getDefense() + 5 * getLEVEL() - target.getDefense());
            target.setHP(target.getHP() - (getMagicAttack() * 5 / 2 - target.getDefense()));
        }
        boolean check = false;
        if (getHP() == getMAX_HP()) {
            Attack(target);
            check = true;
        } else {
            System.out.printf("%s가 체력을 완전히 회복합니다.\n", getName());
            setHP(getMAX_HP());
        }

        if (target.getHP() <= 0 && !check) {
            System.out.printf("%s를 처치했습니다.\n", target.getName());
            System.out.printf("경험치를 %d 획득했습니다.", controller.getStage() * target.getLEVEL() * 10);
            setExp(getExp() + (controller.getStage() * target.getLEVEL() * 10));
            if (getExp() >= getMAX_EXP()){
                controller.setPlayer(playerDAO.LevelUp(this));
            } else {
                controller.setPlayer(new Player(getName(), getLEVEL()));
                setExp(getExp() + (controller.getStage() * target.getLEVEL() * 10));
            }
        }
    }
}
