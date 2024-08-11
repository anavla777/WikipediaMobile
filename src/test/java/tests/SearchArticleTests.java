package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.FirstPage;
import pages.MainPage;

@Tag("mobile")
@Owner("Vladislav Ananenkov")
@Feature("Mobile: Search")
@DisplayName("Mobile: Search test suite")
public class SearchArticleTests extends TestBaseMobile {
    private static final String query = "Selenium";

    @DisplayName("Wikipedia app - Find article by search query")
    @Test
    void searchArticleTest() {
        firstPage.skipOnboarding();
        mainPage.enterSearchQuery(query)
                .verifyArticleName(query);
    }
}
