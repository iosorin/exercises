import java.util.Random;
import java.util.Arrays;
import java.util.EnumMap;

class DnDCharacter {
    final int THROW_COUNT = 4;
    final int[] THROW_RANGE = {1, 6};

    final int CONSTITUTION_FACTOR = 10;

    public enum Ability {
        Strength,
        Dexterity,
        Constitution,
        Intelligence,
        Wisdom,
        Charisma,
    }

    EnumMap<Ability, Integer> abilities = new EnumMap<Ability, Integer>(Ability.class);

    int ability() {
        int ints[] = new Random().ints(THROW_COUNT, THROW_RANGE[0], THROW_RANGE[1]).toArray();

        Arrays.sort(ints);

        return Arrays.stream(ints).sum() - ints[0];
    }

    int modifier(int constitution) {
        return (int) Math.ceil((CONSTITUTION_FACTOR - constitution) * 0.5) * -1;
    }

    int get(Ability name) {
        if (abilities.containsKey(name)) return abilities.get(name);

        int value = ability();

        abilities.put(name, value);

        return value;
    }

    int getStrength() { return get(Ability.Strength); }
    
    int getDexterity() { return get(Ability.Dexterity); }
    
    int getConstitution() { return get(Ability.Constitution); }
    
    int getIntelligence() { return get(Ability.Intelligence); }
    
    int getWisdom() { return get(Ability.Wisdom); }
    
    int getCharisma() { return get(Ability.Charisma); }
    
    int getHitpoints() { return CONSTITUTION_FACTOR + modifier(getConstitution()); }
}
