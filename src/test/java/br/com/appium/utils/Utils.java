package br.com.appium.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import java.time.Duration;

public class Utils {

    private final FluentWait wait;
    private static AppiumDriver driver;

    public Utils(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class, StaleElementReferenceException.class)
                .ignoring(TimeoutException.class);
    }

    public void waitForElement(MobileElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void click(MobileElement element) {
        waitForElement(element);
        element.click();
    }

    public void write(MobileElement element, String value) {
        waitForElement(element);
        element.sendKeys(value);
    }

    public static boolean isAndroid() {
        return (driver instanceof AndroidDriver);
    }

    public static void hideKeyboard() {
        driver.hideKeyboard();
    }

    public static void verticalSwipe(int amount) {
        TouchAction touchAction = new TouchAction(driver);
        for(int i = 0; i <= amount; i++) {
            int centerY = (driver.manage().window().getSize().height)/2;
            int centerX = (driver.manage().window().getSize().width)/2;
            touchAction.longPress(PointOption.point(centerX, centerY))
                    .moveTo(PointOption.point(0, centerY/2))
                    .release()
                    .perform();
        }
    }
}
