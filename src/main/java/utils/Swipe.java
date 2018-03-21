package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;

import static java.time.Duration.ofMillis;

public class Swipe {
    public void down(AppiumDriver driver)
    {
        int height = driver.manage().window().getSize().height;
        int width = driver.manage().window().getSize().width;

        new TouchAction(driver)
                .press(width / 2, height / 2)
                .waitAction(ofMillis(0))
                .moveTo(width / 2, -(height + height) / 2)
                .release()
                .perform();
    }
}
