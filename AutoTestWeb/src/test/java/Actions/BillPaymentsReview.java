package Actions;


import Steps.SharedDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BillPaymentsReview {

    SharedDriver sharedDriver;

    public BillPaymentsReview(SharedDriver sharedDriver) {
        this.sharedDriver = sharedDriver;
        PageFactory.initElements(sharedDriver.getDriver(), this);
    }

    @FindBy(xpath = "/html/body/div/div/div/div/div/div/div/sba-sba-retail-app/bb-root/bb-area/bb-chrome/bb-layout-container/bb-layout-rendering-container-ui/bb-page-layout-theme1-ui/div/div[2]/div/bb-chrome/bb-panel-container/bb-area/bb-chrome/bb-navigation-link-widget-ang/nav/ul/li[1]/nav/ul/li[2]/a/span")
    WebElement billPaymentsMenu;

    @FindBy(id = "bb_input_0")
    WebElement searchBar;

    @FindBy(xpath = "//*[@id=\"bb-main-content\"]/bb-panel-container/bb-area/bb-chrome/bb-deck-container/bb-route/bb-chrome/bb-panel-container/bb-area/bb-chrome/bb-deck-container/bb-route/bb-chrome/bb-panel-container/bb-area/bb-chrome[2]/bb-column-container/div/bb-column[1]/bb-chrome/bb-panel-container/bb-area/bb-chrome/bb-panel-container/bb-area/bb-chrome/bb-tab-container/div[2]/bb-route/bb-chrome/bb-panel-container/bb-area/bb-chrome/bb-panel-container/bb-area/bb-chrome/sba-bill-payments-widget/sba-sba-bill-payments-home/div/div/div[2]/div/div/button")
    WebElement firstEntity;

    @FindBy(id = "reference")
    WebElement reference;

    @FindBy(xpath = "//*[@id=\"bb-main-content\"]/bb-panel-container/bb-area/bb-chrome/bb-deck-container/bb-route/bb-chrome/bb-panel-container/bb-area/bb-chrome/bb-deck-container/bb-route/bb-chrome/bb-panel-container/bb-area/bb-chrome[2]/bb-column-container/div/bb-column[1]/bb-chrome/bb-panel-container/bb-area/bb-chrome/bb-panel-container/bb-area/bb-chrome/bb-tab-container/div[2]/bb-route/bb-chrome/bb-panel-container/bb-area/bb-chrome/bb-panel-container/bb-area/bb-chrome/sba-bill-payments-widget/sba-sba-bill-payments-recharge/form/div[2]/bb-fieldset-ui/fieldset/div/div[3]/div/sba-dropdown-ui/div/div")
    WebElement amountDropdownRechargeable;

    @FindBy(xpath = "//*[@id=\"bb-main-content\"]/bb-panel-container/bb-area/bb-chrome/bb-deck-container/bb-route/bb-chrome/bb-panel-container/bb-area/bb-chrome/bb-deck-container/bb-route/bb-chrome/bb-panel-container/bb-area/bb-chrome[2]/bb-column-container/div/bb-column[1]/bb-chrome/bb-panel-container/bb-area/bb-chrome/bb-panel-container/bb-area/bb-chrome/bb-tab-container/div[2]/bb-route/bb-chrome/bb-panel-container/bb-area/bb-chrome/bb-panel-container/bb-area/bb-chrome/sba-bill-payments-widget/sba-sba-bill-payments-state-payment/form/div[2]/bb-fieldset-ui/fieldset/div/div[4]/div/sba-dropdown-ui/div/div")
    WebElement getAmountDropdownStateConfig;

    @FindBy(id = "bb_element_8")
    WebElement amountInputReference;

    @FindBy(id = "bb_element_9")
    WebElement amountInputStateStandard;

    @FindBy(xpath = "//*[@id=\"bb-main-content\"]/bb-panel-container/bb-area/bb-chrome/bb-deck-container/bb-route/bb-chrome/bb-panel-container/bb-area/bb-chrome/bb-deck-container/bb-route/bb-chrome/bb-panel-container/bb-area/bb-chrome[2]/bb-column-container/div/bb-column[1]/bb-chrome/bb-panel-container/bb-area/bb-chrome/bb-panel-container/bb-area/bb-chrome/bb-tab-container/div[2]/bb-route/bb-chrome/bb-panel-container/bb-area/bb-chrome/bb-panel-container/bb-area/bb-chrome/sba-bill-payments-widget/sba-sba-bill-payments-recharge/form/div[2]/bb-fieldset-ui/fieldset/div/div[3]/div/sba-dropdown-ui/div/div[2]/button[1]")
    WebElement firstAmountRechargeable;

    @FindBy(xpath = "//*[@id=\"bb-main-content\"]/bb-panel-container/bb-area/bb-chrome/bb-deck-container/bb-route/bb-chrome/bb-panel-container/bb-area/bb-chrome/bb-deck-container/bb-route/bb-chrome/bb-panel-container/bb-area/bb-chrome[2]/bb-column-container/div/bb-column[1]/bb-chrome/bb-panel-container/bb-area/bb-chrome/bb-panel-container/bb-area/bb-chrome/bb-tab-container/div[2]/bb-route/bb-chrome/bb-panel-container/bb-area/bb-chrome/bb-panel-container/bb-area/bb-chrome/sba-bill-payments-widget/sba-sba-bill-payments-state-payment/form/div[2]/bb-fieldset-ui/fieldset/div/div[4]/div/sba-dropdown-ui/div/div[2]/button[1]")
    WebElement firstAmountStateConfig;

    @FindBy(xpath = "//*[@id=\"bb-main-content\"]/bb-panel-container/bb-area/bb-chrome/bb-deck-container/bb-route/bb-chrome/bb-panel-container/bb-area/bb-chrome/bb-deck-container/bb-route/bb-chrome/bb-panel-container/bb-area/bb-chrome[2]/bb-column-container/div/bb-column[1]/bb-chrome/bb-panel-container/bb-area/bb-chrome/bb-panel-container/bb-area/bb-chrome/bb-tab-container/div[2]/bb-route/bb-chrome/bb-panel-container/bb-area/bb-chrome/bb-panel-container/bb-area/bb-chrome/sba-bill-payments-widget/sba-sba-bill-payments-recharge/form/div[2]/bb-fieldset-ui/fieldset/div/div[6]/bb-button-ui/button")
    WebElement nextBtnRechargeable;

    @FindBy(xpath = "//*[@id=\"bb-main-content\"]/bb-panel-container/bb-area/bb-chrome/bb-deck-container/bb-route/bb-chrome/bb-panel-container/bb-area/bb-chrome/bb-deck-container/bb-route/bb-chrome/bb-panel-container/bb-area/bb-chrome[2]/bb-column-container/div/bb-column[1]/bb-chrome/bb-panel-container/bb-area/bb-chrome/bb-panel-container/bb-area/bb-chrome/bb-tab-container/div[2]/bb-route/bb-chrome/bb-panel-container/bb-area/bb-chrome/bb-panel-container/bb-area/bb-chrome/sba-bill-payments-widget/sba-sba-bill-payments-reference-payment/form/div[2]/bb-fieldset-ui/fieldset/div/div[6]/bb-button-ui/button")
    WebElement nextBtnReference;

    @FindBy(xpath = "//*[@id=\"bb-main-content\"]/bb-panel-container/bb-area/bb-chrome/bb-deck-container/bb-route/bb-chrome/bb-panel-container/bb-area/bb-chrome/bb-deck-container/bb-route/bb-chrome/bb-panel-container/bb-area/bb-chrome[2]/bb-column-container/div/bb-column[1]/bb-chrome/bb-panel-container/bb-area/bb-chrome/bb-panel-container/bb-area/bb-chrome/bb-tab-container/div[2]/bb-route/bb-chrome/bb-panel-container/bb-area/bb-chrome/bb-panel-container/bb-area/bb-chrome/sba-bill-payments-widget/sba-sba-bill-payments-state-payment/form/div[2]/bb-fieldset-ui/fieldset/div/div[7]/bb-button-ui/button")
    WebElement nextBtnStateConfig;

    @FindBy(xpath = "//*[@id=\"bb-main-content\"]/bb-panel-container/bb-area/bb-chrome/bb-deck-container/bb-route/bb-chrome/bb-panel-container/bb-area/bb-chrome/bb-deck-container/bb-route/bb-chrome/bb-panel-container/bb-area/bb-chrome[2]/bb-column-container/div/bb-column[1]/bb-chrome/bb-panel-container/bb-area/bb-chrome/bb-panel-container/bb-area/bb-chrome/bb-tab-container/div[2]/bb-route/bb-chrome/bb-panel-container/bb-area/bb-chrome/bb-panel-container/bb-area/bb-chrome/sba-bill-payments-widget/sba-sba-bill-payments-state-payment/form/div[2]/bb-fieldset-ui/fieldset/div/div[6]/bb-button-ui/button")
    WebElement nextBtnStateStandard;

    @FindBy(xpath = "//*[@id=\"bb-main-content\"]/bb-panel-container/bb-area/bb-chrome/bb-deck-container/bb-route/bb-chrome/bb-panel-container/bb-area/bb-chrome/bb-deck-container/bb-route/bb-chrome/bb-panel-container/bb-area/bb-chrome[2]/bb-column-container/div/bb-column[1]/bb-chrome/bb-panel-container/bb-area/bb-chrome/bb-panel-container/bb-area/bb-chrome/bb-tab-container/div[2]/bb-route/bb-chrome/bb-panel-container/bb-area/bb-chrome/bb-panel-container/bb-area/bb-chrome/sba-bill-payments-widget/sba-sba-bill-payments-review/div/div[2]/div[1]/div")
    WebElement paymentDetailsString;


    public void ClickBillPaymentsMenu() {
        sharedDriver.getWait().until(ExpectedConditions.visibilityOf(billPaymentsMenu)).click();
    }

    public void InputSearchBar(String entity) {
        sharedDriver.getWait().until(ExpectedConditions.visibilityOf(searchBar)).sendKeys(entity);
    }

    public void SelectFirstEntity() {
        sharedDriver.getWait().until(ExpectedConditions.visibilityOf(firstEntity)).click();
    }

    public void InsertReferenceRechargeable(String ref) {
        sharedDriver.getWait().until(ExpectedConditions.visibilityOf(reference)).sendKeys(ref);
    }

    public void SelectFirstAmountRechargeable() {
        sharedDriver.getWait().until(ExpectedConditions.visibilityOf(amountDropdownRechargeable)).click();
        sharedDriver.getWait().until(ExpectedConditions.visibilityOf(firstAmountRechargeable)).click();
    }

    public void SelectFirstAmountStateConfig() {
        sharedDriver.getWait().until(ExpectedConditions.visibilityOf(getAmountDropdownStateConfig)).click();
        sharedDriver.getWait().until(ExpectedConditions.visibilityOf(firstAmountStateConfig)).click();
    }

    public void ClickNextBtnRechargeable() {
        sharedDriver.getWait().until(ExpectedConditions.visibilityOf(nextBtnRechargeable)).click();
    }

    public void ClickNextBtnReference() {
        sharedDriver.getWait().until(ExpectedConditions.visibilityOf(nextBtnReference)).click();
    }

    public void ClickNextBtnStateConfig() {
        sharedDriver.getWait().until(ExpectedConditions.visibilityOf(nextBtnStateConfig)).click();
    }

    public void ClickNextBtnStateStandard() {
        sharedDriver.getWait().until(ExpectedConditions.visibilityOf(nextBtnStateStandard)).click();
    }

    public void ReviewPageCheck() {
        sharedDriver.getWait().until(ExpectedConditions.visibilityOf(paymentDetailsString));
    }

    public void InsertAmountReference(String amount) {
        sharedDriver.getWait().until(ExpectedConditions.visibilityOf(amountInputReference)).sendKeys(amount);
    }

    public void InsertAmountStateStandard(String amount) {
        sharedDriver.getWait().until(ExpectedConditions.visibilityOf(amountInputStateStandard)).sendKeys(amount);
    }
}