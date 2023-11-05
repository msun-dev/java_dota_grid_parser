package dev.msun.configGenerator.configUtils.customConfigs.dotabuff;

import java.awt.Point;
import java.util.ArrayList;

import dev.msun.configGenerator.configUtils.Config;

public class ConfigDB extends Config {
    public static final String NAME = "Hero:       Good against:                    Bad againts:                        Hero:      Good against:                    Bad againts:";
    public static final Point SIZE = new Point(1184, 4408);
    public static final Point POSITION = new Point(0, 0);

    public ConfigDB() {
        super("Dotabuff:Counters p.w.test"); // Dotabuff:Counters-v-7.34.13
    }

    public void generate(ArrayList<Integer> ids) {
        CategoryDB category = new CategoryDB(NAME, POSITION, SIZE, ids);
        addCategory(category);
    }

}