package driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DesiredCapab {
    public static AndroidDriver setup() throws MalformedURLException, IllegalAccessException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("deviceName","D5803");
        dc.setCapability("platformVersion", "6.0.1");
        dc.setCapability("deviceOrientation", "portrait");
        dc.setCapability("platformName","Android");
        dc.setCapability("platform","ANDROID");
        dc.setCapability("app","com.google.android.apps.books");
        dc.setCapability("appActivity","com.google.android.apps.play.books.app.HomeActivity");
        dc.setCapability("appPackage", "com.google.android.apps.books");
        dc.setCapability("autoAcceptAlerts", true);

        return new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), dc);}
}
