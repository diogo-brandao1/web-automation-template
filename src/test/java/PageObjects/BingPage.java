package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BingPage extends BasePage{

    @FindBy(how = How.NAME, using = "q") WebElement searchInput;

    public BingPage(WebDriver driver){
        super(driver);
    }

    public void fillSearchAndPressEnter(String text){
        this.wait.until(ExpectedConditions.visibilityOf(searchInput)).sendKeys(text, Keys.ENTER);
        //this.driver.findElement(searchInput).sendKeys(text, Keys.ENTER);
    }

    public void waitAndClickInText(String text){
        this.wait.until(ExpectedConditions.elementToBeClickable(By.linkText(text)));
        this.driver.findElement(By.linkText(text)).click();
    }

}
