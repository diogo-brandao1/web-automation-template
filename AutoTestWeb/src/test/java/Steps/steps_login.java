package Steps;

import Actions.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class steps_login {

    WebDriver driver;
    Login login;
    SharedDriver sharedDriver;

    public steps_login(SharedDriver sharedDriver) {
        this.sharedDriver = sharedDriver;
        driver = sharedDriver.getDriver();
        login = new Login(driver);
    }

    @Then("^i want to login with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void i_want_to_login_with_and(String user, String pass) {
        login.FillIn(user, pass);
    }

    @Given("^i am in login page$")
    public void i_am_in_login_page() throws Throwable {
        login.openBrowser();
    }

    @Given("^i am in the business login page$")
    public void i_am_in_business_login_page() throws Throwable {
        login.openBrowser_business();
    }

    @And("^i logged in successfully$")
    public void iLoggedInSuccessfully() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.id("banner-url"));
    }


    @And("^my login failed$")
    public void myLoginFailed() {
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"error-container\"]/span[2]"));
    }

    @And("^i change the language to english$")
    public void iChangeTheLanguageToEnglish() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"dropdownMenuButton\"]")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[4]/div/div/a")).click();
        Thread.sleep(3000);
    }
}