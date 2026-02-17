package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class AccountHistoryPage extends BasePage {

    private final By bonusTab = By.cssSelector("span[data-qa='bonus']");
    private final By winningsCells = By.cssSelector("td.winnnings[data-qa='winnnings']");
    private final By descriptionCells = By.cssSelector("td.description[data-qa='description']");

    public AccountHistoryPage(WebDriver driver) {
        super(driver);
    }

    public void openBonusTab() {
        click(bonusTab);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(winningsCells));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(descriptionCells));
    }

    public boolean hasWinnings5000() {
        List<WebElement> cells = driver.findElements(winningsCells);
        for (WebElement cell : cells) {
            String t = normalize(cell.getText());
            if (t.contains("5,000")) {
                return true;
            }
        }
        return false;
    }

    public boolean hasRegistrationEndless() {
        List<WebElement> cells = driver.findElements(descriptionCells);
        for (WebElement cell : cells) {
            String t = normalize(cell.getText());
            if (t.contains("registration") && t.contains("endless")) {
                return true;
            }
        }
        return false;
    }

    private String normalize(String s) {
        if (s == null) {
            return "";
        }
        return s.replace("\u00A0", " ")
                .replace("\t", " ")
                .replace("\n", " ")
                .trim()
                .toLowerCase();
    }
}
