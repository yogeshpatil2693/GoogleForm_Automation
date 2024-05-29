
package googleform;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;




public class RegisterTest {

    RemoteWebDriver driver;
    

    
    @BeforeSuite
    public void setup(){

        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();

        // Set browser to maximize and wait
        driver.manage().window().maximize();
        driver.get("https://docs.google.com/forms/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/viewform");
    }


    @Test(priority = 1)
    public void enterName() throws InterruptedException{
        RegisterPage register = new RegisterPage(driver);
        
        register.enterName_Field(AppConstants.name);

    }

    @Test(priority = 2)
    public void enterReasonForAutowithEpoch() throws InterruptedException{
        RegisterPage register = new RegisterPage(driver);
        LocalDateTime obj = LocalDateTime.now();
		long epoch = obj.atZone(ZoneId.systemDefault()).toInstant().getEpochSecond();
		
        register.enterReasonEpoch(AppConstants.reason+" "+epoch);

    }

    @Test(priority = 3)
    public void selectExperienceRadioBtn(){
        RegisterPage register = new RegisterPage(driver);
        register.clickExperienceRadioBtn();
        
    }

    @Test(priority = 4)
    public void selectLearningCheckbox(){
        RegisterPage register = new RegisterPage(driver);
        register.clickLearningCheckBox();
    }

    @Test(priority = 5)
    public void adressDropDown() throws InterruptedException{
        RegisterPage register = new RegisterPage(driver);
        register.selectaddDropdown();
    }

    @Test(priority = 6)
    public void selectSevenDaysbeforeDate(){

        RegisterPage register = new RegisterPage(driver);
        LocalDate currentDate = LocalDate.now();
        LocalDate previousDate = currentDate.minusDays(7);

        DateTimeFormatter obj1 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String obj2 = previousDate.format(obj1);

        register.enterDate(obj2);
    }
        
        
    @Test(priority = 7)
    public void enterCurrentTime() throws InterruptedException{
        RegisterPage register = new RegisterPage(driver);
        LocalTime ct = LocalTime.now();
        String hour = ct.toString().split(":")[0];
        String minute = ct.toString().split(":")[1];
        register.entertime(hour,minute);

    }

    @Test(priority = 8)
    public void clickonSubmit(){
        RegisterPage register = new RegisterPage(driver);
        register.submitbtnclick();
    }

    @AfterSuite
    public void tearDown(){
        driver.quit();
    }
       
    
   
}
