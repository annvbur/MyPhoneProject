
import com.aventstack.extentreports.Status;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import screen.Home;
import utils.Swipe;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class FirstTest extends TestBase {

    @Test
    public void firstTest() {
        logger = extent.createTest("T1: User Sees Home Button");
        logger.assignCategory("Home");
        logger.assignAuthor("Hanna Burianova");
        assertTrue("Home button is NOT displayed", playStore.Home().isHomeBtnDisplayed());
        logger.log(Status.PASS, "Verify whether 'Home button is displayed");
    }

    @Test
    public void libraryPageIsClickable() {
        logger = extent.createTest("T2: User Sees Library Button");
        logger.assignCategory("Library");
        logger.assignAuthor("Hanna Burianova");
        playStore.Library().tapLibraryBtn();
        logger.log(Status.PASS, "Tap Library button");
        assertTrue("Library button is NOT clickable", playStore.Library().isLibraryBtnDisplayed());
        logger.log(Status.PASS, "Verify whether Library button is clickable");
    }

    @Test
    public void shopPageIsClickable() {
        logger = extent.createTest("T3: User Sees Shop Button");
        logger.assignCategory("Shop");
        logger.assignAuthor("Hanna Burianova");
        playStore.Shop().tapShopBtn();
        logger.log(Status.PASS, "Tap Shop button");
        assertTrue("Shop button is NOT clickable", playStore.Shop().isShopBtnDisplayed());
        logger.log(Status.PASS, "Verify whether Shop button is clickable");
    }

    @Test
    public void exploreIsExist() {
        logger = extent.createTest("T4: User Sees Explore book");
        logger.assignCategory("Home");
        logger.assignAuthor("Hanna Burianova");
        assertTrue("Explore books are NOT shown", playStore.Home().isExploreBooksDisplayed());
        logger.log(Status.PASS, "Verify whether Shop button is clickable");
    }

    @Test
    public void recommendedIsExist() {
        logger = extent.createTest("T5: User Sees Recommended books");
        logger.assignCategory("Home");
        logger.assignAuthor("Hanna Burianova");
        assertTrue("Recommended books are NOT shown", playStore.Home().isRecommendedBooksDisplayed());
        logger.log(Status.PASS, "Verify whether Recommended books are clickable");
    }

    @Test
    public void bookshopIsClickable() {
        logger = extent.createTest("T6: User leads to Shop if tap book");
        logger.assignCategory("Shop");
        logger.assignAuthor("Hanna Burianova");
        playStore.Home().tapBookshop();
        logger.log(Status.PASS, "Tap book");
        assertTrue("Tap book does NOT lead to Shop", playStore.Shop().isPopularBooksDisplayed());
        logger.log(Status.PASS, "Verify whether book is clickable and leads to Shop tab");
    }

    @Test
    public void shelverIsClickable() {
        logger = extent.createTest("T7: User can tap Shelves tab");
        logger.assignCategory("Library");
        logger.assignAuthor("Hanna Burianova");
        playStore.Library().tapLibraryBtn();
        logger.log(Status.PASS, "Tap Library tab");
        playStore.Library().tapShelvesTab();
        logger.log(Status.PASS, "Tap Shelves");
        assertTrue("Shelves tab is NOT clickable", playStore.Library().isShelvesClickable());
        logger.log(Status.PASS, "Verify whether Shelves tab is clickable");
    }

    @Test
    public void ebookIsClickable() {
        logger = extent.createTest("T8: User can tap Ebooks tab");
        logger.assignCategory("Library");
        logger.assignAuthor("Hanna Burianova");
        playStore.Library().tapLibraryBtn();
        logger.log(Status.PASS, "Tap Library tab");
        playStore.Library().tapEbookTab();
        logger.log(Status.PASS, "Tap Library tab");
        assertTrue("Ebooks tab is NOT clickable", playStore.Library().isEbookClickable());
        logger.log(Status.PASS, "Verify whether Ebooks tab is clickable");
    }

    @Test
    public void shopBtnLeadsToShop() {
        logger = extent.createTest("T9: User can select Shop tab");
        logger.assignCategory("Shop");
        logger.assignAuthor("Hanna Burianova");
        playStore.Shop().tapShopBtn();
        logger.log(Status.PASS, "Tap Shop tab");
        assertTrue("Shop button does NOT lead to shop", playStore.Shop().isPopularBooksDisplayed());
        logger.log(Status.PASS, "Verify whether Shop button opens Shop tab");
    }

    @Test
    public void popularBooksAreShown() {
        logger = extent.createTest("T10: User Sees Popular books");
        logger.assignCategory("Shop");
        logger.assignAuthor("Hanna Burianova");
        playStore.Shop().tapShopBtn();
        logger.log(Status.PASS, "Tap Shop button");
        assertTrue("Popular books are NOT shown", playStore.Shop().isPopularBooksDisplayed());
        logger.log(Status.PASS, "Verify whether popular books are shown on Shop tab");
    }

    @Test
    public void searchWorksProperlyIfSearchNothing() {
        logger = extent.createTest("T11: User tap Search button");
        logger.assignCategory("Library");
        logger.assignAuthor("Hanna Burianova");
        playStore.Library().tapLibraryBtn();
        playStore.Search().tapSearchBtn();
        playStore.Search().searchNothing();
        logger.log(Status.PASS, "User fill in nothing to Search");
        assertFalse("Results are shown without search key word", playStore.Search().isSearchResultDisplayed());


//        how to use softAssert in this case?
    }

    @Test
    public void searchWorksProperlyIfSearchSomething() {
        logger = extent.createTest("T12: User tap Search button");
        logger.assignCategory("Library");
        logger.assignAuthor("Hanna Burianova");
        playStore.Library().tapLibraryBtn();
        playStore.Search().tapSearchBtn();
        playStore.Search().inputSearchWord();
        playStore.Search().tapReturn();// Enter doesn't work//первый элемент из списка
        logger.log(Status.PASS, "User fill in key word to Search");
        assertTrue("Results are not shown if search using key word", playStore.Search().isSearchResultDisplayed());
    }

    @Test
    public void testWithSwipe() {
        logger = extent.createTest("T13: User swipe to tap button");
        logger.assignCategory("Home");
        logger.assignAuthor("Hanna Burianova");
        playStore.Home().tapHomeBtn();

//        do {
//            new Swipe().down(driver);
//        }
//        while(!playStore.Home().isWhatYouLikeDisplayed());
        playStore.Home().tapWhatYouLikeBtn();
        logger.log(Status.PASS, "User fill in key word to Search");
        assertTrue("Results are not shown if search using key word", playStore.Home().isNewPageIsDisplayed());
    }


//    isFoundElement = driver.findElements(myElement).size() > 0;
//while (!isFoundElement) {
//        // do something
//    }

    //
//        do {
//            new Swipe().down(driver);
//        }
//        while(activities.isDisplayed() == false);
}
