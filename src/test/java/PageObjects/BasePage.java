package PageObjects;

import Steps.DriverConfigs;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Properties;

public class BasePage {

    private DriverConfigs driverConfigs = new DriverConfigs();
    public WebDriverWait wait = driverConfigs.getWait();
    private Properties configProperties = driverConfigs.getConfigProperties();

    public WebDriver driver;
    public String mainPortalUrl;
    public String employeePortalUrl;
    public String identityDomainUrl;
    public String businessPortalUrl;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openMainPortal() {
        this.mainPortalUrl = configProperties.getProperty("url.mainPortal");
        this.driver.get(this.mainPortalUrl);
    }
    public void openEmployeePortal() {
        this.employeePortalUrl = configProperties.getProperty("url.employeePortal");
        this.driver.get(this.employeePortalUrl);
    }
    public void openIdentityDomain() {
        this.identityDomainUrl = configProperties.getProperty("url.identityDomain");
        this.driver.get(this.identityDomainUrl);
    }
    public void openBusinessPortal() {
        this.businessPortalUrl = configProperties.getProperty("url.businessPortal");
        this.driver.get(this.businessPortalUrl);
    }

    public boolean waitDocumentReadyComplete(){
        return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
    }

    public String getElementText(By by){
        return driver.findElement(by).getText();
    }

    private void isVisible(WebElement elem){
        this.wait.until(ExpectedConditions.visibilityOf(elem));
    }
    private void isNotVisible(WebElement elem){
        this.wait.until(ExpectedConditions.invisibilityOf(elem));
    }
    private void isClickable(WebElement elem){ this.wait.until(ExpectedConditions.elementToBeClickable(elem)); }
    private void validateCurrentUrl(String pageUrl) { this.wait.until(ExpectedConditions.urlContains(pageUrl)); }

}
