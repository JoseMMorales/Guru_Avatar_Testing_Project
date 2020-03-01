package room_module;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TC4 {
  
  static WebDriver driver;
  
  public static void main(String[] args) throws Exception {
    System.setProperty("webdriver.chrome.driver", "/....................../chromedriver");
    driver = new ChromeDriver();
    driver.get("https://www.myguruavatar.com/demo/");
    driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
    
    WebElement Username = driver.findElement(By.xpath("//*[@id=\"modlgn-username\"]"));
    Username.sendKeys("josemulamorales33@hotmail.com");
    
    WebElement Password = driver.findElement(By.xpath("//*[@id=\"modlgn-passwd\"]"));
    Password.sendKeys("Jose Morales");
    
    WebElement Checkbutton = driver.findElement(By.xpath("//*[@id=\"login-form\"]/fieldset/div/p[1]/input"));
    Checkbutton.click();
  
    WebElement Login = driver.findElement(By.xpath("//*[@id=\"hmelogin\"]"));
    Login.click();
    
    Thread.sleep(2000);
        
    Actions actions = new Actions(driver);
        
    WebElement drop = driver.findElement(By.xpath("//*[@id=\"swithbtn\"]"));
    //drop.click();
    actions.moveToElement(drop).click().perform();
    
    WebElement Hover = driver.findElement(By.xpath("//*[@id=\"swithbtn\"]/option[2]"));
    //Hover.click();
    actions.moveToElement(Hover).perform();
    System.out.println("Done Mouse hover on Switch to Student");
    
    driver.quit();
  }
}
