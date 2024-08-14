package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("mobile")
@Owner("Vladislav Ananenkov")
@Feature("Mobile: Search")
@DisplayName("Mobile: Search test suite")
public class SearchArticleTests extends TestBaseMobile {
    private static final String query = "Selenium";

    @DisplayName("Mobile: Wikipedia app - Find article by search query")
    @Test
    void searchArticleTest() {
        firstOnboardingPage.skipOnboarding();
        mainPage.enterSearchQuery(query)
                .verifyArticleName(query);
    }
}
