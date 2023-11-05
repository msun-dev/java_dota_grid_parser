package dev.msun.configGenerator.configUtils;

import java.awt.Point;
import java.util.ArrayList;

public class Category {
    public String category_name;
    public float x_position;
    public float y_position;
    public float width;
    public float height;
    public ArrayList<Integer> hero_ids = new ArrayList<Integer>();
    private final float MX_WIDTH = 1250;
    private final float PX_BETWEEN = 5;
    // private final float maxHeight = ????

    public Category(String category_name, Point position, Point size, ArrayList<Integer> hero_ids) {
        this.category_name = category_name;
        this.x_position = (float) position.getX();
        this.y_position = (float) position.getY();
        this.width = (float) size.getX();
        this.height = (float) size.getY();
        this.hero_ids = hero_ids;
    }

    public Category() {
        this.category_name = "Default category";
        this.x_position = 0;
        this.y_position = 0;
        this.width = 0;
        this.height = 0;
        ArrayList<Integer> tempHeroIds = new ArrayList<Integer>();
        for (int i = 1; i < 6; i++) {
            tempHeroIds.add(i);
        }
        this.hero_ids = tempHeroIds;
    }

    public void setCategoryName(String category_name) {
        this.category_name = category_name;
    }

    public void setXposition(float x_position) {
        this.x_position = x_position;
    }

    public void setYposition(float y_position) {
        this.y_position = y_position;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public int getHeroesSize() {
        return hero_ids.size();
    }

    public String getName() {
        return category_name;
    }

    public void addHero(int heroID) {
        hero_ids.add(heroID);
    }

    public float calcWidth(int amount) {
        return 0.0f;
    }

    @Override
    public String toString() {
        // sorry.
        return "    Category: Name=" + getName() + " | Size=" + getHeroesSize() + "\n";
    }
}
