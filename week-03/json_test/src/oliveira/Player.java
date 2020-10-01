package oliveira;

import java.util.HashMap;
import java.util.Map;

public class Player
{
    public Player(String name, int health, int mana, int gold) {
        this.name = name;
        this.health = health;
        this.mana = mana;
        this.gold = gold;

        this.equipment = new HashMap<>();
    }

    @Override
    public String toString() {
        String content = "Player{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", mana=" + mana +
                ", gold=" + gold +
                ", equipments={";

        for (Map.Entry<String, Integer> entry : equipment.entrySet()) {
            content += entry.getKey() + ", " + entry.getValue() + "; ";
        }

        content += "}";

        return content;
    }

    private String name;
    private int health;
    private int mana;
    private int gold;

    public void addEquipment(String equipmentName, int equipmentCost) {
        equipment.put(equipmentName, equipmentCost);
    }

    private Map<String, Integer> equipment;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }
}
