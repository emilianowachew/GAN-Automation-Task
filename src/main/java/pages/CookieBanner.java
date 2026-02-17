package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CookieBanner extends BasePage {

    private final By bannerRoot = By.id("onetrust-banner-sdk");
    private final By acceptAllCookies = By.id("onetrust-accept-btn-handler");

    public CookieBanner(WebDriver driver) {
        super(driver);
    }

    public void acceptAllIfPresent() {
        if (!driver.findElements(bannerRoot).isEmpty() && isVisible(acceptAllCookies)) {
            click(acceptAllCookies);
        }
    }
}
