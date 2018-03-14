package app;

import io.appium.java_client.AppiumDriver;
import screen.Home;
import screen.Library;
import screen.Search;
import screen.Shop;

public class PlayStore {
    private AppiumDriver driver;

    public PlayStore(AppiumDriver driver) throws IllegalAccessException
    {
        this.driver = driver;
    }

    public Home Home()
    {
        return new Home(driver);
    }

    public Library Library()
    {
        return new Library(driver);
    }

    public Shop Shop()
    {
        return new Shop(driver);
    }

    public Search Search()
    {
        return new Search(driver);
    }

}
