package tests;

import core.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CookieBanner;
import pages.HomePage;
import pages.RegisterPopUp;
import utils.TestData;

public class RegistrationTest extends BaseTest {

    @Test
    public void registerUserAndVerifySuccess() throws InterruptedException {

        HomePage home = new HomePage(driver);
        RegisterPopUp register = home.openRegister();

        new CookieBanner(driver).acceptAllIfPresent();

        String username = "emi" + System.currentTimeMillis();
        if (username.length() > 16) {
            username = username.substring(0, 16);
        }

        String email = TestData.uniqueEmail();
        String password = "emilian123";

        register.fillRegistration(username, email, password);
        register.submitRegistration();
        register.acceptTermsAndContinue();

        Assert.assertTrue(register.isRegistrationSuccessUrl(), "Did not reach registration success URL.");
        Assert.assertTrue(register.isLetsStartVisible(), "'Let's start' button not visible after registration.");

        register.closeGiftModalIfPresent();

        System.out.println("REGISTRATION TEST PASSED: registrationSuccess=true and 'Let's start' button visible.");
    }
}
