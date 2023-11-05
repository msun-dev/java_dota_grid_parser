package dev.msun.parsers.web;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Scraper {
    private WebDriver webDriver = new FirefoxDriver(new FirefoxOptions().addArguments("-headless"));
    private final int WAIT_SEC = 5;

    public String getPage(String url) throws InterruptedException {
        String inner = null;
        try { // webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WAIT_SEC));
            Thread.sleep(3000);
            // Since there is no .sleep() method in selenium like its in python
            // I will use thread sleep so i dont trigger dotabuffs thing
            // that slows down usage of website for me.
            // After some selenium spamming i couldnt open dotabuff anymore (with no
            // internet errors)

            // OK, i cant even check if this soultion works bcs i cant load DB page >:|

            // Now its ok, i think

            // Nope, still doesnt work

            webDriver.get(url);
            inner = webDriver.getPageSource();
            // If you use quit after trying to get page source - you will get errors.
            // Sometimes.
            return inner;
        } catch (InterruptedException e) {
            return inner;
        }

    }

    public int getTabCount() {
        return new ArrayList<String>(webDriver.getWindowHandles()).size();
    }

    public void close() {
        webDriver.quit();
    }
}
