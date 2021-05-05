package junitExample;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import pages.GoogleMainPage;

public class GoogleSearchTestJunit extends JUnit5Runner {

    @Story("Story 1")
    @Epic("Epic 1")
    @Feature("Feature 1")
    @Link("Link")
    @Issue("link on issue")
    @Description("Description")
    @Test
    public void navigateToMainPge() {
        GoogleMainPage googleMainPage = new GoogleMainPage();
        googleMainPage.searchFor("Апельсин");

        Assertions.assertTrue(false);
    }
}
