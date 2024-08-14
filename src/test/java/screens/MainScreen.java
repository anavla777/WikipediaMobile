package screens;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.id;

public class MainScreen {
    private final SelenideElement
            searchContainer = $(id("org.wikipedia.alpha:id/search_container")),
            searchBar = $(id("org.wikipedia.alpha:id/search_src_text")),
            wikiFeed = $(id("org.wikipedia.alpha:id/feed_view")),
            menu = $(id("org.wikipedia.alpha:id/nav_tab_more")),
            loginFormLink = $(id("org.wikipedia.alpha:id/main_drawer_login_button")),
            loginButton = $(id("org.wikipedia.alpha:id/create_account_login_button")),
            usernameField = $(id("org.wikipedia.alpha:id/login_username_text")),
            passwordField = $(id("org.wikipedia.alpha:id/login_password_input")),
            submitLoginButton = $(id("org.wikipedia.alpha:id/login_button")),
            accountLabel = $(id("org.wikipedia.alpha:id/main_drawer_account_name")),
            disablePush = $(id("com.android.permissioncontroller:id/permission_deny_button"));
    private final ElementsCollection
            searchResults = $$(id("org.wikipedia.alpha:id/page_list_item_title"));

    @Step("Check that search bar is visible")
    public MainScreen checkAccessibilityOfSearchBar() {
        searchContainer.shouldBe(visible);
        return this;
    }

    @Step("Check that news feed is visible")
    public void checkVisibilityOfNewsFeed() {
        wikiFeed.shouldBe(visible);

    }

    @Step("Enter search query")
    public MainScreen enterSearchQuery(String query) {
        searchContainer.click();
        searchBar.setValue(query);
        return this;
    }

    @Step("Check that first article contains " + "'" + "{0}" + "'")
    public void verifyArticleName(String query) {
        searchResults.shouldHave(sizeGreaterThan(0));
        searchResults.get(0).shouldHave(text(query));
    }

    @Step("Open menu")
    public MainScreen openMenu() {
        menu.click();
        return this;
    }

    @Step("Open login form")
    public MainScreen openLoginForm() {
        loginFormLink.click();
        return this;
    }

    @Step("Login with existing account")
    public MainScreen login(String username, String password) {
        loginButton.click();
        usernameField.type(username);
        passwordField.type(password);
        submitLoginButton.click();
        return this;
    }

    @Step("Check that user is logged in")
    public void verifyLogin(String username) {
        menu.click();
        accountLabel.shouldHave(text(username));
    }

    public MainScreen disablePushes() {
        disablePush.click();
        return this;
    }

}
