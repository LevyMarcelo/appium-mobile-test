package br.com.appium.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    protected AppiumDriver driver;
    private final DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

    @BeforeTest(alwaysRun = true)
    @Parameters({"platform", "bundleId", "device", "udid", "app", "url"})
    public void beforeClass(String platform,
                            @Optional("bundleId") String bundleId,
                            @Optional("device") String device,
                            @Optional("udid") String udid,
                            @Optional("app") String app,
                            @Optional("url") String url) {

        if(platform.equalsIgnoreCase("iOS")) {
            desiredCapabilitiesiOS(bundleId, device, url);
        } else {
            desiredCapabilitiesAndroid(udid, app, url);
        }
    }

    @AfterTest(alwaysRun = true)
    public void afterClass() {
        driver.quit();
    }

    private void desiredCapabilitiesiOS(String bundleId, String device, String url) {
        this.desiredCapabilities.setCapability(IOSMobileCapabilityType.BUNDLE_ID, bundleId);
        this.desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device);
        this.desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);

        try {
            driver = new IOSDriver(new URL(url), desiredCapabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private void desiredCapabilitiesAndroid(String udid, String app, String url) {
        this.desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, udid);
        this.desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, app);
        this.desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);

        try {
            driver = new AndroidDriver(new URL(url), desiredCapabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
