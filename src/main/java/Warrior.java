public class Warrior extends Character {
    public Warrior(int id, String name, int health, int attack, int defense) {
        super(id, name, health, attack, defense);
    }

    @Override
    public void display() {
        System.out.println("Воин: " + getName() + ", Здоровье: " + health + ", Атака: " + attack + ", Защита: " + defense);
    }

    @Override
    public Warrior clone() {
        return (Warrior) super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}