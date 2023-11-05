package dev.msun.configGenerator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import dev.msun.configGenerator.configUtils.Config;

public class GridGenerator {
    private String configDir;

    public boolean setDirectory(String dir) {
        if (doConfigExists(dir)) {
            this.configDir = dir;
            return true;
        } else {
            return false;
        }
    }

    public String getDirectory() {
        return this.configDir;
    }

    public boolean doConfigExists(String dir) {
        return (new File(dir).isFile());
    }

    public void readConfig() {
    }

    public void createConfigDirs() {
        new File("configurations/Dotabuff").mkdirs();
    }

    public void createConfigFile(String config, String name, String dir) {
        // Need to check current configs before parsing
        // DO IT !!!x
        try {
            File file = new File(name);
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
                FileWriter writer = new FileWriter(new File(dir, name));
                writer.write(config);
                writer.close();
                System.out.println("Wrote config to file: " + name);
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred in filereader.");
            e.printStackTrace();
        }
    }

    public void addLayout(String name, int categoriesNum) {

    }

    public void removeLayout(String name) {

    }

    public void addCategoryToLayout() {

    }

    public void removeCategoryFromLayout() {

    }

    public void updateLayout(String name, Config newLayout) {

    }
}
