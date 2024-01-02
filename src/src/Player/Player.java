package Player;

import Monster.Monster;
import Skill.Attackable;
import Skill.Skillable;
import SkillPlayer.*;
import Unit.Unit;

public class Player implements Unit, Attackable, Skillable, FireBall, Hurricane, IceBall, StarDrop, HolyLight, BloodSucking {
    private String name;
    private int LEVEL;
    private int MAX_EXP;
    private int exp;
    private int MAX_HP;
    private int hp;
    private int MAX_MP;
    private int mp;
    private int attack;
    private int magicAttack;
    private int defense;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getMAX_HP() { return MAX_HP; }
    public void setMAX_HP(int MAX_HP) { this.MAX_HP = MAX_HP; this.hp = MAX_HP; }
    public int getHP() { return hp; }
    public void setHP(int hp) { this.hp = hp; }
    public int getMAX_MP() { return MAX_MP; }
    public void setMAX_MP(int MAX_MP) { this.MAX_MP = MAX_MP; this.mp = MAX_MP; }
    public int getAttack() { return attack; }
    public void setAttack(int attack) { this.attack = attack; }
    public int getMagicAttack() { return magicAttack; }
    public void setMagicAttack(int magicAttack) { this.magicAttack = magicAttack; }
    public int getDefense() { return defense; }
    public void setDefense(int defense) { this.defense = defense; }
    public int getLEVEL() { return LEVEL; }
    public void setLEVEL(int LEVEL) { this.LEVEL = LEVEL; }
    public int getMAX_EXP() { return MAX_EXP; }
    public void setMAX_EXP(int MAX_EXP) { this.MAX_EXP = MAX_EXP; }
    public int getExp() { return exp; }
    public void setExp(int exp) { this.exp = exp; }
    public int getMp() { return mp; }
    public void setMp(int mp) { this.mp = mp; }
    public int getLevel() { return LEVEL; }
    public void setLevel(int LEVEL) { this.LEVEL = LEVEL; }

    public Player(String name, int LEVEL) {
        this.name = name;
        this.LEVEL = LEVEL;
        this.MAX_EXP = LEVEL * 100;
        this.exp = 0;
    }

    public String toString() {
        return String.format("[ 이름 : %s ]\t[ 레벨 : %d ]\t[ 경험치 : %d / %d ]\n[ HP : %d / %d ]\t[ MP : %d / %d ]\n[ 공격력 : %d ]\t[ 마법공격력 : %d ]\t[ 방어력 : %d ]"
                , name, LEVEL, exp, MAX_EXP, hp, MAX_HP, mp, MAX_MP, attack, magicAttack, defense);
    }

    @Override
    public void Attack(Monster target) {}

    @Override
    public void Attack(Player player) {}

    @Override
    public void bloodSucking(Monster target) {}

    @Override
    public void fireBall(Monster monster) {}

    @Override
    public void holyLight(Monster target) {}

    @Override
    public void hurricane(Monster monster) {}

    @Override
    public void iceBall(Monster monster) {}

    @Override
    public void starDrop(Monster monster) {}
}
