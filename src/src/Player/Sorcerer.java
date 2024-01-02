package Player;

import DAO.PlayerDAO;
import Main.GameController;
import Monster.Monster;
import SkillPlayer.FireBall;
import SkillPlayer.Hurricane;
import SkillPlayer.IceBall;
import SkillPlayer.StarDrop;

public class Sorcerer extends Player implements FireBall, Hurricane, IceBall, StarDrop {
    private GameController controller = GameController.getInstance();
    private PlayerDAO playerDAO = new PlayerDAO();
    public Sorcerer(String name, int LEVEL) {
        super(name, LEVEL);
        super.setMAX_HP(LEVEL * 80);
        super.setMAX_MP(LEVEL * 250);
        super.setAttack(LEVEL * 8);
        super.setMagicAttack(super.getMAX_MP() / 10 + LEVEL * 10);
        super.setDefense(LEVEL * 5);
    }

    public void Attack(Monster target) {
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
    public void fireBall(Monster target) {
        if (getMp() - 10 < 0) {
            System.out.println("마나가 부족합니다.");
            System.out.println("[ 필요 마나 : 10 ]");
            return;
        }
        setMp(getMp() - 10);

        System.out.printf("%s가 %s에게 파이어볼을 시전합니다.\n", getName(), target.getName());
        System.out.printf("%s가 %d의 피해를 입었습니다.\n", target.getName(), getMagicAttack() * 2 - target.getDefense());
        target.setHP(target.getHP() - (getMagicAttack() * 2 - target.getDefense()));

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
    public void hurricane(Monster target) {
        if (getMp() - 20 < 0) {
            System.out.println("마나가 부족합니다.");
            System.out.println("[ 필요 마나 : 20 ]");
            return;
        }
        setMp(getMp() - 20);

        System.out.printf("%s가 %s에게 허리케인을 시전합니다.\n", getName(), target.getName());
        System.out.printf("%s가 %d의 피해를 입었습니다.\n", target.getName(), getMagicAttack() * 5 / 2 - target.getDefense());
        target.setHP(target.getHP() - (getMagicAttack() * 5 / 2 - target.getDefense()));

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

    @Override
    public void iceBall(Monster target) {
        if (getMp() - 25 < 0) {
            System.out.println("마나가 부족합니다.");
            System.out.println("[ 필요 마나 : 25 ]");
            return;
        }
        setMp(getMp() - 25);

        System.out.printf("%s가 %s에게 아이스볼을 시전합니다.\n", getName(), target.getName());
        System.out.printf("%s가 %d의 피해를 입었습니다.\n", target.getName(), getMagicAttack() * 3 / 2);
        target.setHP(target.getHP() - (getMagicAttack() * 3 / 2 - target.getDefense()));

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

    @Override
    public void starDrop(Monster target) {
        if (getMp() - 100 < 0) {
            System.out.println("마나가 부족합니다.");
            System.out.println("[ 필요 마나 : 100 ]");
            return;
        }
        setMp(getMp() - 100);

        System.out.printf("%s가 %s에게 스타드롭을 시전합니다.\n", getName(), target.getName());
        System.out.printf("%s가 %d의 피해를 입었습니다.\n", target.getName(), getMagicAttack() * 5);
        target.setHP(target.getHP() - (getMagicAttack() * 5 - target.getDefense()));

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
