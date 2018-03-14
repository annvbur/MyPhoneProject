import app.PlayStore;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import driver.DesiredCapab;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.GetScreenshot;
//import driver.AppiumDriverBuilder;
//import rest.PlayerAPICall;
//import utils.GetScreenshot;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestBase {

    public PlayStore playStore;
    public static ExtentReports extent;
    public static ExtentTest logger;
    public static ExtentHtmlReporter htmlReporter;

    @BeforeSuite
    public void initReport()
    {
        htmlReporter = new ExtentHtmlReporter("//Users//hburianova/Reports//FirstAutomatedTestReport_"
                + new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa").format(new Date()) + ".html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setDocumentTitle("First App Automated Tests Report");
        htmlReporter.config().setReportName("First Android: Automated Test Report");
    }

    @BeforeMethod
        public void setupDriver() throws MalformedURLException, IllegalAccessException {
        playStore = new PlayStore(DesiredCapab.setup());
    }

    @AfterMethod
    public void cleanup(ITestResult result) throws IOException, IllegalAccessException {
        if (result.getStatus() == ITestResult.FAILURE)
        {
            logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " Test case FAILED due to below issues:", ExtentColor.RED));
            logger.fail(result.getThrowable());
            logger.addScreenCaptureFromPath(GetScreenshot.capture(DesiredCapab.setup()));
        }
        else if (result.getStatus() == ITestResult.SUCCESS)
        {
            logger.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
            logger.addScreenCaptureFromPath(GetScreenshot.capture(DesiredCapab.setup()));
        }
        else if (result.getStatus() == ITestResult.SKIP)
        {
            logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " Test Case SKIPPED", ExtentColor.BLUE));
        }
        if (playStore != null)
            DesiredCapab.setup().quit();
    }

    @AfterSuite
    public void saveReport() throws Exception
    {
        extent.flush();
    }

}
