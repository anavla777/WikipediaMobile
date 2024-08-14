package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("mobile")
@Owner("Vladislav Ananenkov")
@Feature("Mobile: Onboarding")
@DisplayName("Mobile: Onboarding test suite")
public class OnboardingTests extends TestBaseMobile {
    @DisplayName("Mobile: Wikipedia app - Successful onboarding completion")
    @Test
    void onboardingTest() {
        firstOnboardingScreen.checkTextOnAddLanguageButton()
                .checkSkipButtonOnFirstPage()
                .clickContinueButtonOnFirstPage();

        secondOnboardingScreen.checkPrimaryTextonSecondPage()
                .checkSkipButtonOnSecondPage()
                .clickOnContinueButtonOnSecondPage();

        thirdOnboardingScreen.checkPrimaryTextonThirdPage()
                .clickOnContinueButtonOnThirdPage();

        lastOnboardingScreen.checkPrimaryTextOnLastPage()
                .checkAccessibilityOfDoneButtonOnLastPage()
                .navigateToMainPage();

        mainScreen.checkAccessibilityOfSearchBar()
                .checkVisibilityOfNewsFeed();
    }
}
