package br.com.appium.tests;

import br.com.appium.screens.PersonalDataScreen;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PersonalDataTest extends BaseTest {

    @Test
    public void personalDataTest() {
        PersonalDataScreen personalDataScreen = new PersonalDataScreen(driver);

        personalDataScreen.clickOnboardingStartButton();
        personalDataScreen.fillCpfField("443.388.000-03");
        personalDataScreen.fillFullNameField("Levy Cunha");
        personalDataScreen.selectState();
        personalDataScreen.selectCity();
        personalDataScreen.clickTerms();
        personalDataScreen.clickContinueButton();
        assertThat(personalDataScreen.validationNextScreen(), is("Contatos"));
    }
}
