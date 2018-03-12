package screen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Shop extends BaseScreen{
    @AndroidFindBy(id = "com.google.android.apps.books:id/bottom_shop")
    MobileElement shopBtn;
    @AndroidFindBy(xpath = "//android.widget.LinearLayout/android.widget.TextView[@text='Popular Books']")
    MobileElement popularBooks;

    public Shop(AppiumDriver driver) {super(driver);}

    public void tapShopBtn(){shopBtn.click();}

    public boolean isShopBtnDisplayed(){return isElementDisplayed(shopBtn);}

    public boolean isPopularBooksDisplayed(){return isElementDisplayed(popularBooks);}
}
