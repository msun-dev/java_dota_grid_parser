package dev.msun.parsers.json.heroTable;

public class Hero {
    public int id;
    public String localized_name;

    public Hero() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return localized_name;
    }

    public boolean compareNames(String name) {
        return getName().equals(name);
    }
}
