package dev.msun.parsers.json;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Modifier;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.JsonIOException;

import dev.msun.configGenerator.configUtils.Grid;
import dev.msun.configGenerator.configUtils.Config;
import dev.msun.configGenerator.configUtils.Category;

public class JSONfier {
    // Should you use overload like that or you should use class as method?
    public static String convert(Category category) {
        System.out.println("Converting category to JSON.");
        Gson gson = new GsonBuilder()
                .excludeFieldsWithModifiers(Modifier.PRIVATE, Modifier.FINAL)
                .setPrettyPrinting()
                .create();
        String json = gson.toJson(category);
        return json;
    }

    public static String convert(Config config) {
        System.out.println("Converting config to JSON.");
        Gson gson = new GsonBuilder()
                .excludeFieldsWithModifiers(Modifier.PRIVATE, Modifier.FINAL)
                .setPrettyPrinting()
                .create();
        String json = gson.toJson(config);
        return json;
    }

    public static String convert(Grid grid) {
        System.out.println("Converting grid to JSON.");
        Gson gson = new GsonBuilder()
                .excludeFieldsWithModifiers(Modifier.PRIVATE, Modifier.FINAL)
                .setPrettyPrinting()
                .create();
        String json = gson.toJson(grid);
        return json;
    }

    public static Object convert(String dir, Class<?> cls) {
        System.out.println("Converting JSON to " + cls + ".");
        Gson gson = new Gson();
        try (Reader reader = new FileReader(dir)) {
            Object grid = gson.fromJson(reader, cls);
            return grid;
        } catch (IOException e) {
            System.out.println("Error occured while reading JSON file.");
            return null;
        } catch (JsonSyntaxException e) {
            System.out.println("Error occured while reading JSON: Syntax.");
            return null;
        } catch (JsonIOException e) {
            System.out.println("Error occured while reading JSON: IOE.");
            return null;
        }
        // Cool, now i stumbled upon another problem
        // I dont know how to make method overload but not for incomnig arguments
        // But for classes
        // ...
        // So i can use any class specified to convert from JSON to specified class.
        // :)

        // Ok, i found the solution
        // That was easier than i expected
        // Just use Class<?> as passing value
        //

        // Add obj casting to return
    }
}
