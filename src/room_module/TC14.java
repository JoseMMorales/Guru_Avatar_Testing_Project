package room_module;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC14 {
  
  static WebDriver driver;

  public static void main(String[] args) throws Exception {
    System.setProperty("webdriver.chrome.driver", "/.........../chromedriver");
    driver = new ChromeDriver();
    driver.navigate().to("https://www.myguruavatar.com/demo/");
    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    driver.manage().window().fullscreen();
    
    WebElement Username = driver.findElement(By.xpath("//*[@id=\"modlgn-username\"]"));
    WebElement Password = driver.findElement(By.xpath("//*[@id=\"modlgn-passwd\"]"));
    
    if(Username.isDisplayed() && Username.isEnabled()){
      Username.sendKeys("josemulamorales33@hotmail.com");
    }
    if(Password.isDisplayed() && Password.isEnabled()) {
      Password.sendKeys("Jose Morales");	
    }
    
    WebElement Checkbutton = driver.findElement(By.xpath("//*[@id=\"login-form\"]/fieldset/div/p[1]/input"));
    Checkbutton.click();
  
    WebElement Login = driver.findElement(By.xpath("//*[@id=\"hmelogin\"]"));
    Login.click();
    
    Thread.sleep(3000);
    
    WebElement Switch = driver.findElement(By.xpath("//*[@id=\"swithbtn\"]"));
    Switch.click();
    
    WebElement Goto = driver.findElement(By.xpath("//*[@id=\"swithbtn\"]/option[2]"));
    Goto.click();
    
    Thread.sleep(2000);
    
    WebElement Like = driver.findElement(By.xpath("//*[@id=\"1293\"]"));
    Like.click();	
    
    Thread.sleep(2000);
                 
    if(driver.getPageSource().contains("Pofile Likes Detail")) {
      System.out.println("Test Passed!");
    }
    else {
      System.out.println("Test Failed!");
    }
    
    driver.close();
  }
}
