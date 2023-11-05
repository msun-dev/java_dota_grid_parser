import java.io.FileReader;
import java.util.ArrayList;
import java.io.Reader;
import java.io.IOException;

import com.google.gson.Gson;

import dev.msun.configGenerator.configUtils.Grid;
import dev.msun.configGenerator.configUtils.customConfigs.dotabuff.CategoryDB;
import dev.msun.configGenerator.configUtils.customConfigs.dotabuff.ConfigDB;
import dev.msun.parsers.json.JSONfier;
import dev.msun.parsers.json.heroTable.Hero;
import dev.msun.parsers.json.heroTable.HeroTable;
import dev.msun.parsers.web.DBParser;
import dev.msun.parsers.web.Scraper;
import dev.msun.configGenerator.GridGenerator;
import dev.msun.parsers.json.heroTable.HeroTable;

public class scuffedTests {

    // Since i never used junit and never made test classes before
    // here is some scuffed test class so i can check some things
    // and not bloat main.java. Also, i think, ill store some methods here so i can
    // reuse them in the main class.

    // Also it will be funny in the future to look back and see what i did

    public static void main(String[] args) throws Exception {
        GridGenerator gridGenerator = new GridGenerator();
        gridGenerator.createConfigDirs();
    }

    public static void writerTest() {
        GridGenerator generator = new GridGenerator();
        generator.createConfigFile("{[0],[1]}", "test_hero_grid.json", "");
        // Worked like bread and butter
    }

    public static void combinedTest() throws InterruptedException {
        // If this works - job is done and i can move to other things
        // Otherwise - more work!
        DBParser parser = new DBParser();
        ArrayList<Integer> arr = parser.parseCounters();
        ConfigDB config = new ConfigDB();
        config.generate(arr);
        // System.out.println(config);
        // It worked but console output is not enough to cv paste

        // :?
        GridGenerator generator = new GridGenerator();
        String JSONConfig = JSONfier.convert(config);
        generator.createConfigFile(JSONConfig, "test_hero_grid.json", "/configurations/Dotabuff");
    }

    public static void forLoopsTest() {
        // Little test of for loops
        ArrayList<ArrayList<Integer>> heroes = new ArrayList<ArrayList<Integer>>();

        for (int index = 0; index < 10; index++) {
            ArrayList<Integer> array = new ArrayList<Integer>();
            for (int i = 0; i < 5; i++) {
                array.add(i);
            }
            heroes.add(array);
        }
        System.out.println(heroes); // Full array
        System.out.println(heroes.get(0)); // First array of array of array
        System.out.println(heroes.get(0).get(1)); // Second element of first array of array of arrays

        // This thing used in configDB.generate method
        ArrayList<Integer> heroIDS = new ArrayList<Integer>();
        for (int catNum = 0; catNum < 2; catNum++) {
            for (int heroIndex = 0 + (heroes.size() / 2 * catNum); heroIndex < heroes.size() / 2; heroIndex++) {
                ArrayList<Integer> tempArray = heroes.get(heroIndex);
                for (int i = 0; i < tempArray.size(); i++) {
                    heroIDS.add(tempArray.get(i));
                }
            }
        }
        System.out.println(heroIDS);
    }

    public static void heroTableToObject() {
        HeroTable heroTable = HeroTable.class.cast(JSONfier.convert(
                "/home/msun/Desktop/jvm_/dota_layout_updater/app/src/main/resources/heroes.json", HeroTable.class));
        System.out.println(heroTable.getHeroIDByName("Muerta")); // muerta has id of 138 in this table
        System.out.println(heroTable.getHeroNameByID(138)); // returns "Muerta"
    }

    public static void parserTest() throws InterruptedException {
        DBParser parser = new DBParser();
        ArrayList<Integer> arr = parser.parseCounters();
        System.out.println(arr);
        // It worked PERFECTLY from the first test
        // Cool
    }

    public static void scraperTest() {
        // System.out.println(Scraper.getPage("https://www.dotabuff.com/"));
    }

    public static void JSONtoGrid() {
        GridGenerator gridfGenerator = new GridGenerator();
        if (gridfGenerator.setDirectory(
                "/home/msun/Desktop/jvm_/dota_layout_updater/app/src/main/resources/test_grid.json")) {
            System.out.println("File exists, converting to object.");
            Object grid = JSONfier.convert(gridfGenerator.getDirectory(), Grid.class);
            if (grid != null) {
                System.out.println(grid);
            } else {
                System.out.println("Grid is null. Doing nothing");
            }
        } else {
            // TODO: change it to something cool
            System.out.println("Couldn't set directory, check grid file directory.");
        }
    }

    public static void parentClassesJSON() {
        Grid grid = new Grid();
        ConfigDB config = new ConfigDB();
        CategoryDB category = new CategoryDB();

        config.addCategory(category);
        grid.addLayout(config);

        System.out.println("--------category---------");
        System.out.println(JSONfier.convert(category));
        System.out.println("---------layout----------");
        System.out.println(JSONfier.convert(config));
        System.out.println("----------grid-----------");
        System.out.println(JSONfier.convert(grid));
    }

}
