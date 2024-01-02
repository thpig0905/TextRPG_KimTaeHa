package DAO;

import Main.GameController;
import Player.*;

public class PlayerDAO {
    private GameController controller = GameController.getInstance();
    public void makePLayer(int num) {
        int level = 1;
        if (num == 1){
            controller.setPlayer(new Sorcerer("소서러", level));
            System.out.println(controller.getPlayer());
        } else if (num == 2) {
            controller.setPlayer(new Vampire("뱀파이어", level));
            System.out.println(controller.getPlayer());
        } else if (num == 3) {
            controller.setPlayer(new Priest("성직자", level));
            System.out.println(controller.getPlayer());
        }
    }

    public Player LevelUp(Player player) {
        System.out.println("=====[ 레벨업 ]=====");
        int level = player.getLevel() + player.getMAX_EXP() / player.getExp();
        int exp = player.getExp() - player.getMAX_EXP();
        player = new Player(player.getName(), level);
        player.setExp(exp);
        player.setMAX_HP(level * 450);
        player.setMAX_MP(0);
        player.setAttack(level * 10);
        player.setMagicAttack(player.getMAX_HP() / 10 + 5 * level);
        player.setDefense(level * 15);
        return player;
    }

    public int printSkillList(){
        if (controller.getPlayer().getName().equals("소서러")) {
            System.out.println("[1] 파이어볼");
            System.out.println("[2] 아이스볼");
            System.out.println("[3] 스타드롭");
            System.out.println("[4] 허리케인");
            System.out.println("[5] 공격");
            return 5;
        } else if (controller.getPlayer().getName().equals("성직자")) {
            System.out.println("[1] 성스러운 빛");
            System.out.println("[2] 공격");
            return 2;
        } else if (controller.getPlayer().getName().equals("뱀파이어")) {
            System.out.println("[1] 흡혈");
            System.out.println("[2] 공격");
            return 2;
        }
        return 0;
    }

    public void battle(int sel){
        if (controller.getPlayer().getName().equals("소서러")) {
            if (sel == 1) {
                controller.getPlayer().fireBall(controller.getMonster());
            } else if (sel == 2) {
                controller.getPlayer().iceBall(controller.getMonster());
            } else if (sel == 3) {
                controller.getPlayer().starDrop(controller.getMonster());
            } else if (sel == 4) {
                controller.getPlayer().starDrop(controller.getMonster());
            } else if (sel == 5) {
                controller.getPlayer().Attack(controller.getMonster());
            }
        } else if (controller.getPlayer().getName().equals("성직자")) {
            if (sel == 1) {
                controller.getPlayer().holyLight(controller.getMonster());
            } else if (sel == 2) {
                controller.getPlayer().Attack(controller.getMonster());
            }
        } else if (controller.getPlayer().getName().equals("뱀파이어")) {
            if (sel == 1) {
                controller.getPlayer().bloodSucking(controller.getMonster());
            } else if (sel == 2) {
                controller.getPlayer().Attack(controller.getMonster());
            }
        }
        System.out.println(controller.getMonster());
    }

}
