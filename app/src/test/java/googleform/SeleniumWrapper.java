package googleform;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class SeleniumWrapper {

    public static boolean navigate(WebDriver driver, String url){
        if(!driver.getCurrentUrl().equals(url)){
            driver.navigate().to(url);
            return true;
        }else{
            return false;
        }
    }

    public static boolean sendkeys(WebElement element, String keys){
        element.clear();
        element.sendKeys(keys);
        return true;
    }

    public static boolean click(WebElement element){
        element.click();
        return true;
    }

}
