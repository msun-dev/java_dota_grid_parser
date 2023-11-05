package dev.msun.configGenerator.configUtils;

import java.util.ArrayList;

public class Grid {
    public int version = 3;
    public ArrayList<Config> configs = new ArrayList<Config>();

    public Grid() {
    }

    public void createLayout() {

    }

    public void addLayout(Config layout) {
        configs.add(layout);
    }

    @Override
    public String toString() {
        StringBuilder lays = new StringBuilder();
        configs.forEach(lays::append);
        String config = "Configuration: " + "\n" + configs;
        return config;
    }
}
