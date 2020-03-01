package room_module;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC7 {
  
  static WebDriver driver;

  public static void main(String[] args) throws Exception {
    System.setProperty("webdriver.chrome.driver", "/........./chromedriver");
    driver = new ChromeDriver();
    driver.get("https://www.myguruavatar.com/demo/");
    driver.manage().timeouts().implicitlyWait( 2, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    
    WebElement Username = driver.findElement(By.xpath("//*[@id=\"modlgn-username\"]"));
    WebElement Password = driver.findElement(By.xpath("//*[@id=\"modlgn-passwd\"]"));
    WebElement Login = driver.findElement(By.xpath("//*[@id=\"hmelogin\"]"));
    
    if(Username.isDisplayed() & Username.isEnabled()) {
      Username.sendKeys("josemulamorales33@hotmail.com");
    }
    if(Password.isDisplayed() & Password.isEnabled()) {
      Password.sendKeys("Jose Morales");
    }
    if(driver.findElement(By.xpath("//*[@id=\"login-form\"]/fieldset/div/p[1]/input")).isSelected()==false) {
      driver.findElement(By.xpath("//*[@id=\"login-form\"]/fieldset/div/p[1]/input")).click();
    }
    if(Login.isDisplayed() & Login.isEnabled()) {
      Login.click();
    }

    Thread.sleep(3000);
    
    WebElement Switch = driver.findElement(By.xpath("//*[@id=\"swithbtn\"]"));
    Switch.click();
    
    WebElement Goto = driver.findElement(By.xpath("//*[@id=\"swithbtn\"]/option[2]"));
    Goto.click();
    
    Thread.sleep(3000); 
    
    String text = driver.findElement(By.xpath("//*[@id=\"menu2_section\"]/div/div/div[2]/p")).getText();
    System.out.println(text);
    
    driver.close();
  }
}
