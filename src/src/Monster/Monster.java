package Monster;
import Player.Player;
import Skill.Attackable;
import Unit.Unit;
public class Monster implements Unit, Attackable {
    private String name;
    private int LEVEL;
    private int MAX_HP;
    private int hp;
    private int attack;
    private int magicAttack;
    private int defense;

    public int getLEVEL() { return LEVEL; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getMAX_HP() { return MAX_HP; }
    public void setMAX_HP(int MAX_HP) { this.MAX_HP = MAX_HP; this.hp = MAX_HP; }
    public int getHP() { return hp; }
    public void setHP(int hp) { this.hp = hp; }
    public int getAttack() { return attack; }
    public void setAttack(int attack) { this.attack = attack; }
    public int getMagicAttack() { return magicAttack; }
    public void setMagicAttack(int magicAttack) { this.magicAttack = magicAttack; }
    public int getDefense() { return defense; }
    public void setDefense(int defense) { this.defense = defense; }

    public Monster(int LEVEL) {
        this.name = name;
        this.LEVEL = LEVEL;
    }

    public String toString() {
        return String.format("[ 이름: %s | 레벨: %d | HP: %d/%d | 공격력: %d | 마법공격력: %d | 방어력: %d ]"
                , name, LEVEL, hp, MAX_HP, attack, magicAttack, defense);
    }

    @Override
    public void Attack(Monster monster) {}

    @Override
    public void Attack(Player player) {}
}
