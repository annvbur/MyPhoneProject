package screen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import screen.Search;

public class Library extends BaseScreen{
    @AndroidFindBy(id = "com.google.android.apps.books:id/bottom_my_library")
    MobileElement libraryBtn;
    @AndroidFindBy(xpath = "//android.widget.HorizontalScrollView/android.widget.LinearLayout/android.widget.TextView[@text='SHELVES']")
    MobileElement shelves;
    @AndroidFindBy(xpath = "//android.widget.HorizontalScrollView/android.widget.LinearLayout/android.widget.TextView[@text='EBOOKS']")
    MobileElement ebooks;
    @AndroidFindBy(id = "com.google.android.apps.books:id/empty_home_view_link")
    MobileElement shopBtn;


    public Library(AppiumDriver driver) {super(driver);}

    public void tapLibraryBtn(){libraryBtn.click();}

    public boolean isLibraryBtnDisplayed(){return isElementDisplayed(libraryBtn);}

    public void tapShelvesTab(){shelves.click();}

    public void tapEbookTab(){ebooks.click();}

    public void tapShopBtn(){shopBtn.click();}

    public boolean isShelvesClickable(){return (shelves).isSelected();}//isEnabled

    public boolean isEbookClickable(){return (ebooks).isSelected();}

}