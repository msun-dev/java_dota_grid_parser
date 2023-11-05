package dev.msun;

import java.util.ArrayList;

import dev.msun.configGenerator.GridGenerator;
import dev.msun.configGenerator.configUtils.customConfigs.dotabuff.ConfigDB;
import dev.msun.parsers.json.JSONfier;
import dev.msun.parsers.web.DBParser;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        GridGenerator generator = new GridGenerator();
        generator.createConfigDirs();

        ConfigDB config = new ConfigDB();
        config.setConfigname("Dotabuff:Matchups-7.34d.1");

        DBParser parser = new DBParser();
        ArrayList<Integer> arr = parser.parseCounters();

        config.generate(arr);

        String JSONConfig = JSONfier.convert(config);
        generator.createConfigFile(JSONConfig, config.getName() + ".json", "configurations/Dotabuff");
    }
}