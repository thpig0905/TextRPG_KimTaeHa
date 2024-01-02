package Player;

import DAO.PlayerDAO;
import Main.GameController;
import Monster.Monster;
import SkillPlayer.BloodSucking;

public class Vampire extends Player implements BloodSucking {
    private GameController controller = GameController.getInstance();
    private PlayerDAO playerDAO = new PlayerDAO();
    public Vampire(String name, int LEVEL) {
        super(name, LEVEL);
        setMAX_HP(LEVEL * 450);
        setMAX_MP(0);
        setAttack(LEVEL * 10);
        setMagicAttack(super.getMAX_HP() / 10 + 5 * LEVEL);
        setDefense(LEVEL * 15);
    }

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
        System.out.printf("%s가 %d의 피해를 흡혈합니다.\n", getName(), getMagicAttack());
        if (getHP() + getMagicAttack() >= getMAX_HP()) {
            setHP(getMAX_HP());
        } else {
            setHP(getHP() + getMagicAttack());
        }
        System.out.println(this);
    }

    @Override
    public void bloodSucking(Monster target) {
        if (getHP() - 20 < 10) {
            System.out.println("체력이 부족합니다.");
            System.out.println("[ 필요 체력 : 20 ]");
            return;
        }
        setHP(getHP() - 20);

        System.out.printf("%s가 %s에게 흡혈을 시전합니다.\n", getName(), target.getName());
        System.out.printf("%s가 %d의 피해를 입었습니다.\n", target.getName(), getMagicAttack() * 2);
        target.setHP(target.getHP() - (getMagicAttack() * 2 - target.getDefense()));

        int recover = getMagicAttack();
        if (getHP() + recover >= getMAX_HP()) {
            System.out.printf("%s가 %d의 체력을 회복합니다.\n", getName(), getMAX_HP() - getHP());
            setHP(getMAX_HP() + recover);
        } else {
            System.out.println(getName() + "가 " + recover + "의 체력을 회복합니다.");
            setHP(getHP() + recover);
        }

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
    }
}
