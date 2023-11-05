package dev.msun.configGenerator.configUtils.customConfigs.dotabuff;

import java.awt.Point;
import java.util.ArrayList;

import dev.msun.configGenerator.configUtils.Category;

public class CategoryDB extends Category {
    public CategoryDB(String category_name, Point position, Point size, ArrayList<Integer> hero_ids) {
        super(category_name, position, size, hero_ids);
    }

    public CategoryDB() {
        super();
    }
}
