package tests;

import core.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountHistoryPage;
import pages.CookieBanner;
import pages.HomePage;
import pages.LoginPopUp;

public class BonusHistoryTest extends BaseTest {

    @Test
    public void bonusHistoryShowsRegistrationBonus5000() throws InterruptedException {

        HomePage home = new HomePage(driver);
        LoginPopUp login = home.openLogin();

        new CookieBanner(driver).acceptAllIfPresent();

        login.fillCredentials("emilian", "emilian123");
        login.submit();

        Thread.sleep(3000);

        Assert.assertTrue(login.isLoggedInBySocialWheel(),
                "Login not confirmed (Social XP wheel missing).");

        login.openAccountMenu();
        login.openAccountHistory();

        Thread.sleep(2000);

        Assert.assertTrue(driver.getCurrentUrl().contains("/my-account/account-history"),
                "Account History page did not open.");

        AccountHistoryPage history = new AccountHistoryPage(driver);
        history.openBonusTab();

        Assert.assertTrue(history.hasWinnings5000(), "Winnings value '5,000' was not found under BONUS.");
        Assert.assertTrue(history.hasRegistrationEndless(), "Description 'Registration - Endless' was not found under BONUS.");

        System.out.println("BONUS HISTORY TEST PASSED: winnings '5,000' and description 'Registration - Endless' are present.");
    }
}
