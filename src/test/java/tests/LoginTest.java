package tests;

import core.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CookieBanner;
import pages.HomePage;
import pages.LoginPopUp;

public class LoginTest extends BaseTest {

    @Test
    public void loginAndVerifyBySocialWheel() throws InterruptedException {

        HomePage home = new HomePage(driver);
        LoginPopUp login = home.openLogin();

        new CookieBanner(driver).acceptAllIfPresent();

        login.fillCredentials("emilian", "emilian123");
        login.submit();

        Thread.sleep(2000);

        Assert.assertTrue(login.isLoggedInBySocialWheel(), "Social XP wheel was not visible after login.");

        System.out.println("LOGIN TEST PASSED: Social XP wheel is visible (login confirmed).");
    }
}
