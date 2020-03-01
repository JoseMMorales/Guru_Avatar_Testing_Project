package room_module;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC2 {

  static WebDriver driver;
  
  public static void main(String[] args) throws IOException, Exception {
    System.setProperty("webdriver.chrome.driver", "/......../chromedriver");
    driver = new ChromeDriver();
    driver.navigate().to("https://www.myguruavatar.com/demo/");
    driver.manage().timeouts().implicitlyWait(2 , TimeUnit.SECONDS);
    driver.manage().window().fullscreen();
    
    WebElement Username = driver.findElement(By.xpath("//*[@id=\"modlgn-username\"]"));
    WebElement Password = driver.findElement(By.xpath("//*[@id=\"modlgn-passwd\"]"));
    WebElement Login = driver.findElement(By.xpath("//*[@id=\"hmelogin\"]"));
    
    if(Username.isDisplayed() & Username.isEnabled()){
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
    
    WebDriverWait wait1 = new WebDriverWait(driver, 2);
    WebElement Dropdown = wait1.until(ExpectedConditions.elementToBeClickable(By.id("swithbtn")));
    Dropdown.click();
    
    Thread.sleep(4000);
    
    takeScreenshot("TC2");
  }

  public static void takeScreenshot (String fileName) throws IOException {
    File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    FileUtils.copyFile(file, new File("/Users/jose/Desktop/Software Testing/Selenium/eclipse-workspace/Guru Avatar/Screenshots/"+fileName+".png"));
  }
}

