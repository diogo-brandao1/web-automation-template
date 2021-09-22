package Steps;

import Config.OSConfiguration;
import Config.ReadPropFile;
import Util.Aux;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class DriverConfigs {

    private static boolean initialized = false;
    private static Properties configProperties;

    private static WebDriver driver;
    private static WebDriverWait wait;
    private static int waitTimeOutInSeconds = 60;
    private static int implicitlyWaitTimeOutInSeconds = 60;

    private static String environmentDefault = "test";
    private static String headLessDefault = "false";
    private static String windowWidthDefault = "1920";
    private static String windowHeightDefault = "1080";
    private static String windowMaximizeDefault = "false";

    @Before
    public WebDriver setUp() throws Exception {
        configProperties = ReadPropFile.readPropertiesFiles(environmentDefault);
        driver = startWebDriver();
        ReadPropFile.printProperties(configProperties);
        return driver;
    }

    @After
    public void endTests(Scenario scenario) {
        afterScenario(scenario);
    }

    /**
     * Will check the variable "initialized", if is "true" will return the "driver",
     * if is "false" will check if the "browser" property is present on the command line to start the tests
     * if yes, will use it and update on the configProperties, if not, will search on the configProperties
     * Then will read on configuration properties the property "headless".
     * If the variable does not exist will update the configuration properties with the default value.
     * Then will read on configuration properties the property "window.width".
     * If the variable does not exist will update the configuration properties with the default value.
     * Then will read on configuration properties the property "window.height".
     * If the variable does not exist will update the configuration properties with the default value.
     * Then will read on configuration properties the property "window.maximize".
     * If the variable does not exist will update the configuration properties with the default value.
     * Then will select the browser from the configuration properties and setup is properties (and start headless if the variable on configuration properties is equal to true)
     * If the browser name is not recognized will throw an error.
     * Then will check if the variable "window.maximize" on configuration properties is equal to true, if is, will maximize the browser window,
     * if not, will read the variables "window.width" and "window.height" to set the size of the browser window
     * and then will set the "implicitlyWait" and the explicitly "wait"
     * @return driver
     * @throws Exception
     */
    private WebDriver startWebDriver() {
        if (!initialized) {
            //get browser
            String browser = System.getProperty("browser");
            if( browser != null && browser.length() > 0 ){
                configProperties.setProperty("browser", browser);
            }else{
                browser = configProperties.getProperty("browser");
            }

            String headLess = configProperties.getProperty("headless");
            String windowWidth = configProperties.getProperty("window.width");
            String windowHeight = configProperties.getProperty("window.height");
            String windowMaximize = configProperties.getProperty("window.maximize");

            headLess = ( headLess != null && headLess.length()>0 && Aux.isBoolean(headLess) ) ? headLess : headLessDefault;
            windowWidth = ( windowWidth != null && windowWidth.length()>0 && Aux.isNumeric(windowWidth) ) ? windowWidth : windowWidthDefault;
            windowHeight = ( windowHeight != null && windowHeight.length()>0 && Aux.isNumeric(windowHeight)) ? windowHeight : windowHeightDefault;
            windowMaximize = ( windowMaximize != null && windowMaximize.length()>0 && Aux.isBoolean(windowMaximize) ) ? windowMaximize : windowMaximizeDefault;

            configProperties.setProperty("headLess", headLess);
            configProperties.setProperty("window.width", windowWidth);
            configProperties.setProperty("window.height", windowHeight);
            configProperties.setProperty("window.maximize", windowMaximize);

            switch(browser.toLowerCase()) {
                case "chrome":
                    ChromeOptions options = new ChromeOptions();
                    if (headLess.equalsIgnoreCase("true")){
                        options.addArguments("--no-sandbox");
                        options.addArguments("--headless");
                        options.addArguments("--disable-gpu");
                        options.addArguments("window-size="+windowWidth+"x"+windowHeight);
                        if (OSConfiguration.getOS() == OSConfiguration.OS.LINUX) {
                            options.setBinary("/usr/bin/google-chrome");
                        } else {
                            options.setBinary("");
                        }
                    }

                    System.setProperty("webdriver.chrome.driver", configProperties.getProperty("chrome.driver"));
                    driver = new ChromeDriver(options);
                    break;

                case "firefox":
                    System.setProperty("webdriver.gecko.driver", configProperties.getProperty("firefox.driver"));
                    FirefoxBinary firefoxBinary = new FirefoxBinary();
                    if (headLess.equalsIgnoreCase("true")){
                        firefoxBinary.addCommandLineOptions("--headless");
                    }
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.setBinary(firefoxBinary);
                    driver = new FirefoxDriver(firefoxOptions);
                    break;

                case "edge":
                    // Set the driver path
                    System.setProperty("webdriver.edge.driver", configProperties.getProperty("edge.driver"));
                    EdgeOptions edgeOptions = new EdgeOptions();

                    if (headLess.equalsIgnoreCase("true")) {
                        try {
                            throw new Exception("EDGE does not have the HEADLESS configuration");
                        } catch (Exception e) {
                            e.printStackTrace();
                            System.exit(1);
                        }
                    }
                    driver = new EdgeDriver(edgeOptions);
                    break;

                default:
                    try {
                        throw new Exception("You need to select a valid browser");
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.exit(1);
                    }
            }

            if (windowMaximize.equalsIgnoreCase("true")){
                driver.manage().window().maximize();
            }else{
                if( Integer.parseInt(windowWidth) > 0 && Integer.parseInt(windowHeight) > 0 ){
                    Dimension d = new Dimension(Integer.parseInt(windowWidth),Integer.parseInt(windowHeight));
                    driver.manage().window().setSize(d);
                }
            }

            initialized = true;
            driver.manage().timeouts().implicitlyWait(implicitlyWaitTimeOutInSeconds, TimeUnit.SECONDS); // Set Find Element Timeout
            wait = new WebDriverWait(driver, waitTimeOutInSeconds);
        }
        return driver;
    }

    private void afterScenario(Scenario scenario) {
        initialized = false;
        driver.quit();
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public Properties getConfigProperties() {
        return configProperties;
    }

}
