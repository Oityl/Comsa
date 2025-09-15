public abstract class Character implements Cloneable {
    protected int id;
    protected String name;
    protected int health;
    protected int attack;
    protected int defense;

    public Character(int id, String name, int health, int attack, int defense) {
        this.id = id;
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getHealth() { return health; }
    public void setHealth(int health) { this.health = health; }

    public int getAttack() { return attack; }
    public void setAttack(int attack) { this.attack = attack; }

    public int getDefense() { return defense; }
    public void setDefense(int defense) { this.defense = defense; }

    public abstract void display();

    @Override
    public Character clone() {
        try {
            return (Character) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Клонирование не поддерживается", e);
        }
    }

    @Override
    public String toString() {
        return String.format("Character{id=%d, name='%s', health=%d, attack=%d, defense=%d}",
                id, name, health, attack, defense);
    }
}