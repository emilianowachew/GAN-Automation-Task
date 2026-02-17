package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private final By loginButton = By.cssSelector("div[data-qa='login_btn'][title='Login']");
    private final By signUpButton = By.cssSelector("a[data-qa='signup_btn'][title='Register']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public LoginPopUp openLogin() {
        click(loginButton);
        return new LoginPopUp(driver);
    }

    public RegisterPopUp openRegister() {
        click(signUpButton);
        return new RegisterPopUp(driver);
    }
}
