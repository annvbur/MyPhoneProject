package screen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Home extends BaseScreen{
    @AndroidFindBy(id = "com.google.android.apps.books:id/bottom_read_now")
    MobileElement homeBtn;
    @AndroidFindBy(xpath = "//android.widget.LinearLayout/android.widget.TextView[@text='Explore Play Books']")
    MobileElement exploreBooks;
    @AndroidFindBy(accessibility = "Recommended for You")
    MobileElement recommendedBooks;
    @AndroidFindBy(id = "com.google.android.apps.books:id/li_thumbnail")
    MobileElement bookshop;

    public Home(AppiumDriver driver) {super(driver);}

    public void tapHomeBtn(){homeBtn.click();}

    public boolean isHomeBtnDisplayed(){return isElementDisplayed(homeBtn);}

    public boolean isExploreBooksDisplayed(){return isElementDisplayed(exploreBooks);}

    public boolean isRecommendedBooksDisplayed(){return isElementDisplayed(recommendedBooks);}

    public void tapBookshop(){bookshop.click();}

}
