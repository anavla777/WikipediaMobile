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
        firstPage.checkTextOnAddLanguageButton()
                .checkSkipButtonOnFirstPage()
                .clickContinueButtonOnFirstPage();

        secondPage.checkPrimaryTextonSecondPage()
                .checkSkipButtonOnSecondPage()
                .clickOnContinueButtonOnSecondPage();

        thirdPage.checkPrimaryTextonThirdPage()
                .clickOnContinueButtonOnThirdPage();

        lastPage.checkPrimaryTextOnLastPage()
                .checkAccessibilityOfDoneButtonOnLastPage()
                .navigateToMainPage();

        mainPage.checkAccessibilityOfSearchBar()
                .checkVisibilityOfNewsFeed();
    }
}
