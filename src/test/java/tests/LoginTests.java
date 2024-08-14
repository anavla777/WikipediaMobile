package tests;

import config.AuthConfig;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("mobile")
@Owner("Vladislav Ananenkov")
@Feature("Mobile: Login")
@DisplayName("Mobile: Login test suite")
public class LoginTests extends TestBaseMobile {
    @DisplayName("Mobile: Wikipedia app - Login into App")
    @Test
    void successfulLoginTest() {
        final AuthConfig authConfig = ConfigFactory.create(AuthConfig.class, System.getProperties());

        firstOnboardingPage.skipOnboarding();
        mainPage.openMenu()
                .openLoginForm()
                .login(authConfig.username(), authConfig.password())
                .disablePushes()
                .verifyLogin(authConfig.username());
    }
}
