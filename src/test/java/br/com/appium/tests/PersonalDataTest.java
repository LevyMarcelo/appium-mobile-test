package br.com.appium.tests;

import br.com.appium.screens.PersonalDataScreen;
import org.testng.annotations.Test;
import static br.com.appium.utils.Utils.isAndroid;

public class PersonalDataTest extends BaseTest {

    @Test
    public void personalDataTest() {
        PersonalDataScreen personalDataScreen = new PersonalDataScreen(driver);

        personalDataScreen.clickOnboardingStartButton();
        personalDataScreen.fillFullNameField("Levy Cunha");
    }
}
