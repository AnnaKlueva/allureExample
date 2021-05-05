package testNgExample;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GoogleMainPage;

public class GoogleSearchTestNgExample extends TestNgRunner {

    @Test
    public void navigateToMainPge() throws InterruptedException {
        GoogleMainPage googleMainPage = new GoogleMainPage();
        googleMainPage.searchFor("Апельсин");
        Assert.assertTrue(false);
    }
}
