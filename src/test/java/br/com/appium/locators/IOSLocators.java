package br.com.appium.locators;

public class IOSLocators {

    public static final String ONBOARDING_START_BUTTON = "**/XCUIElementTypeButton[`label == \"Quero ser Cooperado\"`]";

    public static final String CPF_FIELD = "**/XCUIElementTypeTextField[`value == \"000.000.000-00\"`]";

    public static final String FULL_NAME_FIELD = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther" +
            "/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScroll" +
            "View/XCUIElementTypeOther[2]/XCUIElementTypeTextField";

    public static final String STATE_FIELD = "**/XCUIElementTypeStaticText[`label == \"Selecione\"`][1]";

    public static final String STATE = "AC - Acre";

    public static final String CITY_FIELD = "Selecione";

    public static final String CITY = "Acrelândia";

    public static final String TERMS = "**/XCUIElementTypeSwitch[`value == \"0\"`][2]";

    public static final String CONTINUE_BUTTON = "**/XCUIElementTypeButton[`label == \"Continuar\"`]";

    public static final String NEXT_SCREEN = "**/XCUIElementTypeStaticText[`label == \"Contatos\"`]";

}
