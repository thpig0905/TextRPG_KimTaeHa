package Skill;
import Monster.Monster;
import Player.Player;
import Unit.Unit;
public interface Attackable {
    public void Attack(Monster monster);
    public void Attack(Player player);

}
