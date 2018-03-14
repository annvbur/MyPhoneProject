package screen;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.Keys;

public class Search extends BaseScreen{
    @AndroidFindBy(accessibility = "Search")
    MobileElement searchBtn;
    @AndroidFindBy(id = "com.android.vending:id/search_results_list")
    MobileElement searchResultList;
    @AndroidFindBy(id = "com.google.android.apps.books:id/search_box_text_input")
    MobileElement inputField;


    public Search(AppiumDriver driver) {super(driver);}

    public void tapSearchBtn(){searchBtn.click();}

    public void inputSearchWord(){inputField.sendKeys("book");}

    public void tapEnter(){inputField.sendKeys(Keys.RETURN);}

    public void tapReturn(){driver.getKeyboard().sendKeys(Keys.RETURN);}

    public void searchNothing(){inputField.sendKeys("");}

    public boolean isSearchBtnClickable(){return isElementDisplayed(searchBtn);}

    public boolean isSearchResultDisplayed(){return isElementDisplayed(searchResultList);}
}
