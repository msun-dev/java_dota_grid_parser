package dev.msun.configGenerator.configUtils;

import java.util.ArrayList;

public class Config {
    // There is still should be abstract Config and Category
    // And this class should be DefaultCategory and etc
    public String config_name;
    public ArrayList<Category> categories = new ArrayList<Category>();

    public Config(String config_name) {
        this.config_name = config_name;
    }

    public Config() {
        this.config_name = "New generated congfiguration";
    }

    public void setConfigname(String config_name) {
        this.config_name = config_name;
    }

    public String getName() {
        return config_name;
    }

    public int getCategoriesNum() {
        return categories.size();
    }

    public void addCategory(Category category) {
        categories.add(category);
    }

    @Override
    public String toString() {
        StringBuilder cats = new StringBuilder();
        categories.forEach(cats::append);
        String layout = "Layout:" +
                "\n   Name=" + getName() +
                "\n   Size=" + getCategoriesNum() +
                "\nCategories:" +
                "\n" + cats;
        return layout;
    }
}
