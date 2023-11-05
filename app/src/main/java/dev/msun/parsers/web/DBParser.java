package dev.msun.parsers.web;

import org.checkerframework.checker.units.qual.A;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import org.jsoup.nodes.Element;
import org.jsoup.parser.Tag;

import java.io.IOException;
import java.util.ArrayList;

import dev.msun.parsers.json.heroTable.HeroTable;
import dev.msun.parsers.json.JSONfier;

// The thing is
// I want to make abstact scrape class so i can make child classes for every data-providing website (DB, stratz, OpenDota)
// But
// It always come down to making excluse scraper for every website
// ...
// I saw someone made "universal parser" (https://github.com/miguelangelo78/Universal-Web-Scraper)
// But everything is just comes down to making separate algo for every website.
// So here it is

public class DBParser {
    private Scraper scraper = new Scraper();
    private HeroTable heroTable = HeroTable.class.cast(JSONfier.convert(
            "/home/msun/Desktop/jvm_/dota_layout_updater/app/src/main/resources/heroes.json", HeroTable.class));

    // Are you allowed to use this kind of type?
    public ArrayList<Integer> parseCounters() throws InterruptedException {
        // I wonder how garbage collector works in java

        // I think i can use only 1 dimensional array
        // But that way you can see logic behind it
        // Like Array of Arrays of heroes and their good/bad matchups
        //
        // Nah, i think it will stay this way
        // Bcs you can loop more easily through arrays
        // Because here is 124 heroes, hence 124 arrays
        //
        // I removed double array list. For good
        ArrayList<Integer> heroIDs = new ArrayList<Integer>();

        Document document = Jsoup.parse(scraper.getPage("https://www.dotabuff.com/heroes/"));
        Elements heroGrid = document.getElementsByClass("hero-grid");
        heroGrid = heroGrid.select("a");
        ArrayList<String> heroesToParse = new ArrayList<>();

        for (Element e : heroGrid) {
            heroesToParse.add(e.attr("href"));
        }

        int heroIter = 0; // lil' iterator

        for (String heroLink : heroesToParse) {
            document = Jsoup.parse(scraper.getPage("https://www.dotabuff.com" + heroLink));

            String heroName = document.getElementsByClass("header-content-title")
                    .select("h1")
                    .first()
                    .ownText();
            // I dont even know why i parse page just to get current hero name
            // In fact i could've done it a bit earlier when
            // i take value from heroGrid array and just format it.
            // But im lazy and, i guess, now know how to take correct value
            // from tag and remove unwanted things.

            heroIDs.add(heroTable.getHeroIDByName(heroName));
            heroIDs.add(0); // 0 id hero is just empty space

            // Now i want to find correct id for hero using heroName in heroes.json file
            // and make class for it (Done)

            System.out.println("Parsing " + heroName);

            Elements sections = document.getElementsByTag("section");
            for (Element section : sections) {
                String sectionText = section.getElementsByTag("header").text();

                // I can make separate method for for loops
                // But i wont
                // He-he~
                if (sectionText.indexOf("Best Versus") != -1) {
                    Elements bvHeroes = section.getElementsByClass("link-type-hero");
                    for (int i = 0; i < 5; i++) {
                        heroIDs.add(
                                heroTable.getHeroIDByName(bvHeroes.get(i).getElementsByTag("a").first().ownText()));
                        // Beautiful one liner
                    }
                    heroIDs.add(0);
                }
                if (sectionText.indexOf("Worst Versus") != -1) {

                    Elements wvHeroes = section.getElementsByClass("link-type-hero");
                    for (int i = 0; i < 5; i++) {
                        heroIDs.add(
                                heroTable.getHeroIDByName(wvHeroes.get(i).getElementsByTag("a").first().ownText()));
                        // Beautiful one liner #2
                    }

                }

                // For some reasons the more i write code on java, the more i think it looks
                // like python.
                // Especially when working on selenium part of the app

                // I dont know java way of writing code
                // Maybe that's why

                // Not the "java way", but like taking full advantage of java synt sugar

            }

            if (heroIter % 2 == 0) {
                heroIDs.add(0); // Add empty space after even number of hero
            }
            heroIter++; // look at him!
        }
        scraper.close();

        return heroIDs;
    }

}
