package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TermsPage extends BasePage {

    private final By title = By.xpath("//*[self::h1 or self::h2][contains(.,'Terms') or contains(.,'Conditions')]");
    private final By content = By.xpath("//*[contains(@class,'terms') or contains(@class,'content') or self::main]");

    public TermsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoaded() {
        return isVisible(title) || isVisible(content);
    }
}
