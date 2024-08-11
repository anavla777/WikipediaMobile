package tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.LocalMobileDriverReader;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.*;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class TestBaseMobile {

    public final FirstPage firstPage;
    public final SecondPage secondPage;
    public final ThirdPage thirdPage;
    public final LastPage lastPage;
    public final MainPage mainPage;

    public TestBaseMobile() {
        firstPage = new FirstPage();
        secondPage = new SecondPage();
        thirdPage = new ThirdPage();
        lastPage = new LastPage();
        mainPage = new MainPage();
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
