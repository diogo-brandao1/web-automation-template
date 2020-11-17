package Actions;

import Steps.SharedDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

public class LanguageSwitcher {
    private static SharedDriver sharedDriver;

    public LanguageSwitcher(SharedDriver sharedDriver) {
        this.sharedDriver = sharedDriver;
        PageFactory.initElements(sharedDriver.getDriver(), this);
    }

    @FindBy(how = How.ID, using = "dropdownMenuButton")
    WebElement langSwitcher;

    @FindBy(how = How.LINK_TEXT, using = "English (UK)")
    WebElement english;

    @FindBy(how = How.ID, using = "dropdownManual")
    WebElement langSwitcherDashboard;

    @FindBy(how = How.CLASS_NAME, using = "pt-AO")
    WebElement langSwitcherDashboardPT;

    public void ChangeLang() {
        sharedDriver.getWait().until(ExpectedConditions.visibilityOf(langSwitcher)).click();
        sharedDriver.getWait().until(ExpectedConditions.visibilityOf(english)).click();
    }

    public boolean isEN() {
        if (sharedDriver.getDriver().findElement((By) langSwitcher).getText().equalsIgnoreCase("English (UK)")) {
            return true;
        } else {
            return false;
        }
    }

    public void changeLanguageDashboard() {
        sharedDriver.getWait().until(ExpectedConditions.visibilityOf(langSwitcherDashboard)).click();
        langSwitcherDashboardPT.click();
    }

}
