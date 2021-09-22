package Steps;

import PageObjects.BasePage;
import PageObjects.BingPage;
import PageObjects.BringPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class webExampleDefs {

    private DriverConfigs driverConfigs = new DriverConfigs();
    public WebDriver driver = driverConfigs.getDriver();

    //pages
    private BasePage basePage = new BasePage(driver);
    private BingPage bingPage = new BingPage(this.driver);
    private BringPage bringPage = new BringPage(this.driver);

    @Given("^the user is on the bing page$")
    public void user_on_bing_page() throws Exception {
        System.out.println("Step 1: the user is on the bing page");
        this.bingPage = new BingPage(this.driver);
        this.bingPage.openBusinessPortal();
        this.bingPage.waitDocumentReadyComplete();
    }

    @Then("^the user search for \"([^\"]*)\" page$")
    public void user_search_bring_page(String text){
        System.out.println("Step 2: the user search for {string} page || text=" + text);
        this.bingPage.fillSearchAndPressEnter(text);
    }

    @And("^click in \"([^\"]*)\" searched item$")
    public void user_click_bring_searched_item(String text){
        System.out.println("Step 3: click in {string} searched item || text=" + text);
        this.bingPage.waitAndClickInText(text);
    }

    @Then("^the user should be able to check if the text \"([^\"]*)\" is present$")
    public void user_should_see_title(String text){
        System.out.println("Step 4: the user should be able to check if the text {string} is present || text=" + text);
        this.bringPage.waitDocumentReadyComplete();
        String bodyText = this.bringPage.getElementText(By.xpath("html/body"));
        String message = text;
        Assert.assertTrue(bodyText.contains(message));
    }

    @And("^check if page URL is correct$")
    public void check_if_url_is_correct(){
        System.out.println("Step 5: check if page URL is correct");
        String currentURL = this.driver.getCurrentUrl();
        Assert.assertEquals(currentURL, this.bringPage.url);
    }





}
