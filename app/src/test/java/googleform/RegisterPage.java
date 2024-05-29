package googleform;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class RegisterPage {

    RemoteWebDriver driver;
   

    @FindBy(xpath = "(//input[@class='whsOnd zHQkBf'])[1]")
    WebElement name_field;

    @FindBy(xpath = "//textarea[@class='KHxj8b tL9Q4c']")
    WebElement reaEpoch_field;

    @FindBy(xpath = "//span[text()='0 - 2']/ancestor::div[@class='YEVVod']/preceding-sibling::div/descendant::div[@class='AB7Lab Id5V1']")
    WebElement expRadio_btn;

    @FindBy(xpath = "//span[text()='Java']//ancestor::div[@class='YEVVod']//preceding-sibling::div//div[@class='uHMk6b fsHoPb']")
    WebElement learningjava_checkbox;

    @FindBy(xpath = "//span[text()='Selenium']//ancestor::div[@class='YEVVod']//preceding-sibling::div//div[@class='uHMk6b fsHoPb']")
    WebElement learningselenium_checkbox;

    @FindBy(xpath = "//span[text()='TestNG']//ancestor::div[@class='YEVVod']//preceding-sibling::div//div[@class='uHMk6b fsHoPb']")
    WebElement learningtestng_checkbox;

    @FindBy(xpath = "//span[text()='Choose']")
    WebElement address_dropdownbtn;

    @FindBy(xpath = "(//div[@data-value='Mr'])[2]")
    WebElement mr_dropdown;

    @FindBy(xpath = "//input[@type='date']")
    WebElement date_field;

    @FindBy(xpath = "//input[@aria-label='Hour']")
    WebElement hour_field;

    @FindBy(xpath = "//input[@aria-label='Minute']")
    WebElement minute_field;

    @FindBy(xpath = "//span[text()='Submit']")
    WebElement submit_btn;

    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));

    public RegisterPage(RemoteWebDriver driver) {
        this.driver = driver;
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 20);
        PageFactory.initElements(factory, this);

    }

    public void navigateToGoogleForm(String url){
        driver.get(url);
     }

    public void enterName_Field(String keys) throws InterruptedException {
         Thread.sleep(3000);
         wait.until(ExpectedConditions.visibilityOf(name_field));
         SeleniumWrapper.sendkeys(name_field, keys);
    }

    public void enterReasonEpoch(String keys) throws InterruptedException{
        Thread.sleep(3000);
        SeleniumWrapper.sendkeys(reaEpoch_field, keys);
    }

    public void clickExperienceRadioBtn(){
        SeleniumWrapper.click(expRadio_btn);
    }

    public void clickLearningCheckBox(){
        
        SeleniumWrapper.click(learningjava_checkbox);
        SeleniumWrapper.click(learningselenium_checkbox);
        SeleniumWrapper.click(learningtestng_checkbox);
    }


    public void selectaddDropdown() throws InterruptedException{
       
        SeleniumWrapper.click(address_dropdownbtn);
        Thread.sleep(4000);
        SeleniumWrapper.click(mr_dropdown);
        Thread.sleep(4000);
    }

    public void enterDate(String keys){
        SeleniumWrapper.sendkeys(date_field, keys);
    }

    public void entertime(String key1, String key2){
        SeleniumWrapper.sendkeys(hour_field, key1);
        SeleniumWrapper.sendkeys(minute_field, key2);
    }

    public void submitbtnclick(){
        SeleniumWrapper.click(submit_btn);
    }

    




    
    
}
