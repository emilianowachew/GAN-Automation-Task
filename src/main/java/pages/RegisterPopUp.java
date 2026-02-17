package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class RegisterPopUp extends BasePage {

    private final By usernameInput = By.cssSelector("input[data-qa='signup_username']#username[name='username']");
    private final By emailInput = By.cssSelector("input[data-qa='signup_email']#email[name='email']");
    private final By passwordInput = By.cssSelector("input[data-qa='signup_password']#password[name='password']");
    private final By getFreeChipsButton = By.cssSelector("button[data-qa='signup_submit_btn']");

    private final By termsCheckboxLabel = By.cssSelector("label[data-qa='signup_checkbox'][for='terms']");
    private final By continueButton = By.cssSelector("button[type='submit'][data-qa='signup_submit_btn']");

    private final By letsStartButton = By.cssSelector("button[data-qa='gift-modal-close']");

    public RegisterPopUp(WebDriver driver) {
        super(driver);
    }

    public void fillRegistration(String username, String email, String password) {
        type(usernameInput, username);
        type(emailInput, email);
        type(passwordInput, password);
    }

    public void submitRegistration() {
        click(getFreeChipsButton);
    }

    public void acceptTermsAndContinue() throws InterruptedException {
        scrollToBottom();
        click(termsCheckboxLabel);
        click(continueButton);
        Thread.sleep(2000);
    }

    public boolean isRegistrationSuccessUrl() {
        return driver.getCurrentUrl().contains("registrationSuccess=true");
    }

    public boolean isLetsStartVisible() {
        return isVisible(letsStartButton);
    }

    public void closeGiftModalIfPresent() {
        if (isVisible(letsStartButton)) {
            click(letsStartButton);
        }
    }

    private void scrollToBottom() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }
}
