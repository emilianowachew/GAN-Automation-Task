package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.Config;

import java.util.HashMap;
import java.util.Map;

public final class DriverFactory {

    private DriverFactory() {
    }

    public static WebDriver createDriver() {
        String browser = Config.browser();

        if (!"chrome".equals(browser)) {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

        if (Config.headless()) {
            options.addArguments("--headless=new");
        }

        options.addArguments("--window-size=1400,900");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-features=PasswordLeakDetection,AutofillServerCommunication,AutofillEnableAccountWalletStorage");
        options.addArguments("--incognito");

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.default_content_setting_values.notifications", 2);
        prefs.put("autofill.profile_enabled", false);
        prefs.put("autofill.credit_card_enabled", false);

        options.setExperimentalOption("prefs", prefs);

        return new ChromeDriver(options);
    }
}
