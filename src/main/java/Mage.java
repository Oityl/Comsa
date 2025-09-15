public class Mage extends Character {
    public Mage(int id, String name, int health, int attack, int defense) {
        super(id, name, health, attack, defense);
    }

    @Override
    public void display() {
        System.out.println("Маг: " + getName() + ", Здоровье: " + health +
                ", Атака: " + attack + ", Защита: " + defense);
    }

    @Override
    public Mage clone() {
        return (Mage) super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}