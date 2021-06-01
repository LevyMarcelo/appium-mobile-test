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

    @AndroidFindBy(xpath = AndroidLocators.CPF_FIELD)
    @iOSXCUITFindBy(iOSClassChain = IOSLocators.CPF_FIELD)
    protected MobileElement cpfField;

    @AndroidFindBy(xpath = AndroidLocators.FULL_NAME_FIELD)
    @iOSXCUITFindBy(iOSClassChain = IOSLocators.FULL_NAME_FIELD)
    protected MobileElement fullNameField;

    @AndroidFindBy(id = AndroidLocators.STATE_FIELD)
    @iOSXCUITFindBy(iOSClassChain = IOSLocators.STATE_FIELD)
    protected MobileElement stateField;

    @AndroidFindBy(xpath = AndroidLocators.STATE)
    @iOSXCUITFindBy(accessibility = IOSLocators.STATE)
    protected MobileElement state;

    @AndroidFindBy(id = AndroidLocators.CITY_FIELD)
    @iOSXCUITFindBy(accessibility = IOSLocators.CITY_FIELD)
    protected MobileElement cityField;

    @AndroidFindBy(xpath = AndroidLocators.CITY)
    @iOSXCUITFindBy(accessibility = IOSLocators.CITY)
    protected MobileElement city;

    @AndroidFindBy(id = AndroidLocators.TERMS)
    @iOSXCUITFindBy(iOSClassChain = IOSLocators.TERMS)
    protected MobileElement terms;

    @AndroidFindBy(id = AndroidLocators.CONTINUE_BUTTON)
    @iOSXCUITFindBy(iOSClassChain = IOSLocators.CONTINUE_BUTTON)
    protected MobileElement continueButton;

    @AndroidFindBy(id = AndroidLocators.NEXT_SCREEN)
    @iOSXCUITFindBy(iOSClassChain = IOSLocators.NEXT_SCREEN)
    protected MobileElement nextScreen;

    public void clickOnboardingStartButton() {
        if (isAndroid())
            click(onboardingStartButton);
    }

    public void fillCpfField(String cpf) {
        write(cpfField, cpf);
    }

    public void fillFullNameField(String fullName) {
        write(fullNameField, fullName);
    }

    public void selectState() {
        hideKeyboard();
        click(stateField);
        click(state);
    }

    public void selectCity() {
        hideKeyboard();
        click(cityField);
        click(city);
    }

    public void clickTerms() {
        if (isAndroid()) {
            verticalSwipe(0);
            click(terms);
        } else {
            click(terms);
        }
    }

    public void clickContinueButton() {
        click(continueButton);
    }

    public String validationNextScreen() {
        waitForElement(nextScreen);
        return nextScreen.getText();
    }
}
