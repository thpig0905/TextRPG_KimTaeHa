package Main;
import Player.Player;
class Sorcerer1 extends Player {
    public Sorcerer1(String name, int LEVEL) {
        super(name, LEVEL);
        super.setMAX_HP(LEVEL * 80);
        super.setMAX_MP(LEVEL * 250);
        super.setAttack(LEVEL * 8);
        super.setMagicAttack(super.getMAX_MP() / 10 + LEVEL * 10);
        super.setDefense(LEVEL * 5);
    }
}

public class TestMain {
    public static void main(String[] args) {
        Sorcerer1 sorcerer1 = new Sorcerer1("소서러", 2);
        System.out.println(sorcerer1);
        sorcerer1.setMAX_HP(100);
        System.out.println(sorcerer1);
    }
}
