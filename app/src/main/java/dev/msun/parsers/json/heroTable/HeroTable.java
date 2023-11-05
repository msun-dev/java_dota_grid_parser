package dev.msun.parsers.json.heroTable;

import java.util.ArrayList;

public class HeroTable {
    public ArrayList<Hero> heroes;

    public HeroTable() {
    }

    public int getHeroIDByName(String name) {

        // I'm sure you can do the same using some one-line statement
        // But i dont know how
        // Sad
        int id = 0;
        for (Hero hero : heroes) {
            if (hero.compareNames(name)) {
                id = hero.getId();
                break;
            }
        }
        return id;
    }

    public String getHeroNameByID(int id) {
        String name = null;
        for (Hero hero : heroes) {
            if (hero.getId() == id) {
                name = hero.getName();
                break;
            }
        }
        return name;
    }
}
