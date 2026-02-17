package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPopUp extends BasePage {

    private final By emailInput = By.cssSelector("input[data-qa='email']");
    private final By passwordInput = By.cssSelector("input[data-qa='login_password']");
    private final By submitLogin = By.cssSelector("button[data-qa='login_submit_btn']");

    private final By socialXpWheel = By.cssSelector("div.SocialXpWheel_socialXpWheel__251N9");

    private final By expandAccountMenu = By.cssSelector("span[data-qa='expand_account_menu']");
    private final By accountHistoryLink = By.cssSelector("a[data-qa='account_history']");

    public LoginPopUp(WebDriver driver) {
        super(driver);
    }

    public void fillCredentials(String email, String password) {
        type(emailInput, email);
        type(passwordInput, password);
    }

    public void submit() {
        click(submitLogin);
    }

    public boolean isLoggedInBySocialWheel() {
        return isVisible(socialXpWheel);
    }

    public void openAccountMenu() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(socialXpWheel));
        clickMenuWithRetry();
        wait.until(ExpectedConditions.visibilityOfElementLocated(accountHistoryLink));
    }

    public void openAccountHistory() {
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(accountHistoryLink));
        try {
            link.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", link);
        }
    }

    private void clickMenuWithRetry() {
        try {
            clickMenuOnce();
        } catch (Exception first) {
            clickMenuOnce();
        }
    }

    private void clickMenuOnce() {
        WebElement menuIcon = wait.until(ExpectedConditions.presenceOfElementLocated(expandAccountMenu));

        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", menuIcon);
        } catch (Exception ignored) {
        }

        try {
            new Actions(driver).moveToElement(menuIcon).pause(java.time.Duration.ofMillis(200)).perform();
        } catch (Exception ignored) {
        }

        try {
            wait.until(ExpectedConditions.elementToBeClickable(menuIcon)).click();
        } catch (StaleElementReferenceException e) {
            WebElement fresh = wait.until(ExpectedConditions.presenceOfElementLocated(expandAccountMenu));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", fresh);
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", menuIcon);
        }
    }
}
