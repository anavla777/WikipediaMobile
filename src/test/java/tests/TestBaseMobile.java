package tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.LocalMobileDriverReader;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import screens.*;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class TestBaseMobile {

    public final FirstOnboardingScreen firstOnboardingScreen;
    public final SecondOnboardingScreen secondOnboardingScreen;
    public final ThirdOnboardingScreen thirdOnboardingScreen;
    public final LastOnboardingScreen lastOnboardingScreen;
    public final MainScreen mainScreen;

    public TestBaseMobile() {
        firstOnboardingScreen = new FirstOnboardingScreen();
        secondOnboardingScreen = new SecondOnboardingScreen();
        thirdOnboardingScreen = new ThirdOnboardingScreen();
        lastOnboardingScreen = new LastOnboardingScreen();
        mainScreen = new MainScreen();
    }

    @BeforeAll
    static void beforeAll() {
        LocalMobileDriverReader localMobileDriverReader = new LocalMobileDriverReader();
        localMobileDriverReader.setLocalMobileDriverConfig();
    }

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    void addAttachments() {
        Attach.pageSource();
        String deviceHost = System.getProperty("deviceHost");
        if ((deviceHost == null) || deviceHost.equals("browserstack")) {
            String sessionId = Selenide.sessionId().toString();
            Attach.addVideo(sessionId);
        }
        closeWebDriver();
    }
}
