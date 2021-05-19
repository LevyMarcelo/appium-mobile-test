package br.com.appium.screens;

import br.com.appium.locators.AndroidLocators;
import br.com.appium.locators.IOSLocators;
import br.com.appium.utils.Utils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalDataScreen extends Utils {

    public PersonalDataScreen(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = AndroidLocators.ONBOARDING_START_BUTTON)
    @iOSXCUITFindBy(iOSClassChain = IOSLocators.ONBOARDING_START_BUTTON)
    protected MobileElement onboardingStartButton;

    @AndroidFindBy(xpath = AndroidLocators.FULL_NAME_FIELD)
    @iOSXCUITFindBy(iOSClassChain = IOSLocators.FULL_NAME_FIELD)
    protected MobileElement fullNameField;

    public void clickOnboardingStartButton() {
        click(onboardingStartButton);
    }

    public void fillFullNameField(String fullName) {
        write(fullNameField, fullName);
    }
}